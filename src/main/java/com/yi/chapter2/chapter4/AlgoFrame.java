package com.yi.chapter2.chapter4;

import javax.swing.*;

public class AlgoFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        setContentPane(new AlgoCanvas());
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

}
