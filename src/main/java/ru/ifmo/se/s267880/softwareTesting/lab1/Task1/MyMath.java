package ru.ifmo.se.s267880.softwareTesting.lab1.Task1;

public class MyMath {
    // value copied from Wolfram-alpha with command `pi/2`
    private static final double HALF_PI = 1.5707963267948966192313216916397514420985846996875529104874722961d;
    private static final double TERM_LIMIT = 1e-15;
    private static final long TERM_COUNT = 100000000;

    public static double acos(double x) {
        return HALF_PI - asin(x);
    }

    public static double asin(double x) {
        // Math.acos/Math.asin just return NaN
        // I say this is not correct
        if (x < -1 || x > 1) {
            throw new IllegalArgumentException("The absolute value of x must not be greater than 1");
        }
        double ans = 0;
        double term = x;
        double x2 = x * x;
        for (long i = 1; Math.abs(term) > TERM_LIMIT && i <= TERM_COUNT; i += 2) {
            ans += term / i;
            term = term * x2 * i / (i + 1);
        }
        return ans;
    }

    // just to see it in actions
    public static void main(String[] args) {
        double x = 2;
        System.out.printf("%.10f\n", Math.acos(x));
        System.out.printf("%.10f\n", acos(x));
    }
}
