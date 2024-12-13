package com.memory_game;

import javax.swing.*;
import java.awt.*;

public class StartMenu extends JPanel {
    public StartMenu() {
        this.setPreferredSize(new Dimension(500, 200));

        // Header
        JPanel secTitle = new JPanel();
        secTitle.setPreferredSize(new Dimension(500, 75));
        JLabel title = new JLabel("Choose a mode:");
        title.setFont(new Font("Apotos", Font.PLAIN, 30));
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.CENTER);
        secTitle.add(title);

        //Buttons
        JPanel secButtons = new JPanel();
        secButtons.setPreferredSize(new Dimension(500, 100));
        secButtons.setLayout(new GridLayout(1, 3));

        final JButton[] modes = new JButton[3];
        String[] list = {"Easy", "Normal", "Difficult"};
        for (int i = 0; i < 3; i++) {
            modes[i] = new JButton(list[i]);

            int finalI = i;
            modes[i].addActionListener(e-> Main.changeToGame(finalI, true));

            modes[i].setFocusable(false);
            modes[i].setForeground(Color.black);
            modes[i].setBackground(Color.white);
            modes[i].setFont(new Font("Consolas", Font.PLAIN, 20));

            secButtons.add(modes[i]);
        }

        // Add for display
        this.add(secTitle);
        this.add(secButtons);
    }
}
