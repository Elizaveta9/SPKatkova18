package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesCopyParallel {
    public static void main(String[] args){
        // Назначение источника и конечного пути копирования первого файла
        File sourceFirst = new File("C:\\Users\\Elizaveta\\IdeaProjects\\ProjectForFunzis\\src\\com\\company\\FirstFileToCopy.txt");
        File destFirst = new File("C:\\Users\\Elizaveta\\IdeaProjects\\ProjectForFunzis\\src\\com\\company\\FirstFileToCopy2.txt");

        //Назначение источника и конечного пути копирования второго файла
        File sourceSecond = new File("C:\\Users\\Elizaveta\\IdeaProjects\\ProjectForFunzis\\src\\com\\company\\SecondFileToCopy.txt");
        File destSecond = new File("C:\\Users\\Elizaveta\\IdeaProjects\\ProjectForFunzis\\src\\com\\company\\SecondFileToCopy2.txt");

        long startTime = System.currentTimeMillis();

        // создание и запуск потоков
        FileCopyTread firstFile = new FileCopyTread(sourceFirst, destFirst);
        firstFile.start();
        FileCopyTread secondFile = new FileCopyTread(sourceSecond, destSecond);
        secondFile.start();

        //ожидание завершиния потоков копирования для корректного замера времени
        try {
            firstFile.join();
            secondFile.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
    }
}

//класс потока для выполнения копирования
class FileCopyTread extends Thread{
    private File source;
    private File dest;

    FileCopyTread(File source, File dest){
        this.source = source;
        this.dest = dest;
    }
    public void run(){
        try {
            Files.copy(source.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
