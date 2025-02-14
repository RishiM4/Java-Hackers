package com.javahackers;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Gaming {
    static JPanel currentPanel = new JPanel();
    static JFrame frame = new JFrame();

    public static void main(String[] args) {
        AutoClicker autoClicker = new AutoClicker(); 
        KeyBoardMacro keyBoardMacro = new KeyBoardMacro();
        AudioPlayer audioplayer = new AudioPlayer();
        MouseMacro mousemacro = new MouseMacro();
        currentPanel = new JPanel();
        frame.setSize(500,500);
        frame.setVisible(true);
        JMenuBar menuBar = new JMenuBar();
        JMenu autoclicker = new JMenu("Autoclicker");
        JMenu keyBoardScript = new JMenu("Keyboard Scripts");
        JMenu audioPlayer = new JMenu("Audio Player");
        JMenu mouseMacro = new JMenu("Mouse Macro");
        JPanel audioPanel = audioplayer.createPanel();
        
        menuBar.add(autoclicker);
        menuBar.add(keyBoardScript);
        menuBar.add(audioPlayer);
        menuBar.add(mouseMacro);
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
                frame.setSize(399,399);
                frame.setSize(400,400);

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
                currentPanel = keyBoardMacro.createPanel();
                frame.add(currentPanel);
                frame.setSize(399,399);
                frame.setSize(400,400);
    
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
                frame.setSize(399,399);
                frame.setSize(400,400);
    
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
                currentPanel = mousemacro.createPanel();
                frame.add(currentPanel);
                frame.setSize(399,399);
                frame.setSize(400,400);
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
    }
}
