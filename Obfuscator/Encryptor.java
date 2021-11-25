
package com.company;

import java.io.*;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Программа редактирует файл DownloadThread.java
 * и создаёт DefinitelyNotAClassName.java
 */

public class Encryptor {

    public static void main(String[] args) {
        Pattern pattern;
        Matcher matcher;
        String className;
        String cleanCode;
        String newClassName = "DefinitelyNotAClassName";
        String fullNameClass;

        // Переменные с путями к файлу-источнику и к будующему обработанному файлу
        final String SCR_FILE = "C:/Users/Elizaveta/IdeaProjects/DownloadMusicAndPictures/src/com/company/DownloadThread.java";
        final String ENCRYPTED_FILE_DEST = "C:/Users/Elizaveta/IdeaProjects/DownloadMusicAndPictures/src/com/company/";

        try (BufferedReader br = new BufferedReader(new FileReader(SCR_FILE))) {
            String s = br.readLine();
            String codeLine = "";

            // Удаляет однострочные комментарии
            while (s != null) {
                codeLine += s.replaceAll("//.*", "");
                codeLine += "\n";
                s = br.readLine();
            }

            // Удаляет многострочные комментарии
            cleanCode = codeLine.replaceAll("\\n\\s*/\\*\\*(\\n\\s*\\*.*)+", "");

            // Ищет название класса из полного имени файла
            pattern = Pattern.compile("com(/\\w*)+");
            matcher = pattern.matcher(SCR_FILE);
            matcher.find();
            String partOfPathToClass = matcher.group();
            String[] classNameArr = partOfPathToClass.split("/");
            className = classNameArr[classNameArr.length - 1];

            // Создаёт полное имя класса для использования в рефлексии
            fullNameClass = partOfPathToClass.replaceAll("/", ".");

            // Удаляет переходы на новую строчку
            cleanCode = cleanCode.replaceAll("\\n", "");

            // Удаляет лишние пробелы
            cleanCode = cleanCode.replaceAll("(\\s{2,})", " ");

            // Заменяет название класса
            cleanCode = cleanCode.replaceAll(className, newClassName);

            // Рефлексией получаем поля и их имена
            Class classObject = Class.forName(fullNameClass);
            Field[] fields = classObject.getDeclaredFields();

            // Цикл, берущий поля и заменяющий их названия на f c цифрой
            String fieldName;
            int count = 0;
            for (Field field : fields) {
                fieldName = field.getName();
                cleanCode = cleanCode.replaceAll(fieldName, "f" + count);
                count++;
            }

            // Записывает всё в файл
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(ENCRYPTED_FILE_DEST + newClassName + ".java"))) {
                bw.write(cleanCode);
                System.out.println("Done");
            }

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
