package com.memory_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBtn extends JButton implements ActionListener {
    private int i;
    private int j;
    private char chac;
    public GameBtn(int i, int j) {
        this.i = i;
        this.j = j;
        this.setText("");
        this.setFocusable(false);
        this.setEnabled(false);
    }

    public void gameStart(char text) {
        this.setEnabled(true);
        this.setFont(new Font("Consolas", Font.PLAIN, 20));
        this.setBackground(new Color(211, 204, 204));
        this.chac = text;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setText(String.format("%s", this.chac));
    }
}
