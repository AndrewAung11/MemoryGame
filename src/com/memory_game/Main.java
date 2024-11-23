package com.memory_game;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static JFrame f;

    private static StartMenu startMenuS;
    private static Game gameS;

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

    public static void changeToGame(int option) {
        Main.f.remove(startMenuS);

        gameS = new Game(option);
        Main.f.add(gameS);
        Main.f.pack();
    }
}