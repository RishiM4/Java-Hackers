package com.javahackers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AudioPlayer {
    static Clip clip;
    static AudioInputStream audioInputStream;
    static int position = 0;
    public JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setSize(400,400);
        panel.setVisible(true);
        try {
            AudioInputStream audioInputStream =  AudioSystem.getAudioInputStream(new File("C:\\Users\\Rishi (New)\\Downloads\\sound\\crab rave.wav").getAbsoluteFile()); 
            clip = AudioSystem.getClip();
            //clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
            
        }
        catch (Exception e) {
        }
        JButton pause = new JButton("Play");
        JButton play = new JButton("Play");
        panel.setLayout(null);
        pause.setBounds(100,100,100,100);
        pause.setBounds(100,210,100,100);
        panel.add(play);
        panel.add(pause);
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
       
        return panel;
    
    }
    public static void main(String[] args) {

    }
}
