import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import java.io.*;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/15.
 */
public class Main {
    public static void main(String[] args){
        try{
            /*System.out.println(System.getenv());
            Map m = System.getenv();
            for (Object key: m.keySet()){
                System.out.println(m.get(key));
            }
            System.getenv().forEach((o1, o2)->{
                System.out.println(o1 + ":" + o2);
            });
            System.out.println(System.getProperty("user.dir"));
            System.getProperties().forEach((o, o2) -> {
                System.out.println(o + ":" + o2);
            });*/

            /*InputStream in = new FileInputStream("D:\\IdeaProjects\\test\\src\\main\\java\\Person.java");
            in.close();*/
            /*System.out.println(System.getProperty("user.dir"));
            System.setProperty("user.dir", "D:\\IdeaProjects\\test\\target\\classes");
            System.out.println(System.getProperty("user.dir"));*/
            String[] cmd = {"javac", "-processor", "HibernateAnnotationProcessor", "Person.java"};
            Process p = Runtime.getRuntime().exec(cmd);

            p.waitFor();
            File test = new File("Person.hbm.xml");
            if (test.exists()){
                System.out.println("Success!!!");
            }
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

    }
}
