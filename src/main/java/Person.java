/**
 * Created by lenovo on 2017/2/16.
 */
@Persistent(table = "person_info")
public class Person {
    @Id(column = "person_id", type = "integer", generator = "identity")
    private int id;
    @Property(column = "name", type = "string")
    private String name;
    @Property(column = "age", type = "int")
    private int age;
}
