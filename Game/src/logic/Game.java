package logic;

import gui.JavaFXGUI;

import java.util.LinkedList;

import static logic.Tile.*;

public class Game {

    public static final int ROWS = 6;
    public static final int COLS = 6;

    JavaFXGUI gui;
    /**
     * Construct
     *
     * @param gui
     */
    public Game(JavaFXGUI gui) {
        this.gui = gui;
    }

    public Tile getTile(int shapeNum) {
        if (shapeNum == 0) {
            return TW0_X_1;
        } else if (shapeNum == 1) {
            return TW0_X_2;
        } else if (shapeNum == 2) {
            return THREE_X_1;
        } else if (shapeNum == 3) {
            return FOUR_X_1;
        } else if (shapeNum == 4) {
            return L_GREEN;
        } else if (shapeNum == 5) {
            return L_PINK;
        } else if (shapeNum == 6) {
            return S_SHAPE;
        } else if (shapeNum == 7) {
            return SMALL_L;
        } else {
            return T_SHAPE;
        }
    }

    public int[][] getCoOrdinates(int row, int col, Tile type, int rot, boolean[][] matrix, boolean isForRemove) {
        if(matrix[row][col] && !isForRemove){
            return null;
        }

        if (type == TW0_X_1 && rot == 0) {
            if (rot == 0 && isValidPosOnBoard(row, col + 1, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row, col + 1}
                };
            } else if (rot == 1 && isValidPosOnBoard(row + 1, col, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col}
                };
            } else {
                return null;
            }

        } else if (type == TW0_X_2) {
            if (rot == 0 && isValidPosOnBoard(row, col + 1, matrix, isForRemove) && isValidPosOnBoard(row + 1, col, matrix, isForRemove)
                    && isValidPosOnBoard(row + 1, col + 1, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col},
                        {row, col + 1},
                        {row + 1, col + 1}
                };
            } else return null;
        } else if (type == THREE_X_1) {
            if (rot == 0 && isValidPosOnBoard(row + 1, col, matrix, isForRemove) && isValidPosOnBoard(row + 2, col, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col},
                        {row + 2, col}
                };
            } else if (rot == 1 && isValidPosOnBoard(row, col + 1, matrix, isForRemove) && isValidPosOnBoard(row, col + 2, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row, col + 1},
                        {row, col + 2}
                };
            } else {
                return null;
            }
        } else if (type == FOUR_X_1) {
            if (rot == 0 && isValidPosOnBoard(row + 1, col, matrix, isForRemove) && isValidPosOnBoard(row + 2, col, matrix, isForRemove)
                    && isValidPosOnBoard(row + 3, col, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col},
                        {row + 2, col},
                        {row + 3, col}
                };
            } else if (rot == 1 && isValidPosOnBoard(row, col + 1, matrix, isForRemove) && isValidPosOnBoard(row, col + 2, matrix, isForRemove)
                    && isValidPosOnBoard(row, col + 3, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row, col + 1},
                        {row, col + 2},
                        {row, col + 3}
                };
            } else {
                return null;
            }
        } else if (type == L_GREEN) {
            if (rot == 0 && isValidPosOnBoard(row + 1, col, matrix, isForRemove) && isValidPosOnBoard(row + 2, col, matrix, isForRemove)
                    && isValidPosOnBoard(row + 2, col - 1, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col},
                        {row + 2, col},
                        {row + 2, col - 1}
                };
            } else if (rot == 1 && isValidPosOnBoard(row + 1, col, matrix, isForRemove) && isValidPosOnBoard(row + 1, col + 1, matrix, isForRemove)
                    && isValidPosOnBoard(row + 1, col + 2, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col},
                        {row + 1, col + 1},
                        {row + 1, col + 2}
                };
            } else if (rot == 2 && isValidPosOnBoard(row, col + 1, matrix, isForRemove) && isValidPosOnBoard(row + 1, col, matrix, isForRemove)
                    && isValidPosOnBoard(row + 2, col, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row, col + 1},
                        {row + 1, col},
                        {row + 2, col}
                };
            } else if (rot == 3 && isValidPosOnBoard(row, col + 1, matrix, isForRemove) && isValidPosOnBoard(row, col + 2, matrix, isForRemove)
                    && isValidPosOnBoard(row + 1, col + 2, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row, col + 1},
                        {row, col + 2},
                        {row + 1, col + 2}
                };
            } else {
                return null;
            }
        } else if (type == L_PINK) {
            if (rot == 0 && isValidPosOnBoard(row + 1, col, matrix, isForRemove) && isValidPosOnBoard(row + 2, col, matrix, isForRemove)
                    && isValidPosOnBoard(row + 2, col + 1, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col},
                        {row + 2, col},
                        {row + 2, col + 1}
                };
            } else if (rot == 1 && isValidPosOnBoard(row, col + 1, matrix, isForRemove) && isValidPosOnBoard(row, col + 2, matrix, isForRemove)
                    && isValidPosOnBoard(row + 1, col, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row, col + 1},
                        {row, col + 2},
                        {row + 1, col}
                };
            } else if (rot == 2 && isValidPosOnBoard(row, col + 1, matrix, isForRemove) && isValidPosOnBoard(row + 1, col + 1, matrix, isForRemove)
                    && isValidPosOnBoard(row + 2, col + 1, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row, col + 1},
                        {row + 1, col + 1},
                        {row + 2, col + 1}
                };
            } else if (rot == 3 && isValidPosOnBoard(row + 1, col, matrix, isForRemove) && isValidPosOnBoard(row + 1, col - 1, matrix, isForRemove)
                    && isValidPosOnBoard(row + 1, col - 2, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col},
                        {row + 1, col - 1},
                        {row + 1, col - 2}
                };
            } else {
                return null;
            }
        } else if (type == S_SHAPE) {
            if (rot == 0 && isValidPosOnBoard(row, col + 1, matrix, isForRemove) && isValidPosOnBoard(row + 1, col, matrix, isForRemove)
                    && isValidPosOnBoard(row + 1, col - 1, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row, col + 1},
                        {row + 1, col},
                        {row + 1, col - 1}
                };
            } else if (rot == 1 && isValidPosOnBoard(row + 1, col, matrix, isForRemove) && isValidPosOnBoard(row + 1, col + 1, matrix, isForRemove)
                    && isValidPosOnBoard(row + 2, col + 1, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col},
                        {row + 1, col + 1},
                        {row + 2, col + 1}
                };
            } else {
                return null;
            }
        } else if (type == SMALL_L) {
            if (rot == 0 && isValidPosOnBoard(row + 1, col, matrix, isForRemove) && isValidPosOnBoard(row + 1, col + 1, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col},
                        {row + 1, col + 1}
                };
            } else if (rot == 1 && isValidPosOnBoard(row, col + 1, matrix, isForRemove) && isValidPosOnBoard(row + 1, col, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row, col + 1},
                        {row + 1, col}
                };
            } else if (rot == 2 && isValidPosOnBoard(row, col + 1, matrix, isForRemove) && isValidPosOnBoard(row + 1, col + 1, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row, col + 1},
                        {row + 1, col + 1}
                };
            } else if (rot == 3 && isValidPosOnBoard(row + 1, col, matrix, isForRemove) && isValidPosOnBoard(row + 1, col - 1, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col},
                        {row + 1, col - 1}
                };
            } else {
                return null;
            }
        } else if (type == T_SHAPE) {
            if (rot == 0 && isValidPosOnBoard(row, col + 1, matrix, isForRemove) && isValidPosOnBoard(row, col + 2, matrix, isForRemove)
                    && isValidPosOnBoard(row + 1, col + 1, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row, col + 1},
                        {row, col + 2},
                        {row + 1, col + 1}
                };
            } else if (rot == 1 && isValidPosOnBoard(row + 1, col, matrix, isForRemove) && isValidPosOnBoard(row + 1, col - 1, matrix, isForRemove)
                    && isValidPosOnBoard(row + 2, col, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col},
                        {row + 1, col - 1},
                        {row + 2, col}
                };
            } else if (rot == 2 && isValidPosOnBoard(row + 1, col, matrix, isForRemove) && isValidPosOnBoard(row + 1, col - 1, matrix, isForRemove)
                    && isValidPosOnBoard(row + 1, col + 1, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col},
                        {row + 1, col - 1},
                        {row + 1, col + 1}
                };
            } else if (rot == 3 && isValidPosOnBoard(row + 1, col, matrix, isForRemove) && isValidPosOnBoard(row + 1, col + 1, matrix, isForRemove)
                    && isValidPosOnBoard(row + 2, col, matrix, isForRemove)) {
                return new int[][]{
                        {row, col},
                        {row + 1, col},
                        {row + 1, col + 1},
                        {row + 2, col}
                };
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    boolean isValidPosOnBoard(int row, int col, boolean[][] matrix, boolean isForRemove) {
        if(isForRemove){
            return isOnBoard(row, col);
        } else {
            return isOnBoard(row, col) && !hasShape(row, col, matrix);
        }
    }

    public boolean hasShape(int row, int col, boolean[][] matrix) {
        return matrix[row][col];
    }

    boolean isOnBoard(int row, int col) {
        return row > -1 && col > -1 && row < ROWS && col < COLS;
    }

    public void clearBoard() {
        this.matrixFromGui = new boolean[][]{
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false}
        };
    }

    boolean[][] matrixFromGui = new boolean[][]{
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, false},
    };

    public void handleSolve(int[][] frogPos){
        for(int i = 0; i < frogPos.length; i++){
            matrixFromGui[frogPos[i][0]][frogPos[i][1]] = true;
            System.out.println(frogPos[i][0] + " : :" + frogPos[i][1]);
        }
        solve2(0, 0, Tile.values(), solutionTile, matrixFromGui);

        int countForTile = 8;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(!matrixFromGui[i][j]){
                    Tile tile = tiles[countForTile];
                    int rot = rotations[countForTile];

                    int[][] pos = getCoOrdinates(i, j, tile, rot, matrixFromGui, false);
                    // get last solution tile and rotation and set it on logic
                    setPositionOnBoard(pos);
                    // set it on gui
                    gui.addOnGui(pos, tile);
                    countForTile--;
                }
            }
        }

    }

    public void setPositionOnBoard(int[][] positions){
        for(int i = 0; i < positions.length; i++){
            matrixFromGui[positions[i][0]][positions[i][1]] = true;
        }
    }

    LinkedList<Tile> solutionTile = new LinkedList<>();
    LinkedList<Integer> solutionRol = new LinkedList<>();
    Tile[] tiles = new Tile[9];
    int[] rotations = new int[9];

    public boolean solve2(int row, int col, Tile[] allTiles, LinkedList<Tile> solutionT, boolean[][] matrix){
        if(row == 5 && col == 6){
            for(int i = 0; i < 9; i++){
                tiles[i] = solutionTile.get(i);
                rotations[i] = solutionRol.get(i);
            }
        }
        if(col == 6){
            col = 0;
            row = row + 1;
            if(row == 6){
                if(allPositionAreSet(matrix)){
                    return true;
                }
            }
        }
        if(!matrix[row][col]){
            for(int i = 0; i < allTiles.length; i++){
                for(int j = 0; j < allTiles[i].value; j++){
                    if(isPossible(solutionT, row, col, allTiles[i], j, matrix)){
                        // add that tile to the position
                        setPositionOnBoard(matrix, getCoOrdinates(row, col, allTiles[i], j, matrix, false));
                        solutionT.push(allTiles[i]);
                        solutionRol.push(j);
                        if(solve2(row, col + 1, allTiles, solutionT, matrix)){
                            return true;
                        } else {
                            if(solutionT.size() != 0){
                                Tile tileToPass = solutionT.peek();
                                solutionT.remove(tileToPass);
                                int rot = solutionRol.peek();
                                removePositions(i, j, getCoOrdinates(row, col, tileToPass, solutionRol.pop(), matrix, true), matrix);
                            }
                        }
                    }
                }
            }
        } else {
            solve2(row, col+1, allTiles, solutionT, matrix);
        }
        return false;
    }

    public boolean allPositionAreSet(boolean[][] matrixFromGui){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(!matrixFromGui[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public LinkedList<Tile> addTileToSol(Tile tile, int rot, LinkedList<Tile> solutionTile,  LinkedList<Integer> solutionRol){
        solutionTile.push(tile);
        solutionRol.push(rot);
        return solutionTile;
    }
    public void removeTile(Tile tile, LinkedList<Tile> solutionT){
        solutionT.remove(tile);
    }

    public boolean[][] setPositionOnBoard(boolean[][] matrixFromGui ,int[][] positions){
        for(int i = 0; i < positions.length; i++){
            matrixFromGui[positions[i][0]][positions[i][1]] = true;
        }
        return matrixFromGui;
    }
    public boolean[][] removePositions(int row, int col, int[][] positions, boolean[][] matrix){
        if(positions != null){
            for(int i = 0; i < positions.length; i++){
                matrix[positions[i][0]][positions[i][1]] = false;
            }
        }
        return matrix;
    }

    boolean isPossible(LinkedList<Tile> solutionTile, int row, int col, Tile tile, int rot, boolean[][] matrix){
        return !solutionTile.contains(tile) && getCoOrdinates(row, col, tile, rot, matrix, false) != null;
    }
}
