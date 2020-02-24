package com.yi.chapter3.chatper2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

public class AlgoVisualizer {

    private final int DELAY = 10;
    private int[] money;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight) {

        // 初始化数据
        int N = 100;
        money = new int[N];
        for (int i = 0; i < N; i++)
            money[i] = 100;

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
    private void run() {

        while (true) {

            Arrays.sort(money);
            frame.render(money);
            AlgoVisHelper.pause(DELAY);

            for (int k = 0; k < 50; k++) {
                for (int i = 0; i < money.length; i++) {
                    int j = (int) (Math.random() * money.length);
                    money[i] -= 1;
                    money[j] += 1;
                }
            }
        }


    }

    private class AlgoKeyListener extends KeyAdapter {
    }

    private class AlgoMouseListener extends MouseAdapter {
    }

    public static void main(String[] args) {

        int sceneWidth = 1000;
        int sceneHeight = 800;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
