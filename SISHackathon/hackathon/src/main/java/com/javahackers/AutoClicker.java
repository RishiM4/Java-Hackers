package com.javahackers;

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class AutoClicker implements NativeKeyListener{
    static Boolean toggle = false;
    static int delay = 1000;
    private static void click() {
        while(toggle) {
            if (!toggle) {
                return;
            }
            try {
                Robot robot = new Robot();

                robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                int k = delay;
                Thread.sleep(k);
                robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
            } catch (Exception e) {
            }
        }
    }
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.err.println(e.getKeyCode());
        if (e.getKeyCode() == 3667) {
            toggle = false;
        }
	}
    public void nativeKeyReleased(NativeKeyEvent e) {
	}
    public void nativeKeyTyped(NativeKeyEvent e) {
	}
    public JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.setVisible(true);
        panel.setSize(400,400);
        JButton button = new JButton();
        panel.setLayout(null);
        button.setBounds(100,100,100,50);
        button.setText("Start Autoclicker");
        JTextField textField = new JTextField();
        textField.setBounds(100,200,100,50);
        panel.add(textField);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggle = true;
                click();
            }
            
        });
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int temp = Integer.parseInt(textField.getText());
                    delay = temp;
                    if (delay < 50) {
                        delay = 50;
                    }
                    else if (delay > 1000) {
                        delay = 1000;
                    }
                    System.out.println(delay);
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(panel, "Please enter an Integer", "error", 1);
                }
            }
            
        });
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
        }
        GlobalScreen.addNativeKeyListener(new AutoClicker());
        panel.setSize(399,399);
        panel.setSize(400,400);

        return panel;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(400,400);
        JButton button = new JButton();
        frame.setLayout(null);
        button.setBounds(100,100,100,50);
        button.setText("Start Autoclicker");
        JTextField textField = new JTextField();
        textField.setBounds(100,200,100,50);
        frame.add(textField);
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggle = true;
                click();
            }
            
        });
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int temp = Integer.parseInt(textField.getText());
                    delay = temp;
                    if (delay < 50) {
                        delay = 50;
                    }
                    else if (delay > 1000) {
                        delay = 1000;
                    }
                    System.out.println(delay);
                } catch (Exception f) {
                    JOptionPane.showMessageDialog(frame, "Please enter an Integer", "error", 1);
                }
            }
            
        });
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
        }
        GlobalScreen.addNativeKeyListener(new AutoClicker());
        frame.setSize(399,399);
        frame.setSize(400,400);

    }
    
}