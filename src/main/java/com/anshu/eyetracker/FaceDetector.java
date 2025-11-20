package main.java.com.anshu.eyetracker;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetector {
    CascadeClassifier face = new CascadeClassifier("haarcascade_frontalface_default.xml");
    CascadeClassifier eyes = new CascadeClassifier("haarcascade_eye.xml");

    EyeTracker eyeTracker = new EyeTracker();

    public void process(Mat frame) {
        MatOfRect faces = new MatOfRect();
        face.detectMultiScale(frame, faces);

        for (Rect f : faces.toArray()) {
            Mat roi = frame.submat(f);
            MatOfRect eyeDet = new MatOfRect();
            eyes.detectMultiScale(roi, eyeDet);

            eyeTracker.trackEyes(roi, eyeDet);
        }
    }
}

