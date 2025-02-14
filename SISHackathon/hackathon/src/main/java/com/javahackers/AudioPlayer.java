package com.javahackers;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AudioPlayer {
    static Clip clip;
    static AudioInputStream audioInputStream;
    static int position = 0;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(400,400);
        frame.setVisible(true);
        try {
            AudioInputStream audioInputStream =  AudioSystem.getAudioInputStream(new File("C:\\Users\\Rishi (New)\\Downloads\\sound\\crab rave.wav").getAbsoluteFile()); 
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
            
        }
        catch (Exception e) {
        }
        JButton pause = new JButton("Pause");
        JButton play = new JButton("Play");
        frame.setLayout(null);
        pause.setBounds(100,100,100,100);
        pause.setBounds(100,210,100,100);
        frame.add(play);
        frame.add(pause);
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clip.isActive()) {
                    position = clip.getFramePosition();
                    clip.stop();
                    pause.setText("Play");

                }
                else{
                    try {
                        AudioInputStream audioInputStream =  AudioSystem.getAudioInputStream(new File("C:\\Users\\Rishi (New)\\Downloads\\sound\\crab rave.wav").getAbsoluteFile()); 
                        clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.setFramePosition(position);
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    } 
                    pause.setText("Pause");
                }
            }
            
        });
       
        
    }
}
