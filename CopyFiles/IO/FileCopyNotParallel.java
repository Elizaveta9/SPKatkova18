package com.company;

import java.io.*;

public class FileCopyNotParallel {
    public static void main(String[] args) {
        // Назначение источника и конечного пути копирования первого файла
        File sourceFirst = new File("C:\\Users\\Elizaveta\\IdeaProjects\\title\\src\\com\\company\\files\\tagsREADABLE.txt");
        File destFirst = new File("C:\\Users\\Elizaveta\\IdeaProjects\\ProjectForFunzis\\src\\com\\company\\FirstFileToCopy2.txt");

        //Назначение источника и конечного пути копирования второго файла
        File sourceSecond = new File("C:\\Users\\Elizaveta\\IdeaProjects\\title\\src\\com\\company\\files\\ftgForAllTradeNames.txt");
        File destSecond = new File("C:\\Users\\Elizaveta\\IdeaProjects\\ProjectForFunzis\\src\\com\\company\\SecondFileToCopy2.txt");

        String line = "";

        long startTime = System.currentTimeMillis();

        try (BufferedReader br1 = new BufferedReader(new FileReader(sourceFirst));
             BufferedReader br2 = new BufferedReader(new FileReader(sourceSecond));
             BufferedWriter bw1 = new BufferedWriter(new FileWriter(destFirst));
             BufferedWriter bw2 = new BufferedWriter(new FileWriter(destSecond))) {

            // копирование первого файла
            while ((line = br1.readLine()) != null) {
                bw1.write(line);
            }

            line = "";

            // копирование второго файла
            while ((line = br2.readLine()) != null) {
                bw2.write(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }
}
