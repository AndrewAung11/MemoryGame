package com.memory_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBtn extends JButton implements ActionListener {
    private final int i;
    private final int j;
    private char chac;
    private Timer delay = null;
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

    public void done() {
        this.setBackground(new Color(43, 152, 6));
        this.setEnabled(false);
    }

    public void wrong() {
        this.setBackground(new Color(206, 19, 19));
        delay = new Timer(1000, e-> {
            reset();
        });
        delay.start();
    }

    private void reset() {
        delay.stop();
        this.setBackground(new Color(211, 204, 204));
        this.setText("");
        this.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setText(String.format("%s", this.chac));
        this.setEnabled(false);
        Main.gameS.generated.gameCheck(i ,j);
    }
}
