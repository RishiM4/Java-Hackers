package com.javahackers;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScreenRecorder {
    static Timer timer = new Timer();
    static TimerTask task;
    static Boolean isRecording = false;
    static int frameCount = 0;
    private static void capture() {
        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            
            int captureInterval = 100;
            timer = new Timer();
        
            task = new TimerTask() {
            @Override
            public void run() {
                if (!isRecording) {
                    return;
                }
                try {
                    BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
                    File file = new File("video\\screenshot" +frameCount+ ".png");
                    ImageIO.write(screenFullImage, "png", file);
                    frameCount++;
                    Thread.sleep(captureInterval);
                } catch (Exception e) {
                    
                }
                

                }
            };
            timer.scheduleAtFixedRate(task, 100, 1); 
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setSize(600,500);
        panel.setVisible(true);
        panel.setLayout(null);
        JButton button = new JButton("Click to capture video");
        JButton stopRecording = new JButton("Click to stop recording");
        button.setBounds(200,100,200,100);
        stopRecording.setBounds(200,200,200,100);
        panel.add(button);
        panel.add(stopRecording);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println("HI");
                if (!isRecording) {
                    button.setText("Recording");
                    isRecording = true;
                    capture();
                    
                }
                else {
                    button.setText("Click to capture video");
                }
                
            }
            
        });
        stopRecording.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                isRecording = false;
            }
            
        });

        return panel;
    }
    public static void main(String[] args) {
        JFrame panel = new JFrame();
        panel.setSize(600,500);
        panel.setVisible(true);
        panel.setLayout(null);
        JButton button = new JButton("Click to capture video");
        JButton stopRecording = new JButton("Click to stop recording");
        button.setBounds(200,100,200,100);
        stopRecording.setBounds(200,200,200,100);
        panel.add(button);
        panel.add(stopRecording);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println("HI");
                if (!isRecording) {
                    button.setText("Recording");
                    isRecording = true;
                    capture();
                    
                }
                else {
                    button.setText("Click to capture video");
                }
                
            }
            
        });
        stopRecording.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                isRecording = false;
            }
            
        });

        
    }
}

