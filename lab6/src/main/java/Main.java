import annotations.Column;
import annotations.Entity;
import graph.GraphModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class Main {
    public static final String PATH = "hotel";


    public static void main(String[] args) {

        System.out.println("\t\t-- == ===  Found classes  === == —-\n");
        List<Class<?>> classList = PathScan.find(PATH);
        for (Class<?> aClass : classList) {
            System.out.println(aClass.getName());
        }

        System.out.println("\n\n\t\t-- == ===  Class fields  === == —-" );
        for (Class<?> aClass : classList) {
            System.out.println("\n" + aClass.getName());
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println("\t" + declaredField.getName() );
            }
        }

        System.out.println( "\n\n\t\t-- == ===  Class methods  === == —-" );
        for (Class<?> aClass : classList) {
            System.out.println("\n" + aClass.getName());
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                System.out.println("\t" + method.getName());
            }
        }

        System.out.println("\n\n\t\t-- == ===  Entities  === == —-\n" );
        for (Class<?> aClass : classList) {
            Annotation[] annotations = aClass.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(Entity.class)) {
                    System.out.println("\t" + aClass.getName() );
                }
            }
        }

        System.out.println("\n\n\t\t-- == ===  Attributes of entities  === == —-" );
        for (Class<?> aClass : classList) {
            if (aClass.isAnnotationPresent(Entity.class)) {
                System.out.println("\n" + aClass.getName() );
                for (Field field : aClass.getDeclaredFields()) {
                    for (Annotation a : field.getAnnotations()) {
                        if (a.annotationType().equals(Column.class)) {
                            System.out.println("\t" + field.getName() +
                                    " : "  + field.getType().getName() );
                        }
                    }
                }
            }
        }

        System.out.println( "\n\n\t\t-- == ===  GraphML  === == —-" );
        String graphXML = export(classList);
        System.out.println(graphXML);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("out.graphml")));
            writer.write(graphXML);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String export(List<Class<?>> classList) {
        GraphModel graphModel = new GraphModel();
        graphModel.fetchEntities(classList);
        graphModel.fetchEdges();
        return graphModel.toString();
    }
}
