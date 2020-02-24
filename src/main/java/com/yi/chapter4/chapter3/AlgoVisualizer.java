package com.yi.chapter4.chapter3;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

public class AlgoVisualizer {

    private InsertionSortData data;        // 数据
    private AlgoFrame frame;    // 视图
    private int delay = 30;

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
        data = new InsertionSortData(100, 300);

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
        for (int i = 0; i < data.N(); i++) {
            setData(i, i + 1);
            for (int j = i; j > 0 && data.get(j) < data.get(j - 1); j--) {
                data.swap(j, j - 1);
                setData(i + 1, j - 1);
            }
        }

        setData(data.N(), -1);
    }

    private void setData(int orderIndex, int currentIndex) {
        data.orderIndex = orderIndex;
        data.currentIndex = currentIndex;

        frame.render(data);
        AlgoVisHelper.pause(delay);
    }

    private class AlgoKeyListener extends KeyAdapter{ }
    private class AlgoMouseListener extends MouseAdapter{ }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 500;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
