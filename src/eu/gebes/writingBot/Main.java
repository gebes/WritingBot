package eu.gebes.writingBot;

import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        WritingBot writingBot = new WritingBot();

        writingBot.exec();

    }


}

class WritingBot {

    public void exec() {
        System.out.println("Enter a string to write: ");
        final String stuffToWrite = new Scanner(System.in).next();

        timer();

        System.out.println("Entering...");
        try {
            Robot robot = new Robot();

            for(char c : stuffToWrite.toCharArray()){
                robot.keyPress(c);
                sleep(0.05f);
                robot.keyRelease(c);
            }

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

    }

    private static void timer() {

        for (int i = 3; i > 0; i--) {
            System.out.println("Entering input in " + i + " seconds");
            sleep(1);
        }

    }

    private static void sleep(float seconds) {
        try {
            Thread.sleep((long) (seconds * 1000f));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
