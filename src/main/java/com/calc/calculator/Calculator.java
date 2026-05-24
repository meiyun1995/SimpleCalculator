package com.calc.calculator;

public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int difference(int a, int b) {
        return a - b;
    }

    public int product(int a, int b) {
        return a * b;
    }

    public String fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Denom can't be zero");
            return "Denom 0";
        }
        Fraction fraction = new Fraction(numerator, denominator);
        return fraction.toString();
    }
}
