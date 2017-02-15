import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;

/**
 * Created by lenovo on 2017/2/15.
 */
public class Main {
    public static void main(String[] args){
        Processor p = new HibernateAnnotationProcessor();
        //p.process();
        RoundEnvironment runtimeEnvironment;
    }
}
