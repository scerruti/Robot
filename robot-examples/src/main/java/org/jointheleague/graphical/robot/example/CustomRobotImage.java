/*
 * Copyright (c) 2016. The League of Amazing Programmers. All Rights Reserved.
 */

package org.jointheleague.graphical.robot.example;

import org.jointheleague.graphical.robot.Robot;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * <p>
 * This class demonstrates how to change the robot image using a local file from the resources directory.
 * This file could be retrieved from the local drive using a file: URL, but the location can be different
 * based on project setup and is typically not considered good form.
 * </p>
 * Created by Stephen Cerruti on 11/18/16.
 */
public class CustomRobotImage {
    public static void main(String... args) throws IOException, URISyntaxException {
        Robot robot = new Robot();
        robot.changeRobot(CustomRobotImage.class.getResource("/robotImage1.jpg").toExternalForm());
    }
}
