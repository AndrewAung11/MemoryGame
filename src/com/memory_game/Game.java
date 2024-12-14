package com.memory_game;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel{

    private final JPanel leftSide = new JPanel();
    private final JPanel rightSide  = new JPanel();

    private int width;
    private int height;
    private final int option;
    public TimerCont timerWork;
    public GameGen generated;

    public Game(int option) {
        this.option = option;
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


    // Modes
    private void easy() {
        leftSide.setPreferredSize(new Dimension(width-150, height));
        rightSide.setPreferredSize(new Dimension(150, height));
        infoSec();
        game();
    }

    private void normal() {
        leftSide.setPreferredSize(new Dimension(width-150, height));
        rightSide.setPreferredSize(new Dimension(150, height));
        infoSec();
        game();
    }

    private void difficult() {
        leftSide.setPreferredSize(new Dimension(width-150, height));
        rightSide.setPreferredSize(new Dimension(150, height));
        infoSec();
        game();
    }

    // display
    private void infoSec() {
        rightSide.setLayout(new GridLayout(3, 1));

        JPanel timerSec = new JPanel();
        JLabel timerLabel = new JLabel("Timer:");
        timerLabel.setFont(new Font("Apotos", Font.PLAIN, 20));
        this.timerWork = new TimerCont();
        timerWork.setFont(new Font("Consolas", Font.PLAIN, 20));
        timerSec.setLayout(new GridLayout(4, 1));
        timerSec.add(timerLabel);
        timerSec.add(timerWork);
        timerSec.add(new JPanel());
        timerSec.add(new JPanel());

        JPanel buttonSec = new JPanel();
        JButton startBtn = new JButton("Start");
        startBtn.setForeground(Color.black);
        startBtn.setBackground(Color.white);
        startBtn.setFont(new Font("Arial", Font.PLAIN, 30));
        startBtn.addActionListener(e -> {
            generated.startGame();
            timerWork.startTimer();
            startBtn.setEnabled(false);
        });
        buttonSec.setLayout(new GridLayout(3, 1));
        buttonSec.add(new JPanel());
        buttonSec.add(startBtn);

        rightSide.add(timerSec);
        rightSide.add(new JPanel());
        rightSide.add(buttonSec);
    }

    private void game() {
        leftSide.setLayout(new GridLayout(1, 1));
        generated = new GameGen(option);
        leftSide.add(generated);
    }
}
