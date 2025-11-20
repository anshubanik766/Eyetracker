package main.java.com.anshu.eyetracker;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class CameraFeed {
    VideoCapture cam = new VideoCapture(0);
    FaceDetector faceDetector = new FaceDetector();

    public void start() {
        Mat frame = new Mat();
        while (cam.read(frame)) {
            faceDetector.process(frame);
        }
    }
}

