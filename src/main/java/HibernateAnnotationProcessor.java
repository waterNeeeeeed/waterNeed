import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Set;

/**
 * Created by lenovo on 2017/2/15.
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"Persistent", "Id", "Property"})
public class HibernateAnnotationProcessor
    extends AbstractProcessor{

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv){
        super.init(processingEnv);
    }
    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()){
            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Processing...");
        }

        PrintStream ps = null;
        try {
            for (Element t : roundEnv.getElementsAnnotatedWith(Persistent.class)){

                Name clzzName = t.getSimpleName();
                Persistent per = t.getAnnotation(Persistent.class);

                ps = new PrintStream(new FileOutputStream(clzzName + ".hbm.xml"));
                PrintWriter printWriter = new PrintWriter(new FileOutputStream("temp.txt"));
                printWriter.write(clzzName.toString());
                printWriter.close();
                ps.println("<?xml version=\"1.0\"?>");
                ps.println("<!DOCTYPE hibernate-mapping PUBLIC  \"-//Hibernate/Hibernate Mapping DTD 3.0//EN\"");
                ps.println("    \"http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd\">");
                ps.println("<hibernate-mapping>");
                ps.println("  <class name=\"" + t + "\" table=\"" + per.table() + "\" >" );
                for (Element e : t.getEnclosedElements()){
                    if (e.getKind() == ElementKind.FIELD){
                        Id id = e.getAnnotation(Id.class);
                        if (id != null){
                            ps.println("      <id name=\"id\" column=\"" + id.column() + "\" "
                                    + "type=\"" + id.type() + "\" " + ">");
                            ps.println("          <generator name=\"" + id.generator() + "\" />");
                            ps.println("      </id>");
                        }

                        Property pro = e.getAnnotation(Property.class);
                        if (pro != null){
                            ps.println("      <property column=\"" + pro.column()
                                        + "\" type=\"" + pro.type() + "\" />");
                        }

                    }

                }
                ps.println(" </class>");
                ps.println("</hibernate-mapping>");

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            if (ps != null){
                try{
                    ps.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
        return true;
    }
}
