package com.runfeng.test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by lenovo on 2017/2/16.
 */
public class Main {
    public static void main(String[] args)
            throws IOException {
        System.out.println(System.getProperty("user.dir"));
        File f = new File("src\\main\\java\\com\\runfeng\\test\\test.txt");
        if (f.exists()) {
            System.out.println("S");
        }

        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        //Reader r = new FileReader("src\\main\\java\\com\\runfeng\\test\\test.txt");
        //Charset cs = Charset.availableCharsets().get("UTF-8");
        Charset cs = Charset.availableCharsets().get("GBK");
        FileInputStream fin = new FileInputStream("src\\main\\java\\com\\runfeng\\test\\test.txt");
        InputStreamReader inR = new InputStreamReader(fin, cs);

        char[] buffer = new char[4096];
        inR.read(buffer);
        inR.close();
        System.out.println(new String(buffer));

        fin = new FileInputStream("src\\main\\java\\com\\runfeng\\test\\test.txt");
        inR = new InputStreamReader(fin, cs);
        BufferedReader r = new BufferedReader(inR);
        inR =  new InputStreamReader(fin, cs);
        System.out.println(r.readLine());
        r.close();
        fin = new FileInputStream("src\\main\\java\\com\\runfeng\\test\\test-uft8.txt");
        int i = 0;
        while ((i=fin.read()) != -1){
            System.out.print(Integer.toHexString(i));
        }

        /*

    D:\IdeaProjects\test
..\src\main\java\com\runfeng\test\test.txt
D:\IdeaProjects\test\..\src\main\java\com\runfeng\test\test.txt
D:\IdeaProjects\src\main\java\com\runfeng\test\test.txt
     */
    }

}
