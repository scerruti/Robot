/*
 * Copyright (c) 2016. The League of Amazing Programmers. All Rights Reserved.
 */

package org.jointheleague.robot.example;

import org.jointheleague.graphical.robot.KeyboardAdapter;
import org.jointheleague.graphical.robot.Robot;

public class RobotExample2 {

    public static void main(String[] args) throws InterruptedException {
        Robot rob = new Robot();
        rob.setSpeed(5);
        rob.miniaturize();
        rob.addKeyboardAdapter(new KeyboardAdapter());
    }
}
