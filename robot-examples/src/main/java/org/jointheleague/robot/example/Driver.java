/*
 * Copyright (c) 2016. The League of Amazing Programmers. All Rights Reserved.
 */

package org.jointheleague.robot.example;

import org.jointheleague.graphical.robot.Robot;

public class Driver {

    private final Robot robot;

    public Driver(Robot robot) {
        super();
        this.robot = robot;
    }

    public void setSpeed(int speed) {
        robot.setSpeed(speed);
    }

    public void turn(int degrees) {
        robot.turn(degrees);
    }

    public void penUp() {
        robot.penUp();
    }

    public void penDown() {
        robot.penDown();
    }

    public void move(int distance) {
        robot.move(distance);
    }

    public void moveTo(int x, int y) {
        robot.moveTo(x, y);
    }

    public void setRandomPenColor() {
        robot.setRandomPenColor();
    }

    public void hide() {
        robot.hide();
    }

    /**
     * Draws a regular polygon with center at the org.jointheleague.graphical.robot's current position
     *
     * @param numSides the number of sides of the polygon
     * @param radius   the radius of the circumscribed circle.
     */
    public void drawPolygon(int numSides, int radius) {
        int angle = 360 / numSides;
        double sin = Math.sin(Math.toRadians(angle / 2.0));
        int sideLen = (int) (2 * radius * Math.abs(sin));
        penUp();
        move(radius);
        turn(90 + angle / 2);
        penDown();
        move(sideLen);
        for (int i = 1; i < numSides; i++) {
            turn(angle);
            move(sideLen);
        }
        penUp();
        turn(-90 + angle / 2);
    }

}
