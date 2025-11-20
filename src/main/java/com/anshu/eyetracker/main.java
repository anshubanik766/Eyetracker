package main.java.com.anshu.eyetracker;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;

public class Main {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("OpenCV loaded: " + Core.VERSION);

        VideoCaptureManager cam = new VideoCaptureManager();
        UIOverlay ui = new UIOverlay();

        if (!cam.isOpened()) {
            System.out.println("Camera not detected!");
            return;
        }

        while (true) {
            Mat frame = cam.readFrame();
            if (frame.empty()) {
                System.out.println("Camera frame empty");
                break;
            }

            frame = ui.draw(frame);
            HighGui.imshow("Eye Tracking UI", frame);

            if (HighGui.waitKey(1) == 27) break; // ESC key to exit
        }

        cam.release();
    }
}



