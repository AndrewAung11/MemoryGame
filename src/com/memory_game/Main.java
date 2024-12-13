package com.memory_game;

import javax.swing.*;

public class Main {

    public static JFrame f;

    private static StartMenu startMenuS;
    public static Game gameS;

    public static void main(String[] args) {
        Main.f = new JFrame("Memory game");

        startMenuS = new StartMenu();
        Main.f.add(startMenuS);

        Main.f.setVisible(true);
        Main.f.setSize(1000, 1000);
        Main.f.setResizable(false);
        Main.f.setLocationRelativeTo(null);
        Main.f.pack();
    }

    public static void changeToGame(int option, boolean start) {
        if (!start) { // clear previous values
            Main.f.remove(gameS);
            gameS = null;
            System.gc();
        } else {
            Main.f.remove(startMenuS);
        }

        gameS = new Game(option);
        Main.f.add(gameS);
        Main.f.pack();
    }

    public static void Start() {
        // clear previous values
        Main.f.remove(gameS);
        gameS = null;
        System.gc();

        Main.f.add(startMenuS);
        Main.f.pack();
    }
}