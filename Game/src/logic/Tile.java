package logic;

import javafx.scene.image.Image;

public enum Tile {
    TW0_X_1(2), TW0_X_2(1), THREE_X_1(2), FOUR_X_1(2),
    L_GREEN(4), L_PINK(4), S_SHAPE(2), SMALL_L(4), T_SHAPE(4);

    int value;

    Tile(int value){
        this.value = value;
    }
}
