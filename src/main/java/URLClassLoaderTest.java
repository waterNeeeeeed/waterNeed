import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

/**
 * Created by hasee-pc on 2017/2/19.
 */
public class URLClassLoaderTest {
    public static void main(String[] args){
        try {
            URL[] urls = {new URL("file:mysql/mysql-connector-java-5.1.40-bin.jar"),
                    new URL("file:///C:/IdeaProjects/waterNeed/src/main/java/mysql/mysql-connector-java-5.1.40-bin.jar")};
            URLClassLoader mcl = new URLClassLoader(urls);
            Driver driver = (Driver)mcl.loadClass("com.mysql.jdbc.Driver").newInstance();
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "gt1987");
            Connection conn = driver.connect("jdbc:mysql://localhost:3306/chat", info);
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
