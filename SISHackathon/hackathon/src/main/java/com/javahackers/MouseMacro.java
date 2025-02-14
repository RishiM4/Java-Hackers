package com.javahackers;

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;

public class MouseMacro implements NativeMouseInputListener, NativeKeyListener{
    
    static ArrayList<Long> time = new ArrayList<Long>();
    static ArrayList<Integer> button = new ArrayList<Integer>();
    static ArrayList<Integer> mouseX = new ArrayList<Integer>();
    static ArrayList<Integer> mouseY = new ArrayList<Integer>();
    static ArrayList<String> type = new ArrayList<String>();
    static Boolean toggle = false;
    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode()==3667) {
            System.err.println("HI");
            runScript();
        }
    }
    public void nativeMousePressed(NativeMouseEvent e) {
        System.err.println(e.getButton());
        
        if (true) {
            time.add(System.currentTimeMillis());
            button.add(e.getButton());
            type.add("pressed");
            mouseX.add(e.getX());
            mouseY.add(e.getY());

        }
    }
    public void nativeMouseDragged(NativeMouseEvent e) {
        if (toggle) {
            time.add(System.currentTimeMillis());
            button.add(e.getButton());
            type.add("pressed");
            mouseX.add(e.getX());
            mouseY.add(e.getY());

        }
        
    }
    public void nativeMouseReleased(NativeMouseEvent e) {
        if (toggle) {
            time.add(System.currentTimeMillis());
            button.add(e.getButton());
            type.add("released");
            mouseX.add(e.getX());
            mouseY.add(e.getY());

        }
    }
    private static void runScript() {
        try {
            Robot robot = new Robot();
            for (int k = 0; k < time.size(); k++) {
                if (k == 0) {
                    robot.mouseMove(mouseX.get(k), mouseY.get(k));
                    robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);

                }
                else {
                    Thread.sleep(time.get(k)-time.get(k-1));
                    if (type.get(k).equals("pressed")) {
                        if (button.get(k).equals(1)) {
                            robot.mouseMove(mouseX.get(k), mouseY.get(k));
                            robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                            
                        }
                        else {
                            robot.mouseMove(mouseX.get(k), mouseY.get(k));
                            robot.mousePress(MouseEvent.BUTTON2_DOWN_MASK);

                        }
                    }
                    else if (type.get(k).equals("released")) {
                        if (button.get(k).equals(1)) {
                            robot.mouseMove(mouseX.get(k), mouseY.get(k));
                            robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                            
                        }
                        else {
                            robot.mouseMove(mouseX.get(k), mouseY.get(k));
                            robot.mouseRelease(MouseEvent.BUTTON2_DOWN_MASK);

                        }
                    }
                }
                robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(MouseEvent.BUTTON2_DOWN_MASK);

            }
        } catch (Exception e) {
        }
        
        
    }
    public JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setSize(400,400);
        panel.setVisible(true);
        panel.setLayout(null);
        JToggleButton toggleButton = new JToggleButton("Click Here To Record a Macro");
        toggleButton.setBounds(100,100,250,100);
        panel.add(toggleButton);
        toggleButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!toggle) {
                    toggleButton.setText("Recording");
                    toggle = !toggle;
                }
                else {
                    toggleButton.setText("Click to record!");
                    toggle = !toggle;
                }
            }
            
        });
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeMouseListener(new MouseMacro());
        GlobalScreen.addNativeMouseMotionListener(new MouseMacro());
        GlobalScreen.addNativeKeyListener(new MouseMacro());
        return panel;
    
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setLayout(null);
        JToggleButton toggleButton = new JToggleButton();
        toggleButton.setBounds(100,100,150,100);
        frame.add(toggleButton);
        toggleButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!toggle) {
                    toggleButton.setText("Recording");
                    toggle = !toggle;
                }
                else {
                    toggleButton.setText("Click to record!");
                    toggle = !toggle;
                }
            }
            
        });
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeMouseListener(new MouseMacro());
        GlobalScreen.addNativeMouseMotionListener(new MouseMacro());
        GlobalScreen.addNativeKeyListener(new MouseMacro());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
