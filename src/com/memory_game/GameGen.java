package com.memory_game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameGen extends JPanel {

    private int rows;
    private int columns;
    private GameBtn[][] buttons;
    private char[][] values;

    public GameGen(int option) {
        switch (option) {
            case 0 -> easy();
            case 1 -> normal();
            case 2 -> difficult();
        }
    }

    private void easy() {
        // rows and columns specifier for the buttons
        this.rows = 4;
        this.columns = 3;
        this.buttons = new GameBtn[this.rows][this.columns];

        this.setLayout(new GridLayout(this.rows, this.columns));

        // initial button set
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                this.buttons[i][j] = new GameBtn(i, j);
                this.add(this.buttons[i][j]);
            }
        }
    }

    private void normal() {
        // rows and columns specifier for the buttons
        this.rows = 5;
        this.columns = 4;
        this.buttons = new GameBtn[this.rows][this.columns];

        this.setLayout(new GridLayout(this.rows, this.columns));

        // initial button set
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                this.buttons[i][j] = new GameBtn(i, j);
                this.add(this.buttons[i][j]);
            }
        }
    }

    private void difficult() {
        // rows and columns specifier for the buttons
        this.rows = 10;
        this.columns = 10;
        this.buttons = new GameBtn[this.rows][this.columns];

        this.setLayout(new GridLayout(this.rows, this.columns));

        // initial button set
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                this.buttons[i][j] = new GameBtn(i, j);
                this.add(this.buttons[i][j]);
            }
        }
    }

    // game functions
    public void startGame() {
        // ASCII code boundaries for set of actual symbols
        int min = 33, max = 126;

        values = new char[rows][columns];
        char[] valueSet = new char[(rows*columns)/2]; // value for each pair of button
        int[] validity = new int[valueSet.length]; // pair fulfillment count

        int[] discardedASCII = new int[valueSet.length]; // used ascii codes list
        for (int i = 0; i < valueSet.length; i++) {
            int j = rolling((max - min  + 1), discardedASCII) + min;
            discardedASCII[i] = j;
            valueSet[i] = (char) j; // ascii code to character
            validity[i] = 2; // assign pair fulfillment initial value
        }


        int[] discardedI = new int[validity.length]; // indexes of used characters from valueSet
        for (int i = 0; i < valueSet.length; i++) {
            discardedI[i] = -1;
        }

        int index2 = 0; // progression count in former array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int num = rolling(valueSet.length, discardedI);
                values[i][j] = valueSet[num]; // assign to buttons
                validity[num] = validity[num] - 1; // fulfillment count
                if (validity[num] == 0) {  // fulfillment check
                    discardedI[index2] = num;
                    index2 = index2 + 1;
                }
                buttons[i][j].gameStart(values[i][j]);
            }
        }
    }

    // generate an unused random number by checking with list
    private static int rolling(int bound, int[] set) {
        Random rand = new Random();
        boolean safe = false;
        int num = rand.nextInt(bound);
        for (int i : set) {
            if (num == i) {
                return rolling(bound, set);
            } else {
                safe = true;
            }
        }
        if (safe) {
            return num;
        }
        return -1;
    }

    // game check
    private int buttonIndex = 0;
    private final int[] previousClicked = new int[] {-1, -1};
    private int completed = 0;
    public void gameCheck(int i, int j) {
        if (buttonIndex == 0) {
            previousClicked[0] = i;
            previousClicked[1] = j;
            buttonIndex = 1;
        } else if (buttonIndex == 1) {
            int Pi = previousClicked[0], Pj = previousClicked[1];
            if (values[i][j] == values[Pi][Pj]) {
                buttons[i][j].done();
                buttons[Pi][Pj].done();
                if (completed == (rows*columns)/2 ) {
                    // timer stop
                    // dialog appear -> allow to go back to main menu
                    // save the time
                } else {
                    completed++;
                }
            } else {
                buttons[i][j].wrong();
                buttons[Pi][Pj].wrong();
            }
            previousClicked[0] = -1;
            previousClicked[1] = -1;
            buttonIndex = 0;
        }
    }
}
