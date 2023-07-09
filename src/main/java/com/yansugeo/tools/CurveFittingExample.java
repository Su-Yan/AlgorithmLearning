package com.yansugeo.tools;

import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class CurveFittingExample {
    public static void main(String[] args) {
        double[] xCoordinates = {1.0, 2.0, 4.0, 8.0, 16.0};  // x坐标
        double[] yCoordinates = {0.164, 1.182, 2.097, 16.217, 128.869};  // y坐标

        WeightedObservedPoints points = new WeightedObservedPoints();

        // 添加坐标点
        for (int i = 0; i < xCoordinates.length; i++) {
            points.add(xCoordinates[i], yCoordinates[i]);
        }

        // 拟合多项式函数
        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2);  // 使用二次多项式
        double[] coefficients = fitter.fit(points.toList());

        // 打印拟合函数的系数
        System.out.print("拟合函数的系数: ");
        for (double coefficient : coefficients) {
            System.out.print(coefficient + " ");
        }
        System.out.println();

        // 打印拟合结果
        System.out.println("拟合结果:");
        for (int i = 0; i < xCoordinates.length; i++) {
            double x = xCoordinates[i];
            double y = evaluatePolynomial(coefficients, x);
            System.out.println("(" + x + ", " + y + ")");
        }
        System.out.println(evaluatePolynomial(coefficients, 16));
    }

    // 计算多项式函数的值
    private static double evaluatePolynomial(double[] coefficients, double x) {
        double y = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            y += coefficients[i] * Math.pow(x, i);
        }
        return y;
    }
}
