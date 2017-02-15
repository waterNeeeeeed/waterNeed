import java.lang.annotation.*;

/**
 * Created by lenovo on 2017/2/15.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
@Documented
public @interface Property {
    String column();
    String type();
}
