package com.javahackers;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScreenShot {
    private static void capture() {
        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            int frameCount = 0;
            int captureInterval = 100;
            
            while (frameCount < 10) { 
                BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
                File file = new File("screenshot" +frameCount+ ".png");
                ImageIO.write(screenFullImage, "png", file);
                frameCount++;
                Thread.sleep(captureInterval);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setSize(600,500);
        panel.setVisible(true);
        panel.setLayout(null);
        JButton button = new JButton("Click to capture images");
        button.setBounds(200,100,200,100);
        panel.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                capture();
            }
            
        });
        return panel;
    }
    public static void main(String[] args) {
        JFrame panel = new JFrame();
        panel.setSize(500,500);
        panel.setVisible(true);
        panel.setLayout(null);
        JButton button = new JButton("Click to capture images");
        button.setBounds(100,100,100,100);
        panel.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                capture();
            }
            
        });
    }
}

