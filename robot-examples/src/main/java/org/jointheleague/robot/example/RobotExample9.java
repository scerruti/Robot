/*
 * Copyright (c) 2016. The League of Amazing Programmers. All Rights Reserved.
 */

package org.jointheleague.robot.example;

import org.jointheleague.graphical.robot.Robot;

public class RobotExample9 {

    public static void main(String[] args) throws InterruptedException {
        Driver rob = new Driver(new Robot());
        rob.setSpeed(10);
        rob.turn(45);
        rob.penDown();
        for (int i : new int[]{4, 5, 6, 8, 10}) {
            rob.moveTo(450, 300);
            rob.setRandomPenColor();
            rob.drawPolygon(i, 200);
        }
        rob.hide();
    }
}
