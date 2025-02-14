package com.javahackers;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class ScreenShot implements NativeKeyListener{
    static JFrame frame = new JFrame();
    public void nativeKeyPressed(NativeKeyEvent e){
        if (e.getKeyCode()==3667) {
            takePicture();
        }
    }
    private static void takePicture() {
        try {
            Robot robot = new Robot();
            Rectangle rect = new Rectangle(0,0,500,500);
            Image image = robot.createScreenCapture(rect);
            ImageIcon icon = new ImageIcon(image);
            JLabel label = new JLabel();
            label.setIcon(icon);
            frame.setBounds(0,0,500,500);
            frame.setVisible(true);
            frame.add(label);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
        }
        GlobalScreen.addNativeKeyListener(new ScreenShot());
        while(true) {
        }
    }
}
