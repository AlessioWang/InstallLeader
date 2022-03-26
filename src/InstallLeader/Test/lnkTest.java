package InstallLeader.Test;

import java.io.*;

/**
 * @auther Alessio
 * @date 2022/3/9
 **/
class WindowsUtils {

    private WindowsUtils() {
    }


    private static final String WINDOWS_DESKTOP = "Desktop";
    private static String iconPath = "E:\\INST.AAA\\智慧水务\\logoIcon.ico";

    public static String getWindowsCurrentUserDesktopPath() { //return the current user desktop path
        return System.getenv("userprofile") + "/" + WINDOWS_DESKTOP;
    }

    public static void createInternetShortcutOnDesktop(String name, String target) throws IOException {
        String path = getWindowsCurrentUserDesktopPath() + "/" + name + ".URL";
        createInternetShortcut(name, path, target, iconPath);
    }

    public static void createInternetShortcutOnDesktop(String name, String target, String icon) throws IOException {
        String path = getWindowsCurrentUserDesktopPath() + "/" + name + ".URL";
        createInternetShortcut(name, path, target, icon);
    }

    public static void createInternetShortcut(String name, String where, String target, String icon) throws IOException {
        FileWriter fw = new FileWriter(where);
        fw.write("[InternetShortcut]");
        fw.write("URL=" + target
        );
        if (!icon.equals("")) {
            fw.write("IconFile=" + icon);
        }
        fw.flush();
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        WindowsUtils.createInternetShortcutOnDesktop("智慧水务", "C:\\Program Files\\Adobe\\Adobe Photoshop CC 2018\\Photoshop.exe\"", iconPath);
    }
}
