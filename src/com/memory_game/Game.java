package com.memory_game;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel{

    private static final JPanel leftSide = new JPanel();
    private static final JPanel rightSide  = new JPanel();

    private static int width;
    private static int height;

    public Game(int option) {
        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        this.setLayout(layout);
        if (option == 0) {
            width = 600;
            height = 500;
            this.setPreferredSize(new Dimension(width, height));
            this.easy();
        } else if (option == 1) {
            width = 900;
            height = 600;
            this.setPreferredSize(new Dimension(width, height));
            this.normal();
        } else if (option == 2) {
            width = 1000;
            height = 700;
            this.setPreferredSize(new Dimension(width, height));
            this.difficult();
        }
        this.add(leftSide);
        this.add(rightSide);
    }

    private void easy() {
        leftSide.setPreferredSize(new Dimension(width-150, height));
        rightSide.setPreferredSize(new Dimension(150, height));
    }

    private void normal() {
        leftSide.setPreferredSize(new Dimension(width-150, height));
        rightSide.setPreferredSize(new Dimension(150, height));
    }

    private void difficult() {
        leftSide.setPreferredSize(new Dimension(width-150, height));
        rightSide.setPreferredSize(new Dimension(150, height));
    }
}
