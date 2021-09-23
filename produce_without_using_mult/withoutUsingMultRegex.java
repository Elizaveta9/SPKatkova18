package com.company;

import com.company.Multiplaer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Scratch {
    public static void main(String[] args) {
        try(BufferedReader fr = new BufferedReader(new FileReader("produce_without_using_mult/expression.txt"))) {
            Multiplaer m = new Multiplaer(fr.readLine());
            m.muit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}