package com.javahackers;

import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FinanceManager {
    static String temp = "";
    public static void main(String[] args) {
        JFrame frame = new JFrame("Finance Manager");
        frame.setSize(frame.getMaximumSize());
        frame.setVisible(true);
        frame.setLayout(null);
        JTextField deposit = new JTextField();
        deposit.setBounds(500,265, 500,300);
        frame.add(deposit);
        JLabel stuffie = new JLabel();
        stuffie.setBounds(0, 0, 100, 10);
        frame.add(stuffie);
        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = deposit.getText();
                stuffie.setText(stuffie.getText()+"\n"+temp);
            }
        });
    }
}
