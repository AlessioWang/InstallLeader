package InstallLeader.Test;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * @auther Alessio
 * @date 2022/3/24
 **/
public class CallTest {
    public static void main(String[] args) {
        try {
            Desktop.getDesktop().open(new File("C:\\Program Files\\Adobe\\Adobe Photoshop CC 2018\\Photoshop.exe"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void callExe(String path){
        try {
            Desktop.getDesktop().open(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
