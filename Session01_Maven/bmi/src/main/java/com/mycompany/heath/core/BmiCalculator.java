package com.mycompany.heath.core;

public class BmiCalculator {
    // tinh chi so khoi co the dua tren can nang va chieu cao
    public static double getBmi(double weight, double height) {
        return weight / (height * height);
    }
}
