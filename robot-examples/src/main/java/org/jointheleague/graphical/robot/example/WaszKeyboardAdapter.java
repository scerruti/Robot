/*
 * Copyright (c) 2016. The League of Amazing Programmers. All Rights Reserved.
 */

package org.jointheleague.graphical.robot.example;

import org.jointheleague.graphical.robot.KeyboardAdapter;

import java.awt.event.KeyEvent;

public class WaszKeyboardAdapter extends KeyboardAdapter {

    /**
     * Constructor.
     */
    public WaszKeyboardAdapter() {
        super();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                setMovingForward(true);
                break;
            case KeyEvent.VK_A:
                setTurningLeft(true);
                break;
            case KeyEvent.VK_S:
                setTurningRight(true);
                break;
            case KeyEvent.VK_Z:
                setMovingBackward(true);
                break;
            default:
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                setMovingForward(false);
                break;
            case KeyEvent.VK_A:
                setTurningLeft(false);
                break;
            case KeyEvent.VK_S:
                setTurningRight(false);
                break;
            case KeyEvent.VK_Z:
                setMovingBackward(false);
                break;
            default:
        }
    }

}
