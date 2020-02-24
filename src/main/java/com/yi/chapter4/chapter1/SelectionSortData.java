package com.yi.chapter4.chapter1;

public class SelectionSortData {

    private int[] numbers;

    public SelectionSortData(int N, int randomBound) {
        numbers = new int[N];

        for (int i = 0; i < numbers.length; i++)
            numbers[i] = (int) (Math.random() * randomBound) + 1;
    }

    public int N() {
        return this.numbers.length;
    }

    public int get(int index) {
        if (index < 0 || index >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access the Sort Data.");

        return this.numbers[index];
    }

    public void swap(int i, int j) {
        if (i < 0 || j < 0 || i >= numbers.length || j >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access the Sort Data.");

        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

}
