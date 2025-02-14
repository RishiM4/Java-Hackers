package com.javahackers;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class ScreenShot implements NativeKeyListener{
    
    static JPanel panel = new JPanel();
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
            BufferedImage Image = robot.createScreenCapture(rect);

            ImageIcon icon = new ImageIcon(image);
            JLabel label = new JLabel();
            label.setIcon(icon);
            panel.setBounds(0,0,500,500);
            panel.setVisible(true);
            panel.add(label);
            File file = new File("wasddd" + "." + "png");
            
            try {
                ImageIO.write(Image, ".png", file);  // ignore returned boolean
            } catch(IOException e) {
                System.out.println("Write error for " + file.getPath() +": " + e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static JPanel createPanel(){
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
        }
        GlobalScreen.addNativeKeyListener(new ScreenShot());
        
        panel.setVisible(true);
        panel.setSize(400,400);
        return panel;
    }
    public static void main(String[] args) {
        createPanel();
        while(true) {

        }
        
    }
}
