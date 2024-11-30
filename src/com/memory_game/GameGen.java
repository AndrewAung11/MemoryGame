package com.memory_game;

import javax.swing.*;
import java.awt.*;

public class GameGen extends JPanel {

    private int rows;
    private int columns;
    private JButton[][] buttons;

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
}
