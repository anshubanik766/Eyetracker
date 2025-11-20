package main.java.com.anshu.eyetracker;

public class GazeZoneManager {
    AppLauncher launcher = new AppLauncher();

    long gazeStart = 0;
    String activeZone = "CENTER";

    public void update(int x, int y) {
        String zone = getZone(x, y);

        if (!zone.equals(activeZone)) {
            activeZone = zone;
            gazeStart = System.currentTimeMillis();
        }

        if (System.currentTimeMillis() - gazeStart > 1200) {
            launcher.launch(activeZone);
        }
    }

    private String getZone(int x, int y) {
        if (x < 200) return "LEFT";
        if (x > 440) return "RIGHT";
        if (y < 150) return "TOP";
        if (y > 350) return "BOTTOM";
        return "CENTER";
    }
}

