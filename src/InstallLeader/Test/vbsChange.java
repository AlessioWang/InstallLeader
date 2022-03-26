package InstallLeader.Test;

import java.io.*;
import java.util.stream.Stream;

/**
 * @auther Alessio
 * @date 2022/3/9
 **/
public class vbsChange {

    public static void main(String[] args) {

        String ss = "abc";
        System.out.println(ss.replace("ab", "**"));

        File file = new File("E:\\INST.AAA\\智慧水务\\runTest.vbs");
        String path = "!!!!!!!!!!!!!!";

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            Stream<String> stream = in.lines();
            stream.forEach(s -> {
                s = s.replace("***", path);
                System.out.println(s);
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


}
