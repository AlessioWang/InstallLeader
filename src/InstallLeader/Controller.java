package InstallLeader;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.stream.Stream;

public class Controller extends GridPane {

    @FXML
    Button sdkBtn;
    @FXML
    Button vbsBtn;
    @FXML
    Button jdkBtn;

    @FXML
    Button confirmBtn;
    @FXML
    Button helpBtn;

    @FXML
    TextField sdkText;
    @FXML
    TextField vbsText;
    @FXML
    TextField jdkText;


    //vbs的路径
    public String sdkPath;
    public String vbsPath;
    public String jdkPath;

    //vbs文件
    public File file;


    private String signal = "PATHSIGNAL";
    private String jdkName = "jdk11.0.1064.msi";
    private String folderName = "InstallLeader";
    private String defVbsPath = "RuralSewage_JavaFx_jar\\启动.vbs";
    private String defSdkPath = "javafx-sdk-11.0.2\\lib";


//    private static String signal;
//    private static String jdkName;
//    private static String folderName;
//    private static String defVbsPath;
//    private static String defSdkPath;

//    static {
//        ResourceBundle bundle = ResourceBundle.getBundle("properties/installConfig");
//        signal = bundle.getString("SIGNAL");
//        jdkName = bundle.getString("JDK_NAME");
//        folderName = bundle.getString("FOLDER_NAME");
//        defVbsPath = bundle.getString("DEF_VBS_NAME");
//        defSdkPath = bundle.getString("DEF_SDK_PATH");
//        System.out.println(signal);
//        System.out.println(jdkName);
//        System.out.println(folderName);
//        System.out.println(defVbsPath);
//        System.out.println(defSdkPath);
//    }

    public Controller() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        initPaths();
        setOnAction();
    }

    public void initPaths() {
        String current = System.getProperty("user.dir").split(folderName)[0];

        sdkPath = current + defSdkPath;
        vbsPath = current + defVbsPath;

        jdkPath = current.split(folderName)[0] + jdkName;

        sdkText.setText(sdkPath);
        vbsText.setText(vbsPath);
        jdkText.setText(jdkPath);

        file = new File(vbsText.getText());
    }

    public void setOnAction() {
        sdkBtn.setOnAction(event -> {
            setSDKFolderPath(sdkText);
        });

        vbsBtn.setOnAction(event -> {
            setVBSPath(vbsText);
            file = new File(vbsText.getText());
        });

        jdkBtn.setOnAction(event -> {
            setJDKPath(jdkText);
        });

        confirmBtn.setOnAction(event -> {
            replaceLocation();
            callExe(jdkPath);
            new AlertErrorCreator("安装提示", "安装运行环境", "请等待运行环境安装完毕并关闭窗口");
//            System.out.println(jdkPath);
//            try {
//                File file=new File("src/InstallLeader/resources/pic/icon64.ico");
//                createShortCut(vbsText.getText(), "智慧水务.lnk", file.getAbsolutePath());
//            } catch (ShellLinkException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        });

        helpBtn.setOnAction(event -> {
            new AlertErrorCreator("帮助", "智慧水务安装流程帮助", "请等待运行环境安装完毕并关闭窗口");
        });
    }

    /**
     * 替换指定vbs的signal位置的字符
     */
    public void replaceLocation() {
        BufferedReader in;
        StringBuilder sb = new StringBuilder();
        if (file != null) {
            try {
                in = new BufferedReader(new FileReader(file));
                Stream<String> stream = in.lines();
                stream.forEach(s -> {
                    s = s.replace(signal, sdkText.getText());
                    sb.append(s);
                    sb.append("\n");
                    System.out.println(s);
                });
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }

        try {
            FileWriter file = new FileWriter(vbsText.getText());
            BufferedWriter output = new BufferedWriter(file);
            output.write(sb.toString());
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void output(String data) {
        try {
            FileWriter file = new FileWriter(vbsText.getText());
            BufferedWriter output = new BufferedWriter(file);
            output.write(data);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setSDKPath(TextField field) {
        String[] pair1 = {"*", "*"};

        String chosenPath = getFileOpenPath("选择路径", this, pair1);
        System.out.println("cc : " + chosenPath);
        if (chosenPath != null) {
            sdkPath = chosenPath;
            field.setText(sdkPath);
        }
    }

    public void setSDKFolderPath(TextField field) {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showOpenDialog(null);
        f.setCurrentDirectory(new File(System.getProperty("user.dir")));
        String chosenPath = f.getSelectedFile().toString();
        field.setText(chosenPath);
        System.out.println(chosenPath);
    }

    public void setVBSPath(TextField field) {
        String[] pair1 = {"VBS", "*.vbs"};
        String[] pair2 = {"*", "*"};

        String chosenPath = getFileOpenPath("选择路径", this, pair1, pair2);
        System.out.println("vbsPath : " + chosenPath);
        if (chosenPath != null) {
            vbsPath = chosenPath;
            field.setText(vbsPath);
        }
    }

    public void setJDKPath(TextField field) {
        String[] pair1 = {"MSI", "*.msi"};
        String[] pair2 = {"EXE", "*.exe"};
        String[] pair3 = {"*", "*"};

        String chosenPath = getFileOpenPath("选择路径", this, pair1, pair2, pair3);
        System.out.println("jdkPath : " + chosenPath);
        if (chosenPath != null) {
            jdkPath = chosenPath;
            field.setText(jdkPath);
        }
    }


    //获取文件的位置
    public String getFileOpenPath(String title, Pane pane, String[]... fileData) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        for (String[] pair : fileData) {
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter(pair[0], pair[1])
            );
        }
        File file = fileChooser.showOpenDialog(pane.getScene().getWindow());
        if (file != null) {
            return file.getPath();
        } else
            return null;
    }

//    public void createShortCut(String linkPath, String scName, String iconPath) throws ShellLinkException, IOException {
//        FileSystemView view = FileSystemView.getFileSystemView();
//        File file = view.getHomeDirectory();
//        String home = file.getPath();
//
//        ShellLink sl = new ShellLink()
//                .setIconLocation(iconPath);
//
//        Path tPath = Path.of(linkPath);
//        String root = tPath.getRoot().toString();
//        String path = tPath.subpath(0, tPath.getNameCount()).toString();
//
//        new ShellLinkHelper(sl)
//                .setLocalTarget(root, path)
//                .saveTo(home + "\\" + scName);
//        System.out.println(home + "\\" + scName);
//    }

    public void callExe(String path) {
        try {
            Desktop.getDesktop().open(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
