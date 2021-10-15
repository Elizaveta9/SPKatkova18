package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileCopyNotParallel {
    public static void main(String[] args) {
        // Назначение источника и конечного пути копирования первого файла
        File sourceFirst = new File("C:\\Users\\Elizaveta\\IdeaProjects\\ProjectForFunzis\\src\\com\\company\\FirstFileToCopy.txt");
        File destFirst = new File("C:\\Users\\Elizaveta\\IdeaProjects\\ProjectForFunzis\\src\\com\\company\\FirstFileToCopy2.txt");

        //Назначение источника и конечного пути копирования второго файла
        File sourceSecond = new File("C:\\Users\\Elizaveta\\IdeaProjects\\ProjectForFunzis\\src\\com\\company\\SecondFileToCopy.txt");
        File destSecond = new File("C:\\Users\\Elizaveta\\IdeaProjects\\ProjectForFunzis\\src\\com\\company\\SecondFileToCopy2.txt");

        long startTime = System.currentTimeMillis();

        try {
            Files.copy(sourceFirst.toPath(), destFirst.toPath());
            Files.copy(sourceSecond.toPath(), destSecond.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
    }
}
