package com.company;

public class RabbitAndTurtle {
    public static void main(String[] args){
        AnimalThread rabbit = new AnimalThread("Rabbit",Thread.MIN_PRIORITY);
        rabbit.start();
        AnimalThread turtle = new AnimalThread("Turtle", Thread.MAX_PRIORITY);
        turtle.start();


    }
}
