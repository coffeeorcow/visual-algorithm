package com.yi.chapter4.chapter1;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

public class AlgoVisualizer {

    private SelectionSortData data;        // 数据
    private AlgoFrame frame;    // 视图
    private int delay = 100;

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
        data = new SelectionSortData(100, 300);

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
        int t;
        for (int i = 0; i < data.N(); i++) {
            frame.render(data);

            t = i;

            for (int j = i + 1; j < data.N(); j++) {
                if (data.get(j) < data.get(t))
                    t = j;
            }


            data.swap(i, t);
            AlgoVisHelper.pause(delay);
        }
    }

    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 500;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
