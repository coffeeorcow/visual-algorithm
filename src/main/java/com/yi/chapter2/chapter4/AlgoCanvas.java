package com.yi.chapter2.chapter4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoCanvas extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);

        Graphics2D g2d = (Graphics2D)g;

        int strokeWidth = 5;
        g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        g2d.setColor(Color.RED);
        Ellipse2D circle = new Ellipse2D.Double(50, 50, 300, 300);
        g2d.draw(circle);

        g2d.setColor(Color.BLUE);
        Ellipse2D circle2 = new Ellipse2D.Double(50, 50, 300, 300);
        g2d.fill(circle2);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Constant.width, Constant.height);
    }
}
