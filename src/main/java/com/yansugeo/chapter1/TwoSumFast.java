package com.yansugeo.chapter1; /******************************************************************************
 *  Compilation:  javac TwoSumFast.java
 *  Execution:    java TwoSumFast input.txt
 *  Dependencies: In.java Stopwatch.java
 *  Data files:   https://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program with n log n running time. Read in n integers
 *  and counts the number of pairs that sum to exactly 0.
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *
 *
 *  % java TwoSumFast 2Kints.txt
 *  2
 *
 *  % java TwoSumFast 1Kints.txt
 *  1
 *
 *  % java TwoSumFast 2Kints.txt
 *  2
 *
 *  % java TwoSumFast 4Kints.txt
 *  3
 *
 *  % java TwoSumFast 8Kints.txt
 *  19
 *
 *  % java TwoSumFast 16Kints.txt
 *  66
 *
 *  % java TwoSumFast 32Kints.txt
 *  273
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSumFast {

    // print distinct pairs (i, j) such that a[i] + a[j] = 0
    public static void printAll(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
        for (int i = 0; i < n; i++) {
            int j = Arrays.binarySearch(a, -a[i]);
            if (j > i) StdOut.println(a[i] + " " + a[j]);
        }
    }

    // return number of distinct pairs (i, j) such that a[i] + a[j] = 0
    public static int count(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        if (containsDuplicates(a)) throw new IllegalArgumentException("array contains duplicate integers");
        int count = 0;
        for (int i = 0; i < n; i++) {
            int j = Arrays.binarySearch(a, -a[i]);
            if (j > i) count++;
        }
        return count;
    }

    // returns true if the sorted array a[] contains any duplicated integers
    private static boolean containsDuplicates(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] == a[i-1]) return true;
        return false;
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        String[] path = {
                "src/main/resources/chapter1/1Kints.txt",
                "src/main/resources/chapter1/2Kints.txt",
                "src/main/resources/chapter1/4Kints.txt",
                "src/main/resources/chapter1/8Kints.txt",
                "src/main/resources/chapter1/16Kints.txt",
                "src/main/resources/chapter1/32Kints.txt",
                "src/main/resources/chapter1/1Mints.txt"
        };
        for (int i = 0; i < path.length; i++) {
            System.out.println("下一个测试文件为：" + path[i] + "，请问是否继续？1继续,2跳过，其他退出");
            int go = scanner.nextInt();
            if (go == 2){
                continue;
            } else if (go != 1) {
                break;
            }
            In in = new In(path[i]);
            int[] a = in.readAllInts();

            Stopwatch timer = new Stopwatch();
            int count = count(a);
            StdOut.println("elapsed time = " + timer.elapsedTime());
            StdOut.println(count);
        }
    }
}
