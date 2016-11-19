/*
 * Copyright (c) 2016. The League of Amazing Programmers. All Rights Reserved.
 */

package org.jointheleague.graphical.robot.example;

import org.jointheleague.graphical.robot.Robot;

public class RobotExample3 {

    public static void main(String[] args) {

        Robot rob = new Robot();
        String url = "http://icons.iconarchive.com/icons/martin-berube/character/96/Robot-icon.png";
        rob.changeRobot(url);
        rob.setSpeed(10);
        rob.penDown();
        rob.addKeyboardAdapter(new ExtendedKeyboardAdapter());
    }

}
