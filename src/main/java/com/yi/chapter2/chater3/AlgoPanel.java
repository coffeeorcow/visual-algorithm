package com.yi.chapter2.chater3;

import javax.swing.*;
import java.awt.*;

public class AlgoPanel extends JPanel {

    private int width;
    private int height;

    public AlgoPanel(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawOval(50, 50, 300, 300);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
}
