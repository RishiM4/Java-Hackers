package com.javahackers;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

import org.w3c.dom.Text;

public class Main extends JFrame {
    private static final long serialVersionUID = 1L;
    private ArrayList<Point> chP = new ArrayList<>();
    private JTextArea textArea;

    public void CR() {
        setTitle("Crosshair Recorder");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        JScrollPane sp = new JScrollPane(ta);
        add(sp, BorderLayout.CENTER);

        addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseMoved(MouseEvent e) {
                Point mp = e.getPoint();
                chP.add(mp);
                textArea.append("Mouse Position: " + mp.toString() + "\n");
            }
        });

        JButton sb = new JButton("Save Crosshair Data");
        sb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                schd();
            }
        });
        add(sb, BorderLayout.SOUTH);
    }

    private void schd() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("crosshair_positions.txt"))) {
            for (Point p : chP) {
                writer.write(p.x + "," + p.y);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "Crosshair positions saved to 'crosshair_positions.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}