package com.javahackers;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class KeyBoardMacro implements NativeKeyListener{
    static ArrayList<Long> time = new ArrayList<Long>();
    static ArrayList<Integer> key = new ArrayList<Integer>();
    static ArrayList<String> type = new ArrayList<String>();

    static boolean toggleListener = false;
    static long initialTime = 0;
    static boolean activeMacro = false;
    public void nativeKeyPressed(NativeKeyEvent e){
        if(e.getKeyCode()==3667) {
            if(!activeMacro) {
                startMacro();
                activeMacro = true;
            }
        }
        
    }
    public void nativeKeyReleased(NativeKeyEvent e){
        
    }
    static private void startMacro() {
        System.err.println("HI");
        try {
            
            Robot robot = new Robot();
            for(int k = 0; k<time.size();k++) {
                System.err.println("HI");
                if (k==0) {
                    if (type.get(k).equals("Pressed")) {
                        robot.keyPress(key.get(k));
                    }
                    else {
                        robot.keyRelease(key.get(k));
                    }
                }
                else {
                    Thread.sleep(time.get(k)-time.get(k-1));
                    if (type.get(k).equals("Pressed")) {
                        robot.keyPress(key.get(k));
                    }
                    else {
                        robot.keyRelease(key.get(k));
                    }
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        activeMacro = false;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400,400);
        frame.setVisible(true);
        JToggleButton toggle = new JToggleButton();
        toggle.setBounds(100,100,50,50);
        frame.setLayout(null);
        frame.add(toggle);
        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.err.println(e.getKeyCode());

                if (toggleListener) {
                    time.add(System.currentTimeMillis()-initialTime);
                    key.add(e.getKeyCode());
                    type.add("Pressed");
                }
                
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if (toggleListener) {
                    time.add(System.currentTimeMillis()-initialTime);
                    key.add(e.getKeyCode());
                    type.add("Released");
                }
            }
            
        });
        toggle.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (toggleListener) {
                    toggleListener = false;
                }
                else {
                    
                    toggleListener = true;
                    initialTime = System.currentTimeMillis();
                }
                frame.requestFocus();
            }
            
        });
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
        }
        GlobalScreen.addNativeKeyListener(new KeyBoardMacro());
        while(true) {
        }
    }
}
