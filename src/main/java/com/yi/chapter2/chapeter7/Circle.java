package com.yi.chapter2.chapeter7;

import java.awt.*;

public class Circle {

    public int x;
    public int y;
    private int r;

    public int vx;
    public int vy;

    public boolean isFilled = false;

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;

        this.vx = vx;
        this.vy = vy;
    }

    public void move(int minx, int miny, int maxx, int maxy) {
        x += vx;
        y += vy;

        checkCollision(minx, miny, maxx, maxy);
    }

    public int getR() {
        return this.r;
    }

    public boolean contain(Point p) {
        return Math.abs(x - p.x) < r && Math.abs(y - p.y) < r;
    }

    private void checkCollision(int minx, int miny, int maxx, int maxy) {
        if (x - r <= minx) {
            vx = -vx;
            x = r;
        }
        if (x + r >= maxx) {
            vx = -vx;
            x = maxx - r;
        }
        if (y - r <= miny) {
            vy = -vy;
            y = r;
        }
        if (y + r >= maxy) {
            vy = -vy;
            y = maxy - r;
        }

    }

}
