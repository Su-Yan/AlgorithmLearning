package com.yansugeo;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int N = 100;
        StdDraw.setXscale(0,N);
        StdDraw.setYscale(0,N*N);
        StdDraw.setPenRadius(.01);
        for (int i = 0; i <= N ; i++) {
            StdDraw.point(i,i);
            StdDraw.point(i,i*i);
        }
    }
}