package com.company;

public class Multiplaer {
    private String expression;

    public Multiplaer(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void muit(){
        double log = 0;
        System.out.println("Выражение считывается из файла expression.txt");
        System.out.printf("Выражение » %s\n", expression);
        String[] numbers = expression.split("\\*");
        for (String num : numbers) {
            log += Math.log10(Integer.parseInt(num));
        }
        System.out.printf("Их произведение » %.0f", Math.pow(10, log));

    }
}
