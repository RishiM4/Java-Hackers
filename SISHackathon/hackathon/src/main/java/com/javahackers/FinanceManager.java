package com.javahackers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FinanceManager {
    static String temp = "";
    static double budg = 0;
    static double won = (budg * 1438.76);
    static double rupees = (budg * 86.79);
    static double euro = (budg * 0.95);
    static double yen = (budg * 152.53);
    static double dirham = (budg * 3.67);
    static double bitcoiny = (budg * 0.000010);
    public static void main(String[] args) {
        JFrame frame = new JFrame("Finance Manager");
        frame.setSize(frame.getMaximumSize());
        frame.setVisible(true);
        frame.setLayout(null);
        JTextField deposit = new JTextField();
        deposit.setBounds(500,225, 250,300);
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
        JTextField budget = new JTextField();
        budget.setBounds(750, 225, 250, 300);
        frame.add(budget);
        try {
            budg = Integer.parseInt(budget.getText());
        } catch (Exception e) {
        }
        JLabel budgetladel = new JLabel();
        
                JButton button = new JButton();
                button.setBounds(10, 225, 490,100);
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
                button2.setBounds(1000, 225, 490,100);
                button2.setText("Click to see History of Transactions/Deposits");
                frame.add(button2);
                button2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        temp = deposit.getText();
                        stuffie.setBounds(500, 0, 500, 780);
                        Border border = BorderFactory.createBevelBorder(0,Color.BLACK,Color.GRAY);
                        stuffie.setBorder(border);
                        budget.setBounds(0,0, 1,1);
                        deposit.setBounds(0,0, 1,1);
                    };
                });
                JButton button3 = new JButton();
                button3.setBounds(1000, 325, 490,100);
                button3.setText("Click to add record of Transaction/Deposit again");
                frame.add(button3);
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        temp = deposit.getText();
                        stuffie.setBounds(0, 0, 1, 1);
                        deposit.setBounds(500,225, 500,300);
                        budget.setBounds(750, 225, 250, 300);
                    };
                });
            
                JButton button4 = new JButton();
                button4.setBounds(10, 325, 490,100);
                button4.setText("Click to create/change budget limit");
                frame.add(button4);
                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            budg = Integer.parseInt(budget.getText());
                        } catch (Exception f) {
                            JOptionPane.showMessageDialog(frame, "Please enter a Integer without a currency sign    ", "error", 0);
                           return;
                        }
                        deposit.setBounds(500,225, 250,300);
                        budget.setBounds(750, 225, 250, 300);
                        budgetladel.setBounds(100, 50, 300, 100);
                        budgetladel.setText("");
                        budgetladel.setText("Your Budget For Today Is : $" + budg);
                        frame.add(budgetladel);
                        frame.setSize(399,399);
                        frame.setSize(frame.getMaximumSize());
                    };
                });
                JButton button5 = new JButton();
                button5.setBounds(10, 425, 490,100);
                button5.setText("Click to clear your Deposit/Transaction History");
                frame.add(button5);
                button5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        stuffie.setText("");
                    };
                });
                JLabel moneys= new JLabel("");
                moneys.setBounds(390, 600, 800, 100);
                frame.add(moneys);
                JButton button6 = new JButton();
                button6.setBounds(1000, 425, 490,100);
                button6.setText("Click to convert your budget to a different currency");
                frame.add(button6);
                button6.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            budg = Integer.parseInt(budget.getText());
                        } catch (Exception f) {
                            // TODO: handle exception
                        }
                          won = (budg * 1438.76);
                          rupees = (budg * 86.79);
                          euro = (budg * 0.95);
                          yen = (budg * 152.53);
                          dirham = (budg * 3.67);
                          bitcoiny = (budg * 0.000010);
                        moneys.setText("$" + budg + " = " + won + " won, \n" + rupees + "rupees, \n" + euro + "euros, \n" + yen + "yen, \n" + dirham + "Dirhams, & \n" + bitcoiny + "bitcoins!");
                       
                        frame.setSize(399,399);
                        frame.setSize(frame.getMaximumSize());
                    };
                });

                frame.setSize(399,399);
                frame.setSize(frame.getMaximumSize());
            }
            
}
