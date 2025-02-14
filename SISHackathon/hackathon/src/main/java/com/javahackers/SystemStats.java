package com.javahackers;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

public class SystemStats {
    static JPanel panel = new JPanel();
    static JLabel label1 = new JLabel("Total Memory: Loading...");
    static JLabel label2= new JLabel("Used Memory: Loading...");
    static JLabel label3 = new JLabel("Available Memory: Loading...");
    static JLabel label4 = new JLabel("Ram Usage: Loading...");
    static JLabel label5 = new JLabel("CPU Usage: Loading...");

    public JPanel createPanel() {
        Timer timer = new Timer();
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                SystemInfo systemInfo = new SystemInfo();
                HardwareAbstractionLayer hardware = systemInfo.getHardware();
                GlobalMemory globalMemory = hardware.getMemory();
                label1.setText("Total Memory: "+globalMemory.getTotal()/(1024*1024)+" MB");
                label1.setBounds(25,25,200,50);
                label2.setText("Used Memory: "+(globalMemory.getTotal()-globalMemory.getAvailable())/(1024*1024)+" MB");
                label2.setBounds(25,50,200,50);

                label3.setText("Available Memory: "+globalMemory.getAvailable()/(1024*1024)+" MB");
                label3.setBounds(25,75,200,50);

                label4.setText("Ram Usage: "+(Math.round(((globalMemory.getTotal()-globalMemory.getAvailable()))/(.1024*.1024))/globalMemory.getTotal())+"%");
                label4.setBounds(25,100,200,50);

                
                panel.add(label1);
                panel.add(label2);
                panel.add(label3);
                panel.add(label4);
                panel.add(label5);
                CentralProcessor cpu = hardware.getProcessor();
                long[] prevTicks = cpu.getSystemCpuLoadTicks();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                double cpuLoad = cpu.getSystemCpuLoadBetweenTicks(prevTicks);

                double cpuUsagePercentage = cpuLoad * 100;
                label5.setText("CPU Usage: "+ (Math.round(cpuUsagePercentage*100)/100)+"%");
                label5.setBounds(25,125,200,50);
                panel.setSize(399,399);
                panel.setSize(400,400);
            }
        };
        
        timer.scheduleAtFixedRate(task, 0, 1); 
        
        panel.setSize(400,400);
        panel.setVisible(true);
        panel.setLayout(null);
       
        

        return panel;
        
    }


    
    public static void main(String[] args) {

    }
}