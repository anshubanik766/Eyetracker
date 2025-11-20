package main.java.com.anshu.eyetracker;

public class AppLauncher {

    public void launch(String zone) {
        try {
            switch(zone) {
                case "LEFT":
                    Runtime.getRuntime().exec("cmd /c start chrome");
                    break;
                case "RIGHT":
                    Runtime.getRuntime().exec("cmd /c start discord");
                    break;
                case "TOP":
                    Runtime.getRuntime().exec("cmd /c explorer");
                    break;
                case "BOTTOM":
                    Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
                    break;
                case "CENTER":
                    System.out.println("HOME");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

