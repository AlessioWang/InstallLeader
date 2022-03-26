package InstallLeader.Test;

import javafx.event.ActionEvent;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;

/**
 * @auther Alessio
 * @date 2022/3/24
 **/
public class FileTest {


    public static void main(String[] args)
    {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showSaveDialog(null);

        System.out.println(f.getCurrentDirectory());
        System.out.println(f.getSelectedFile());
    }

}
