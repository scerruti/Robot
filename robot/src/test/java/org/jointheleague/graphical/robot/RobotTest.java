/*
 * Copyright (c) 2016. The League of Amazing Programmers. All Rights Reserved.
 */

package org.jointheleague.graphical.robot;

import java.awt.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Stephen Cerruti on 11/18/16.
 */
public class RobotTest {
    @org.junit.Test
    public void setPenColor() throws Exception {
        Robot robot = new Robot();

        robot.setPenColor(255, 0, 0);
        assertEquals(Color.RED, robot.getPenColor());
        robot.setPenColor(0, 255, 0);
        assertEquals(Color.GREEN, robot.getPenColor());
        robot.setPenColor(0, 0, 255);
        assertEquals(Color.BLUE, robot.getPenColor());

        robot.setPenColor(1255, -10, -10);
        assertEquals(Color.RED, robot.getPenColor());
        robot.setPenColor(-10, 1255, -10);
        assertEquals(Color.GREEN, robot.getPenColor());
        robot.setPenColor(-10, -10, 1255);
        assertEquals(Color.BLUE, robot.getPenColor());
    }

}