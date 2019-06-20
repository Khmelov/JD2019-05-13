package by.it.izaykoff.jd01_14;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class TaskC {
    public static void main(String[] args) {

//        String root = System.getProperty("user.dir");
//        String name = TaskC.class.getName();
//        String simpleName = TaskC.class.getCanonicalName();
//        System.out.println(name);




        String fileN = getPath(TaskC.class);
        System.out.println(fileN);
//        System.out.println(fileN);
//        printFnames(fileN);

    }
//    public static void printFnames(String sDir) {
//        try {
//            Files.find(Paths.get(sDir), 999, (p, bfa) -> bfa.isRegularFile()).forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    private static String getPath(Class<TaskC> cClass) {
        String root = System.getProperty("user.dir");
        String name = cClass.getName();
        String simpleName = cClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace("jd01_14.TaskC","").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

}
