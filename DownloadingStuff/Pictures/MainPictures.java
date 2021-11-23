package ru.demo.downloadmusic;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainPictures {

    // Объявление констант, содержащих пути к файлам
    private static final String IN_FILE_TXT = "src\\ru\\demo\\downloadmusic\\inFilePic.txt";
    private static final String OUT_FILE_TXT = "src\\ru\\demo\\downloadmusic\\outFile.txt";
    private static final String PATH_TO_PICTURE = "src\\ru\\demo\\downloadmusic\\picture";

    public static void main(String[] args) {
        String Url;
        try (BufferedReader inFile = new BufferedReader(new FileReader(IN_FILE_TXT));
             BufferedWriter outFile = new BufferedWriter(new FileWriter(OUT_FILE_TXT))) {

            // Считывание URL адреса из inFile и получение страницы
            while ((Url = inFile.readLine()) != null) {
                URL url = new URL(Url);
                String result;
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                    result = bufferedReader.lines().collect(Collectors.joining("\n"));
                }

                // Поиск атрибутов scr, содержащих ссылки на файлы с разрешениями jpeg, jpg, png
                Pattern email_pattern = Pattern.compile("\\s*(?<=src\\s?=\\s?\")[^>]*\\/*\\.(jpeg|jpg|png)(?=\")");
                Matcher matcher = email_pattern.matcher(result);

                // Запись найденных ссылок в outFile
                int i = 0;
                while (matcher.find() && i < 3) {
                    String urlAttr = matcher.group();
                    outFile.write(urlAttr + "\r\n");
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Считывание ссылок из outFile и загрузка файлов
        try (BufferedReader musicFile = new BufferedReader(new FileReader(OUT_FILE_TXT))) {
            String music;
            int count = 0;
            try {
                while ((music = musicFile.readLine()) != null) {
                    downloadUsingNIO(music, PATH_TO_PICTURE + String.valueOf(count) + ".jpg");
                    System.out.println(PATH_TO_PICTURE + String.valueOf(count));
                    count++;
                }
                System.out.println("done");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Метод для загрузки файлов
    private static void downloadUsingNIO(String strUrl, String file) throws IOException {
        URL url = new URL(strUrl);
        ReadableByteChannel byteChannel = Channels.newChannel(url.openStream());
        FileOutputStream stream = new FileOutputStream(file);
        stream.getChannel().transferFrom(byteChannel, 0, Long.MAX_VALUE);
        stream.close();
        byteChannel.close();
    }
}
