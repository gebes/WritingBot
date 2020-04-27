package eu.gebes.writingBot;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        WritingBot writingBot = new WritingBot();
        while (true)
            writingBot.exec();

    }


}

class WritingBot {

    public void exec() {
        System.out.println("Enter a string to write: ");
        final String stuffToWrite = new Scanner(System.in).nextLine();

        timer();

        System.out.println("Entering...");
        try {
            Robot robot = new Robot();


            for (char c : stuffToWrite.toCharArray()) {

                String code = String.format("%04d", (int) c);

                robot.keyPress(KeyEvent.VK_ALT);

                Map<Integer, Integer> numpads = Map.of(
                        0, KeyEvent.VK_NUMPAD0,
                        1, KeyEvent.VK_NUMPAD1,
                        2, KeyEvent.VK_NUMPAD2,
                        3, KeyEvent.VK_NUMPAD3,
                        4, KeyEvent.VK_NUMPAD4,
                        5, KeyEvent.VK_NUMPAD5,
                        6, KeyEvent.VK_NUMPAD6,
                        7, KeyEvent.VK_NUMPAD7,
                        8, KeyEvent.VK_NUMPAD8,
                        9, KeyEvent.VK_NUMPAD9
                );


                for (char d : code.toCharArray()) {
                    int digit = Integer.parseInt(d + "");

                    robot.keyPress(numpads.get(digit));
                    robot.keyRelease(numpads.get(digit));

                }

                robot.keyRelease(KeyEvent.VK_ALT);


                sleep(randomFloat(0.01f, 0.04f));
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done!");

    }

    private static float randomFloat(float min, float max) {
        return (float) (min + Math.random() * (max - min));
    }

    private static int ascii(char c) {
        return ((int) ('('));
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
