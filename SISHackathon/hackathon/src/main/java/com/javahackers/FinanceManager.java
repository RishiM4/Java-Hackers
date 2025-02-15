package com.javahackers;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FinanceManager {
    static String temp = "";
    static double budg = 0;
    static double won = (budg * 1438.75);
    static double rupees = (budg * 86.8);
    static double euro = (budg * 0.95);
    static double yen = (budg * 152.5);
    static double dirham = (budg * 3.67);
    static double bitcoiny = (budg * 0.00001);
    static JLabel moneys;
    static JLabel moneys2;
    static JLabel moneys3;
    static JLabel moneys4;
    static JLabel moneys5;
    static JLabel moneys6;
    static JLabel jfj;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Finance Manager");
        frame.setSize(frame.getMaximumSize());
        frame.setVisible(true);
        frame.setLayout(null);
        JTextField deposit = new JTextField();
        deposit.setBounds(500,225, 500,300);
        deposit.setToolTipText("Type Budget Limit/Transaction Log Entry Here.");
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
        JLabel budgetladel = new JLabel();
        budgetladel.setText("Your Budget For Today Is : $ __");
        budgetladel.setBounds(100, 76, 300, 100);
        frame.add(budgetladel);
        JLabel d1 = new JLabel();
        d1.setBounds(420,40,700, 150);
        d1.setText("Money Budgeting And Tracking App");
        d1.setFont(new Font("Serif", Font.PLAIN, 45));
        frame.add(d1);
        Calendar c = Calendar.getInstance();
        String time = c.getTime().toString();
        JLabel timylabel = new JLabel();
        timylabel.setBounds(1200, 84, 200, 80);
        timylabel.setText(time);
        frame.add(timylabel);
        
                JButton button = new JButton();
                button.setBounds(10, 225, 490,100);
                button.setText("1. Click to add record of Transaction/Deposit");
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
                button2.setText("4. Click to see History of Transactions/Deposits");
                frame.add(button2);
                button2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        temp = deposit.getText();
                        stuffie.setBounds(500, 225, 500, 300);
                        Border border = BorderFactory.createBevelBorder(0,Color.BLACK,Color.GRAY);
                        stuffie.setBorder(border);
                        deposit.setBounds(0,0, 1,1);
                    };
                });
                JButton button3 = new JButton();
                button3.setBounds(1000, 325, 490,100);
                button3.setText("5. Back to Main Screen");
                frame.add(button3);
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        temp = deposit.getText();
                        stuffie.setBounds(0, 0, 1, 1);
                        deposit.setBounds(500,225, 500,300);
                    };
                });
            
                JButton button4 = new JButton();
                button4.setBounds(10, 325, 490,100);
                button4.setText("2. Click to create/change budget limit");
                frame.add(button4);
                button4.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                        try {
                            budg = Integer.parseInt(deposit.getText());
                        } catch (Exception f) {
                            JOptionPane.showMessageDialog(frame, "Please enter a Integer without a currency sign    ", "error", 0);
                           return;
                        }
                        deposit.setBounds(500,225, 500,300);
                        budgetladel.setText("");
                        budgetladel.setText("Your Budget For Today Is : $" + budg);
                        frame.setSize(399,399);
                        frame.setSize(frame.getMaximumSize());
                    };
                });
                JButton button5 = new JButton();
                button5.setBounds(10, 425, 490,100);
                button5.setText("3. Click to clear your Deposit/Transaction History");
                frame.add(button5);
                button5.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        stuffie.setText("");
                    };
                });
                 moneys= new JLabel();
                moneys.setBounds(500,550, 200, 60);
                moneys.setText("$ __" + "   =    ___ Won!");
                frame.add(moneys);
                 moneys2= new JLabel();
                moneys2.setBounds(500,610, 1200, 60);
                moneys2.setText("$ __" + "   =    ___ Rupees!");
                frame.add(moneys2);
                 moneys3= new JLabel();
                moneys3.setBounds(500,670, 1200, 60);
                moneys3.setText("$ __" + "   =    ___ Euros!");
                frame.add(moneys3);
                 moneys4= new JLabel();
                moneys4.setBounds(1000,550, 1200, 60);
                moneys4.setText("$ __" + "   =    ___ Yen!");
                frame.add(moneys4);
                 moneys5= new JLabel();
                moneys5.setBounds(1000,610, 1200, 60);
                moneys5.setText("$ __" + "   =    ___ Dirhams!");
                frame.add(moneys5);
                 moneys6= new JLabel();
                moneys6.setBounds(1000,670, 1200, 60);
                moneys6.setText("$ __" + "   =    ___ Bitcoins!");
                frame.add(moneys6);
                JButton button6 = new JButton();
                button6.setBounds(1000, 425, 490,100);
                button6.setText("6. Click to convert your budget to a different currency");
                frame.add(button6);
                button6.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            budg = Integer.parseInt(deposit.getText());
                        } catch (Exception f) {
                            f.printStackTrace();
                        }
                          won = (budg * 1438.76);
                          rupees = (budg * 86.79);
                          euro = (budg * 0.95);
                          yen = (budg * 152.53);
                          dirham = (budg * 3.67);
                          bitcoiny = (budg * 0.000010);
                        moneys.setText("$" + budg + "   =   " + won + " Won!");
                        moneys.setFont(new Font("Serif", Font.PLAIN,14));
                        moneys2.setText("$" + budg + "   =   "+ rupees + " Rupees!");
                        moneys2.setFont(new Font("Serif", Font.PLAIN,14));
                        moneys3.setText("$" + budg + "   =   " + euro + " Euros!");
                        moneys3.setFont(new Font("Serif", Font.PLAIN,14));
                        moneys4.setText("$" + budg + "   =   " + yen + " Yen!");
                        moneys4.setFont(new Font("Serif", Font.PLAIN,14));
                        moneys5.setText("$" + budg + "   =   " + dirham + " Dirhams!");
                        moneys5.setFont(new Font("Serif", Font.PLAIN,14));
                        moneys6.setText("$" + budg + "   =   " + bitcoiny + " Bitcoins!");
                        moneys6.setFont(new Font("Serif", Font.PLAIN,14));
                        frame.setSize(399,399);
                        frame.setSize(frame.getMaximumSize());
                    };
                });
                JButton button7 = new JButton();
                button7.setBounds(100, 595, 100,100);
                button7.setText("HELP");
                frame.add(button7);
                button7.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame, "1) Enter your purchase along with the date and cost to log it.\n2)Type in a number to set it as your budget.\n3) Click to clear all transaction data.\n4) Click to see purchase history.\n5) Go back to original screen.\n6) See your budget in various currencies.", "Help", 0);
                    };
                });

                frame.setSize(399,399);
                frame.setSize(frame.getMaximumSize());
            }     
}