/*
 * Copyright (c) 2016. The League of Amazing Programmers. All Rights Reserved.
 */

package org.jointheleague.graphical.robot.example;

import org.jointheleague.graphical.robot.Robot;

import java.awt.*;

public class RobotExample5 {

    private Robot vic = new Robot("vic");
    private Robot june = new Robot("june");
    private boolean juneDone = false;
    private boolean vicDone = false;
    private Runnable vicsPart = new Runnable() {

        @Override
        public void run() {
            vic.moveTo(300, 300);
            firstMovement(vic);
            vicIsDone();
            waitForJune();
            secondMovement(vic);
            waitForJune();
            vic.setSpeed(5);
            vic.move(-200);
            vic.hide();

        }

    };
    private Runnable junesPart = new Runnable() {

        @Override
        public void run() {
            june.moveTo(600, 300);
            waitForVic();
            firstMovement(june);
            june.sleep(500);
            juneIsDone();
            secondMovement(june);
            june.turn(180);
            june.sleep(500);
            juneIsDone();
            june.setSpeed(5);
            june.move(200);
            june.hide();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        new RobotExample5().play();
    }

    private void play() {
        Robot.setWindowColor(Color.WHITE);
        new Thread(vicsPart).start();
        new Thread(junesPart).start();
    }

    private void firstMovement(Robot robot) {
        robot.setSpeed(2);
        robot.setPenColor(Color.GRAY);
        robot.penUp();
        robot.move(-10);
        robot.penDown();
        robot.move(20);
        robot.penUp();
        robot.move(-10);
        robot.turn(90);
        robot.move(-10);
        robot.penDown();
        robot.move(20);
        robot.penUp();
        robot.move(-10);
        robot.setSpeed(10);
        robot.turn(-144);
        robot.move(123);
        robot.turn(144);
    }

    private void secondMovement(Robot robot) {
        robot.setPenWidth(8);
        robot.penDown();
        for (int i = 0; i < 10; i++) {
            robot.setRandomPenColor();
            robot.move(200);
            robot.turn(108);
        }
        robot.penUp();
    }

    private synchronized void waitForJune() {
        juneDone = false;
        try {
            while (!juneDone) {
                wait();
            }
        } catch (InterruptedException e) {
            assert false; // No interrupts expected
        }
    }

    private synchronized void juneIsDone() {
        juneDone = true;
        notify();
    }

    private synchronized void waitForVic() {
        vicDone = false;
        try {
            while (!vicDone) {
                wait();
            }
        } catch (InterruptedException e) {
            assert false; // No interrupts expected
        }
    }

    private synchronized void vicIsDone() {
        vicDone = true;
        notify();
    }
}
