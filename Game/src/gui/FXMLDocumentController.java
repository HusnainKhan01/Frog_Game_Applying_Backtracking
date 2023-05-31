package gui;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import logic.Game;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * The FXMLDocumentController implements Initializable. Add the appropriate code to initialize(..) so that can
 * immediatly start playing once the program is running.
 * In the FXMLDocumentController the following have to exist:
 * *
 * @author husnain
 */
public class FXMLDocumentController implements Initializable {

    public static final int MAX_FROGS = 4;

    int[][] frogPositions = new int[MAX_FROGS][2];

    private static final Image FROG = new Image("gui/img/Frog.png");

    int frogCount = 0;

    public JavaFXGUI gui;

    private Game game;

    /** GridPane for the Main field of the game */
    public GridPane gridPaneField;

    /** Image Views of the Main field */
    ImageView[][] imageViewsField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageViewsField = initImages(gridPaneField);

        gui = new JavaFXGUI(imageViewsField);
        game = new Game(gui);
    }

    /**
     * @param grdPn
     * @return
     */
    private ImageView[][] initImages(GridPane grdPn) {
        int colcount = grdPn.getColumnConstraints().size();
        int rowcount = grdPn.getRowConstraints().size();
        ImageView[][] imageViews = new ImageView[colcount][rowcount];
        // bind each Imageview to a cell of the gridpane
        int cellWidth = (int) grdPn.getWidth() / colcount;
        int cellHeight = (int) grdPn.getHeight() / rowcount;
        for (int x = 0; x < colcount; x++) {
            for (int y = 0; y < rowcount; y++) {
                //creates an empty imageview
                imageViews[x][y] = new ImageView();
                //image has to fit a cell and mustn't preserve ratio
                imageViews[x][y].setFitWidth(cellWidth);
                imageViews[x][y].setFitHeight(cellHeight);
                imageViews[x][y].setPreserveRatio(false);
                imageViews[x][y].setSmooth(true);
                //assign the correct indicees for this imageview
                GridPane.setConstraints(imageViews[x][y], x, y);
                //add the imageview to the cell
                grdPn.add(imageViews[x][y], x, y);
                //the image shall resize when the cell resizes
                imageViews[x][y].fitWidthProperty().bind(grdPn.widthProperty().divide(colcount));
                imageViews[x][y].fitHeightProperty().bind(grdPn.heightProperty().divide(rowcount));
            }
        }
        return imageViews;
    }

    /********************************************************/
    /********************************************************/
    /****************** All On Action Methods ***************/

    public int[] onMouseClickForAll(MouseEvent mouseEvent, GridPane gridPane){
        int col = -1;
        int row = -1;
        boolean leftClicked = mouseEvent.getButton() == MouseButton.PRIMARY;
        boolean rightClicked = mouseEvent.getButton() == MouseButton.SECONDARY;
        //determine the imageview of the grid that contains the coordinates of the mouseclick
        //to determine the board-coordinates
        for (Node node : gridPane.getChildren()) {
            if (node instanceof ImageView) {
                if (node.getBoundsInParent().contains(mouseEvent.getX(), mouseEvent.getY())) {
                    //to use following methods the columnIndex and rowIndex
                    //must have been set when adding the imageview to the grid
                    col = GridPane.getColumnIndex(node);
                    row = GridPane.getRowIndex(node);
                }
            }
        }
        assert (col >= 0 && row >= 0) : "dem Klick ist keine Koordinate zuzuordnen";
        System.out.println("clicked on " + row + " " + col);
        if (leftClicked) {
            System.out.println(" left click ...");
        } else if (rightClicked) {
            System.out.println("Right click...");
        }
        return new int[] {row, col};
    }

    public void onMouseClickedField(MouseEvent mouseEvent) {
        int[] pos = onMouseClickForAll(mouseEvent, gridPaneField);
        System.out.println(pos[0] + "   " + pos[1]);
        if(frogCount < MAX_FROGS){
            imageViewsField[pos[1]][pos[0]].setImage(FROG);
//            game.addFrogOnBoard(pos[0], pos[1]);
            frogPositions[frogCount][0] = pos[0];
            frogPositions[frogCount][1] = pos[1];
            frogCount++;
        }
    }

    public void onClearAllFrogs(ActionEvent actionEvent) {
        frogCount = 0;
        for(int i = 0; i < imageViewsField.length; i++){
            for(int j = 0; j < imageViewsField.length; j++){
                imageViewsField[i][j].setImage(null);
            }
        }
        game.clearBoard();
    }

    /**
     * Called on solve button
     * @param actionEvent
     */
    public void solveGame(ActionEvent actionEvent) {
        System.out.println(" solve game");
        if(frogCount == MAX_FROGS){
            game.handleSolve(frogPositions);
            frogCount = 0;
        }
    }

    /********************************************************/
    /********************************************************/
}
