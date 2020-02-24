package com.yi.chapter2.chapeter7;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlgoVisualizer {

    private AlgoFrame frame;
    private Circle[] circles;
    private int width = 800;
    private int height = 800;

    private class AlgoMouseListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
//            e.translatePoint(0, -(frame.getBounds().height - height));
            for (Circle c : circles) {
                if (c.contain(e.getPoint())) {
                    c.isFilled = !c.isFilled;
                }
            }
        }
    }

    public void run() {
        int N = 10;
        int R = 50;
        circles = new Circle[N];
        for (int i = 0; i < N; i++) {
            int x = (int) (Math.random() * (width - 2 * R)) + R;
            int y = (int) (Math.random() * (height - 2 * R)) + R;
            int vx = (int) (Math.random() * 11) - 5;
            int vy = (int) (Math.random() * 11) - 5;
            circles[i] = new Circle(x, y, R, vx, vy);
        }


        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", width, height);
            frame.addMouseListener(new AlgoMouseListener());

            new Thread(() -> {
                while (true) {
                    frame.render(circles);
                    AlgoVisHelper.pause(20);

                    for (Circle c : circles) {
                        c.move(0, 0, width, height);
                    }
                }
            }).start();

        });
    }

}
