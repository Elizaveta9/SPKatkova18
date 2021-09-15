package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class withoutUsingMultRegex {
    public static void main(String[] args) {
        try(BufferedReader fr = new BufferedReader(new FileReader("produce_without_using_mult/expression.txt"))) {
            double log = 0;
            System.out.println("Выражение считывается из файла expression.txt");
            String expression = fr.readLine();
            System.out.printf("Выражение » %s\n", expression);
            String[] numbers = expression.split("\\*");
            for (String num : numbers) {
                log += Math.log10(Integer.parseInt(num));
            }
            System.out.printf("Их произведение » %.0f", Math.pow(10, log));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}