package Soku;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class demo {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter buf2 = new BufferedWriter(new FileWriter("test.txt"));
        System.out.println("请输入想要说的话:");
        String str = buf.readLine();
        while (!str.equals("YES")) {
            buf2.write(str);
            buf2.newLine();

            System.out.println("是否退出？输入YES退出:");
            str = buf.readLine();
        }

        buf.close();
        buf2.close();

        Path path = Paths.get("C:\\Users\\h2906\\Desktop\\javaproject\\test.txt");
        String data = Files.readString(path);
        System.out.println("文本文件内有:" + data);
    }
}
