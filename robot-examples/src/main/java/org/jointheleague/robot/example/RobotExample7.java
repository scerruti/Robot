/*
 * Copyright (c) 2016. The League of Amazing Programmers. All Rights Reserved.
 */

package org.jointheleague.robot.example;

import org.jointheleague.graphical.robot.KeyboardAdapter;
import org.jointheleague.graphical.robot.Robot;

public class RobotExample7 {

    public static void main(String[] args) throws InterruptedException {
        Robot vic = new Robot("vic", 600, 300);
        Robot june = new Robot("june", 300, 300);
        june.setSpeed(10);
        vic.setSpeed(10);
        vic.addKeyboardAdapter(new KeyboardAdapter());
        june.addKeyboardAdapter(new WaszKeyboardAdapter());
    }
}
