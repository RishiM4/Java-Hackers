package com.javahackers;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoWriter;

public class test {
    

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        String[] imageFiles = {
            "C:\\Users\\Vasudha\\New Folder\\Java-Hackers\\screenshot0.png",
            "C:\\Users\\Vasudha\\New Folder\\Java-Hackers\\screenshot1.png",
            "C:\\Users\\Vasudha\\New Folder\\Java-Hackers\\screenshot2.png",
            "C:\\Users\\Vasudha\\New Folder\\Java-Hackers\\screenshot3.png",
            "C:\\Users\\Vasudha\\New Folder\\Java-Hackers\\screenshot4.png",
            "C:\\Users\\Vasudha\\New Folder\\Java-Hackers\\screenshot5.png",
            "C:\\Users\\Vasudha\\New Folder\\Java-Hackers\\screenshot6.png",
            "C:\\Users\\Vasudha\\New Folder\\Java-Hackers\\screenshot7.png",
            "C:\\Users\\Vasudha\\New Folder\\Java-Hackers\\screenshot8.png",
            "C:\\Users\\Vasudha\\New Folder\\Java-Hackers\\screenshot9.png",
        };

        String outputVideoFile = "path/to/output/video.avi";
        int frameRate = 10; // Frames per second

        // Read the first image to get the size
        Mat firstImage = Imgcodecs.imread(imageFiles[0]);
        Size frameSize = new Size(firstImage.cols(), firstImage.rows());

        // Create a VideoWriter object
        VideoWriter videoWriter = new VideoWriter(
            outputVideoFile,
            0,
            frameRate,
            frameSize,
            true
        );

        if (!videoWriter.isOpened()) {
            System.out.println("Error: Could not open video file for writing.");
            return;
        }

        // Write each image to the video
        for (String imageFile : imageFiles) {
            Mat image = Imgcodecs.imread(imageFile);
            if (image.empty()) {
                System.out.println("Error: Could not read image " + imageFile);
                continue;
            }
            videoWriter.write(image);
        }

        // Release the VideoWriter
        videoWriter.release();
        System.out.println("Video created successfully!");
    }
}
