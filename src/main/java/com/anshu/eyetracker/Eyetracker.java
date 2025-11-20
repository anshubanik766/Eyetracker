package main.java.com.anshu.eyetracker;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;

class EyeTracker {
    GazeZoneManager gazeManager = new GazeZoneManager();

    public void trackEyes(Mat roi, MatOfRect eyeDet) {
        for (Rect e : eyeDet.toArray()) {
            int cx = e.x + e.width / 2;
            int cy = e.y + e.height / 2;

            gazeManager.update(cx, cy);
        }
    }
}

