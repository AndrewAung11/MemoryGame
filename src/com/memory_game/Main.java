package com.memory_game;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static JFrame f;

    public static void main(String[] args) {
        Main.f = new JFrame("Memory game");



        Main.f.setVisible(true);
        Main.f.setSize(500, 500);
        Main.f.setResizable(false);
        Main.f.setLocationRelativeTo(null);
        Main.f.pack();
    }


}