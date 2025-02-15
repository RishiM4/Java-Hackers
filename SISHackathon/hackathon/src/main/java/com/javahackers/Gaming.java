package com.javahackers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class Gaming implements NativeKeyListener{
    static AutoClicker autoClicker = new AutoClicker(); 
    static KeyBoardMacro keyBoardMacro = new KeyBoardMacro();
    static AudioPlayer audioplayer = new AudioPlayer();
    static MouseMacro mousemacro = new MouseMacro();
    static SystemStats systemstats = new SystemStats();
    static JPanel currentPanel = new JPanel();
    static JFrame frame = new JFrame("Gaming Tools - By Rishi Mohan");
    static int panelNumber = -1;
    public void nativeKeyPressed(NativeKeyEvent e){
        System.err.println(e.getKeyCode());
        if(e.getKeyCode()==3667) {
        }
        
    }
    public void nativeKeyReleased(NativeKeyEvent e){
        System.err.println(e.getKeyCode());
        
    }

    public static void main(String[] args) {
        
        currentPanel = new JPanel();
        frame.setSize(500,500);
        frame.setVisible(true);
        JMenuBar menuBar = new JMenuBar();
        JMenu autoclicker = new JMenu("Autoclicker");
        JMenu keyBoardScript = new JMenu("Keyboard Scripts");
        JMenu audioPlayer = new JMenu("Audio Player");
        JMenu mouseMacro = new JMenu("Mouse Macro");
        JMenu systemStats = new JMenu("System Stats");
        JPanel audioPanel = audioplayer.createPanel();
        JPanel keyboardPanel = keyBoardMacro.createPanel();
        JPanel mousePanel = mousemacro.createPanel();
        


        menuBar.add(autoclicker);
        menuBar.add(keyBoardScript);
        menuBar.add(audioPlayer);
        menuBar.add(mouseMacro);
        menuBar.add(systemStats);
        autoclicker.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
                

            @Override
            public void mousePressed(MouseEvent e) {
                System.err.println("HI");
                frame.remove(currentPanel);
                currentPanel = autoClicker.createPanel();
                frame.add(currentPanel);
                frame.setSize(499,499);
                frame.setSize(500,500);
                panelNumber = 0;

            }
            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            
        });
        keyBoardScript.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                frame.remove(currentPanel);
                currentPanel = keyboardPanel;
                frame.add(currentPanel);
                frame.setSize(499,499);
                frame.setSize(500,500);
                panelNumber = 1;
    
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
            
        });
        audioPlayer.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                frame.remove(currentPanel);
                currentPanel = audioPanel;
                frame.add(currentPanel);
                frame.setSize(499,499);
                frame.setSize(500,500);
                panelNumber = 2;
    
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
            
        });
        mouseMacro.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                frame.remove(currentPanel);
                currentPanel = mousePanel;
                frame.add(currentPanel);
                frame.setSize(499,499);
                frame.setSize(500,500);
                panelNumber = 3;
            }


            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });
        systemStats.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                frame.remove(currentPanel);
                currentPanel = systemstats.createPanel();
                frame.add(currentPanel);
                frame.setSize(499,499);
                frame.setSize(500,500);
                panelNumber = 4;
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
            
        });
        frame.setJMenuBar(menuBar);
        frame.add(currentPanel);
        frame.setSize(499,499);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new Gaming());
        System.err.println("HIsd");
    }
}
