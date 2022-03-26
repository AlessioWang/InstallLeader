//package InstallLeader.Test;
//
//import mslinks.ShellLink;
//import mslinks.ShellLinkException;
//import mslinks.ShellLinkHelper;
//
//import javax.swing.filechooser.FileSystemView;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
///**
// * @auther Alessio
// * @date 2022/3/10
// **/
//public class shortCut {
//
//    public static class Main {
//        public static void main(String[] args) throws IOException, ShellLinkException {
//            FileSystemView view = FileSystemView.getFileSystemView();
//            File file = view.getHomeDirectory();
//            System.out.println(file.getPath());
//
//            Path tPath = Path.of( "E:\\INST.AAA\\智慧水务\\runTest.vbs");
//            String root = tPath.getRoot().toString();
//            String path = tPath.subpath(0, tPath.getNameCount()).toString();
//            System.out.println("root : " + root);
//            System.out.println("path : " + path);
//
//
//            ShellLink sl = new ShellLink()
//                    .setIconLocation("E:\\INST.AAA\\icon.ico");
//
//            new ShellLinkHelper(sl)
//                    .setLocalTarget(root, path)
//                    .saveTo("C:\\Users\\Alessio\\Desktop\\ddsssssddd.lnk");
//        }
//    }
//}
