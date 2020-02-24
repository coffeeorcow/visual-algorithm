package com.yi.chapter2.chapeter7;

import javax.swing.*;
import java.awt.*;

public class AlgoFrame extends JFrame {

    private int width;
    private int height;

    public AlgoFrame(String title, int width, int height) {
        super(title);

        this.width = width;
        this.height = height;

        setContentPane(new AlgoCanvas());
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    private Circle[] circles;

    public void render(Circle[] circles) {
        this.circles = circles;
        repaint();
    }

    private class AlgoCanvas extends JPanel {

        public AlgoCanvas() {
            super(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            AlgoVisHelper.setStrokeWidth(g2d, 5);
            AlgoVisHelper.setColor(g2d, Color.RED);
            for (Circle circle : circles) {
                if (circle.isFilled) {
                    AlgoVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
                } else {
                    AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(width, height);
        }
    }

}
