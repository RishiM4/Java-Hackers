package com.javahackers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class ScreenRecorder {

    private static Robot robot;
    private static Rectangle screenRect;
    private static BufferedImage screenImage;
    private static String outputFilePath = "output.mp4"; // Change path to your preferred location
    private static Process ffmpegProcess;

    public static void main(String[] args) throws AWTException, IOException {
        robot = new Robot();
        screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        // Start the FFmpeg process
        startFFmpegRecording();

        // Set up GUI
        JFrame frame = new JFrame("Screen Recorder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);

        JButton startButton = new JButton("Start Recording");
        startButton.addActionListener(e -> startRecording());
        frame.getContentPane().add(startButton, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void startFFmpegRecording() {
        // FFmpeg command for screen recording
        String ffmpegCommand = "ffmpeg -y -f rawvideo -vcodec rawvideo -pix_fmt rgb24 -s " + screenRect.width + "x" + screenRect.height +
                " -r 30 -i - -an -vcodec libx264 -pix_fmt yuv420p -preset fast -crf 22 " + outputFilePath;

        try {
            ffmpegProcess = new ProcessBuilder("cmd", "/c", ffmpegCommand).start();
            OutputStream ffmpegInputStream = ffmpegProcess.getOutputStream();
            BufferedImage img;
            byte[] imageData;
            int[] pixels;
            while (true) {
                img = robot.createScreenCapture(screenRect);
                imageData = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
                ffmpegInputStream.write(imageData);
                ffmpegInputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startRecording() {
        // Start recording the screen
        new Thread(() -> {
            try {
                startFFmpegRecording();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
