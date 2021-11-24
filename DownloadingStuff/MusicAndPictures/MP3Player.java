package ru.demo.downloadmusic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Class(name = "MP3Player", author = "Elizaveta K")
public class MP3Player {

    // Обявление константы, содержащей путь к файлу с данными
    @Path(pathTo = "MusicAndPictureData.txt")
    private static final String DATA_FILE = "src/ru/demo/downloadmusic/MusicAndPictureData.txt";

    @MainMethod
    public static void main(String[] args) {
            try (BufferedReader BRDataFile = new BufferedReader(new FileReader(DATA_FILE))) {
                String line;
                String[] datas;

                // Запуск потоков скачивания
                while ((line = BRDataFile.readLine()) != null) {
                    datas = line.split(" ");
                    new DownloadThread(datas[0], datas[1]);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
