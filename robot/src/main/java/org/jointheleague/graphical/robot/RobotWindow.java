/*
 * Copyright (c) 2016. The League of Amazing Programmers. All Rights Reserved.
 */

package org.jointheleague.graphical.robot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Package private singleton class that defines the window in which the Robots
 * move around.
 *
 * @author David Dunn &amp; Erik Colban &copy; 2016
 */
@SuppressWarnings("serial")
class RobotWindow extends JPanel {

    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_WIDTH = 900;
    private static final Color DEFAULT_WINDOW_COLOR = new Color(0xdcdcdc);
    private static final int MARGIN = 10;
    private static final RobotWindow INSTANCE = new RobotWindow(DEFAULT_WINDOW_COLOR);

    private Color winColor;

    private ArrayList<Robot> robotList;
    private Timer ticker;

    private BufferedImage leagueLogo;

    private boolean guiHasBeenBuilt = false;

    private RobotWindow(Color c) {
        winColor = c;
        robotList = new ArrayList<Robot>();
        try {
            leagueLogo = ImageIO.read(this.getClass().getResourceAsStream("/league_logo.png"));
        } catch (IOException e) {
            System.err.println("Cannot load background image.");
        }
    }

    /**
     * Returns the single instance of the RobotWindow
     *
     * @return the single instance
     */
    static RobotWindow getInstance() {
        return INSTANCE;
    }

    private void buildGui() {
        JFrame frame = new JFrame();
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        frame.add(this);
        // frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
        setFocusable(true);
    }

    void addRobot(final Robot r) {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {

                public void run() {
                    if (!guiHasBeenBuilt) {
                        buildGui();
                        ticker = new Timer(Robot.TICK_LENGTH, r);
                        ticker.start();
                        guiHasBeenBuilt = true;
                    } else {
                        ticker.addActionListener(r);
                    }
                    robotList.add(r);
                }

            });
        } catch (InvocationTargetException | InterruptedException e) {

        }
    }

    /**
     * Set the RobotWindow's background Color
     *
     * @param c
     */
    void setWinColor(Color c) {
        winColor = c;
        repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(winColor);
        g2.fillRect(0, 0, getWidth(), getHeight());
        int imgX = getWidth() - leagueLogo.getWidth() - MARGIN;
        int imgY = MARGIN;
        g2.drawImage(leagueLogo, imgX, imgY, null);

        for (Robot r : robotList) {
            r.draw(g2);
        }
    }

}
