package com.memory_game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class GameGen extends JPanel {

    private int rows;
    private int columns;
    private JButton[][] buttons;
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
        this.buttons = new JButton[this.rows][this.columns];

        this.setLayout(new GridLayout(this.rows, this.columns));

        // initial button set
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                this.buttons[i][j] = new JButton("");
                this.add(this.buttons[i][j]);
            }
        }
    }

    private void normal() {
        // rows and columns specifier for the buttons
        this.rows = 5;
        this.columns = 4;
        this.buttons = new JButton[rows][columns];

        this.setLayout(new GridLayout(this.rows, this.columns));

        // initial button set
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                this.buttons[i][j] = new JButton("");
                this.add(this.buttons[i][j]);
            }
        }
    }

    private void difficult() {
        // rows and columns specifier for the buttons
        this.rows = 10;
        this.columns = 10;
        this.buttons = new JButton[this.rows][this.columns];

        this.setLayout(new GridLayout(this.rows, this.columns));

        // initial button set
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.columns; j++) {
                this.buttons[i][j] = new JButton("");
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
        int index2 = 0; // progression count in former array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int num = rolling(valueSet.length, discardedI);
                values[i][j] = valueSet[num]; // assign to buttons
                validity[num]--; // fulfillment count
                if (validity[num] == 0) {  // fulfillment check
                    discardedI[index2] = num;
                    index2++;
                }

                // setting assigned button properties
                buttons[i][j].setBackground(new Color(211, 204, 204));
            }
        }
    }

    // generate an unused random number by checking with list
    private static int rolling(int bound, int[] set) {
        Random rand = new Random();
        int num = rand.nextInt(bound);
        for (int j : set) {
            if (j == num) {
                return rolling(bound, set);
            } else {
                return num;
            }
        }
        return num;
    }
}
