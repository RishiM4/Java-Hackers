package com.javahackers;

import java.awt.Font;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class AutoClicker implements NativeKeyListener{
    static Boolean toggle = false;
    static int delay = 1000;
    static Timer timer = new Timer();
    static TimerTask task;
    private static void click() {
        timer = new Timer();
        
        task = new TimerTask() {
            @Override
            public void run() {
                try {
                
                    Robot robot = new Robot();
    
                    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                    int k = delay;
                    Thread.sleep(k);
                    robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                } catch (Exception e) {
                }
                if(!toggle) {
                    timer.cancel();
                    return;
                }
            }
        };
        timer.scheduleAtFixedRate(task, delay, 1); 
        
        
        
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
        
        button.setBounds(100,100,150,50);
        button.setText("Start Autoclicker");
        JButton stop = new JButton("Stop Autoclicker");
        stop.setBounds(100,150,150,50);
        JTextField textField = new JTextField("Delay");
        textField.setBounds(100,200,150,50);
        panel.add(textField);
        panel.add(button);
        panel.add(stop);
        stop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                toggle = false;
            }
            
        });
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
        frame.setLayout(null);
        Font font = new Font("Serif",Font.PLAIN,30);
        JLabel label = new JLabel("Auto Clicker");
        label.setFont(font);
        label.setBounds(100,25,200,25);
        frame.setVisible(true);
        frame.add(label);
        frame.setSize(400,400);
        JButton button = new JButton();
        JOptionPane.showMessageDialog(frame, "Hello\npoe", null, 0);
        button.setBounds(100,100,150,50);
        button.setText("Start Autoclicker");
        JTextField textField = new JTextField("                Delay");
        textField.setBounds(100,200,150,50);
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