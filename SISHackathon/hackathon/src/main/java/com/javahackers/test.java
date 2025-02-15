package com.javahackers;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoWriter;

public class test {
    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        String[] imageFiles = {
            "path/to/image1.jpg",
            "path/to/image2.jpg",
            "path/to/image3.jpg"
            // Add more image paths here
        };

        String outputVideoFile = "path/to/output/video.avi";
        int frameRate = 30; // Frames per second

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
