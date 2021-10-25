package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// логирования процесса умножения выражения из файла

public class withoutUsingMultRegex {
    public static void main(String[] args) {
        try (BufferedReader fr = new BufferedReader(new FileReader("src/com/company/ expression.txt"))) {
            Multiplaer2 m = new Multiplaer2(fr.readLine());
            m.mult();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Multiplaer2 {
    private String expression;

    //создание логгера
    private Logger logger = Logger.getLogger(Multiplaer2.class.getName());
    private FileHandler fh;

    {
        try {
            // привязка файла
            fh = new FileHandler("src/com/company/log.txt");
            logger.addHandler(fh);
            // установка формата сообщения, записываемого в файл (без этого запись идет по шаблону xml)
            fh.setFormatter(new SimpleFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Multiplaer2(String expression) {
        this.expression = expression;
    }

    public void mult() {
        logger.info("Program started");
        double number = 1;
        logger.info("Expression is taken from file expression.txt");
        logger.info("Expression » " + expression);
        String[] numbers = expression.split("\\*");

        // если возникает ошибка превода строки в числовой тип, это отобразится в логах
        try {
            for (String num : numbers) {
                number += Math.log10(Integer.parseInt(num));
            }
            logger.info("Multiplication result » " + Math.pow(10, number));
        } catch (NumberFormatException e){
            logger.warning("Incorrect number format");
        }

        logger.info("Program finished");

    }
}