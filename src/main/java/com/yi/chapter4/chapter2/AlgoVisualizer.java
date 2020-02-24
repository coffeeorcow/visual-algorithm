package com.yi.chapter4.chapter2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

public class AlgoVisualizer {

    private SelectionSortData data;        // 数据
    private AlgoFrame frame;    // 视图
    private int delay = 5;

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
        int minIndex = -1;
        for (int i = 0; i < data.N(); i++) {
            setData(i, -1, minIndex);
            minIndex = i;

            for (int j = i + 1; j < data.N(); j++) {
                setData(i, j, minIndex);
                if (data.get(j) < data.get(minIndex)) {
                    minIndex = j;
                    setData(i, j, minIndex);
                }
            }


            data.swap(i, minIndex);
            setData(i + 1, -1, -1);
        }
    }

    private void setData(int orderIndex, int currentCompareIndex, int currentMinIndex) {
        data.orderIndex = orderIndex;
        data.currentCompareIndex =  currentCompareIndex;
        data.currentMinIndex = currentMinIndex;

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
