package com.runfeng.apt;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;

/**
 * Created by lenovo on 2017/2/15.
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"Persistent", "Id", "Property"})
public class HibernateAnnotationProcessor
    extends AbstractProcessor{
    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment roundEnv) {
        PrintStream ps = null;
        for (Element t : roundEnv.getElementsAnnotatedWith(Persistent.class)){
            try {
                Name clzzName = t.getSimpleName();
                Persistent per = t.getAnnotation(Persistent.class);

                ps = new PrintStream(new FileOutputStream(clzzName + ".hbm.xml"));
                ps.print("<?xml version=\"1.0\"?>");
                ps.print("<hibernate-mapping>");
                ps.print("  <class name=\"" + t + "\" table=\"" + per.table() + "\" >" );
                for (Element e : t.getEnclosedElements()){
                    Id id = e.getAnnotation(Id.class);
                    ps.print("      <id name=\"id\" column=\"" + id.column() + "\" "
                            + "type=\"" + id.type() + "\" " + ">");
                    ps.print("          <generator name=\"" + id.generator() + "\" />");
                    ps.print("      </id>");
                    Property[] pros = e.getAnnotationsByType(Property.class);
                    for (Property p : pros){
                        ps.print("      <property column=\"" + p.column()
                                + "\" type=\"" + p.type() + "\" />");
                    }
                }
                ps.print(" </class>");
                ps.print("</hibernate-mapping>");


            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
