package com.company;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Класс потока загрузки
 * @author Елизавета
 */
@Class(name = "DownloadThread", author = "Elizaveta K")
public class DownloadThread extends Thread {
    private String link;
    private String path;
    private static int threadCounter; // Счетчик потоков (всего 2 потока)

    /**
     * Конструктор класса DownloadThread
     *
     * @param link ссылка на объект из сети
     * @param path путь к файлу на компьютере
     */
    @Constructor(forClass = "DownloadThread")
    DownloadThread(String link, String path) {
        this.link = link;
        this.path = path;
        this.start(); // Поток запускается сразу после инициализации
    }

    // Метод, вызываемый при старте потока
    @Override
    public void run() {
        try (FileInputStream inputStream = new FileInputStream("src/ru/demo/downloadmusic/CheekToCheek.mp3")) {

            // Загрузка
            System.out.println("Started downloading: " + path);
            URL url = new URL(link);
            ReadableByteChannel byteChannel = Channels.newChannel(url.openStream());
            FileOutputStream stream = new FileOutputStream(path);
            stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
            stream.close();
            byteChannel.close();
            System.out.println("Successfully downloaded: " + path);
            threadCounter++;

            // Когда все два потока закончили загрузку, включается музыка
            if (threadCounter == 2) {
                System.out.println("Music started");
                Player player = new Player(inputStream);
                player.play();
            }

        } catch (IOException | JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
