package com.javahackers;

import java.util.Scanner;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FinanceManager {
    static String temp = "";
    public static void main(String[] args) {
        JFrame frame = new JFrame("Finance Manager");
        frame.setSize(frame.getMaximumSize());
        frame.setVisible(true);
        frame.setLayout(null);
        JTextField deposit = new JTextField();
        deposit.setBounds(500,225, 500,300);
        frame.add(deposit);
        JLabel stuffie = new JLabel();
        stuffie.setBounds(0, 0, 1, 1);
        frame.add(stuffie);
        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = deposit.getText();
                stuffie.setText(stuffie.getText()+"\n"+temp);
            }
        });
        JButton button = new JButton();
        button.setBounds(10, 225, 490,300);
        button.setText("Click to add record of Transaction/Deposit");
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = deposit.getText();
                stuffie.setText(stuffie.getText()+"\n"+temp + ", ");
                deposit.setText("");
            }
        });
        JButton button2 = new JButton();
        button2.setBounds(1000, 225, 490,150);
        button2.setText("Click to see History of Transactions/Deposits");
        frame.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = deposit.getText();
                stuffie.setBounds(500, 0, 500, 780);
                Border border = BorderFactory.createBevelBorder(0,Color.BLACK,Color.GRAY);
                stuffie.setBorder(border);
                deposit.setBounds(0,0, 1,1);
            };
        });
        JButton button3 = new JButton();
        button3.setBounds(1000, 375, 490,150);
        button3.setText("Click to add record of Transaction/Deposit again");
        frame.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp = deposit.getText();
                stuffie.setBounds(0, 0, 1, 1);
                deposit.setBounds(500,225, 500,300);
            };
        });

    }
}
