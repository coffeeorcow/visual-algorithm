package com.yi.chapter2.chapter2;

import javax.swing.*;

public class AlgoFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        setSize(canvasWidth, canvasHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

}
