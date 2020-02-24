package com.yi.chapter3.chapter3;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

public class AlgoVisualizer {

    private List<Point> points;        // 数据
    private Circle circle;
    private int N;
    private AlgoFrame frame;    // 视图
    private static int DELAY = 20;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){

        // 初始化数据
        this.points = new ArrayList<>();
        this.circle = new Circle(sceneWidth / 2, sceneHeight / 2, sceneWidth / 2);
        this.N = N;

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        for (int i = 0; i < N; i++) {
            frame.render(circle, points);
            AlgoVisHelper.pause(DELAY);

            int x = (int) (Math.random() * frame.getCanvasWidth());
            int y = (int) (Math.random() * frame.getCanvasHeight());

            points.add(new Point(x, y));
        }

    }

    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 50000;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
