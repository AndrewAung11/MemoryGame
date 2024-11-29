package com.memory_game;

import javax.swing.*;

public class  TimerCont extends JLabel {
    // some static variables for easy use
    private javax.swing.Timer t = null;
    private final int[] time = {0, 0, 0};

    public TimerCont() {
        this.setText("00:00:00");
    }

    // updating the timer display label
    public void updateTimeDisplay (int[] timeArray) {
        StringBuilder timeString = new StringBuilder();
        for (int i : timeArray) {
            if (i < 10) {
                timeString.insert(0, String.format("0%s", i));
            } else {
                timeString.insert(0, i);
            }
        }
        timeString.insert(2, ":");
        timeString.insert(5, ":");
        this.setText(String.valueOf(timeString));
    }

    //Time intervals
    public void startTimer() {
        if (this.t == null) {
            this.t = new javax.swing.Timer(1000, e -> {
                this.time[0] = this.time[0] + 1;
                if (this.time[0] >= 60) {
                    this.time[1] = this.time[1] + 1;
                    this.time[0] = this.time[0] - 60;
                }
                if (this.time[1] >= 60) {
                    this.time[2] = this.time[2] + 1;
                    this.time[1] = this.time[1] - 60;
                }
                this.updateTimeDisplay(this.time);
            });
        }
        this.t.start();
    }

    // functions
    public void stopTimer() {
        this.t.stop();
    }
}
