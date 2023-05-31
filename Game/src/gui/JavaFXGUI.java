package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import logic.GUIConnector;
import logic.Tile;

import static logic.Tile.*;

public class JavaFXGUI implements GUIConnector {

    /**
     * Load all the images used in the game
     */
    private static final Image PURPLE = new Image("gui/img/Colors/Purple.png");
    private static final Image BLUE = new Image("gui/img/Colors/Blue.png");
    private static final Image GREEN = new Image("gui/img/Colors/Green.png");
    private static final Image DARK_GREEN = new Image("gui/img/Colors/Dark_Green.png");
    private static final Image LIGHT_PINK = new Image("gui/img/Colors/Light_Pink.png");
    private static final Image ORANGE = new Image("gui/img/Colors/Orange.png");
    private static final Image YELLOW = new Image("gui/img/Colors/Yellow.png");
    private static final Image PINK = new Image("gui/img/Colors/pink.png");
    private static final Image MAROON = new Image("gui/img/Colors/Maroon.png");


    ImageView[][] imageViewsMainField;

    public JavaFXGUI(ImageView[][] imageViewsMainField){
        this.imageViewsMainField = imageViewsMainField;
    }

    @Override
    public void addOnGui(int[][] positions, Tile tile) {
        Image image = getImage(tile);
        for(int i = 0; i < positions.length; i++){
            imageViewsMainField[positions[i][1]][positions[i][0]].setImage(image);
        }
    }

    private Image getImage(Tile tile){
        if(tile == TW0_X_1){
            return PURPLE;
        } else if(tile == TW0_X_2){
            return BLUE;
        } else if(tile == THREE_X_1){
            return ORANGE;
        } else if(tile == FOUR_X_1){
            return LIGHT_PINK;
        } else if(tile == L_GREEN){
            return GREEN;
        } else if(tile == L_PINK){
            return PINK;
        } else if(tile == S_SHAPE){
            return YELLOW;
        } else if(tile == SMALL_L){
            return MAROON;
        } else if(tile == T_SHAPE){
            return DARK_GREEN;
        }
        return null;
    }
}

