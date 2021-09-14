package com.company;

import java.util.Scanner;

public class produceWithoutUsingMult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число >> ");
        int a = scanner.nextInt();
        System.out.println("Введите второе число >> ");
        int b = scanner.nextInt();
        System.out.printf("Их произведение %d", (int)Math.pow(10, (Math.log10(a) + Math.log10(b))));
    }
}
