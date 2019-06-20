package by.it.yakovets.jd01_14;

import java.io.File;

public class TaskA {
    public static void main(String[] args) {
        Class<TaskA> aClass = TaskA.class;
        String path=getPath();


    }

    private static String getPath() {
        String root = System.getProperty("user.dir");
        String name = TaskA.class.getName();
        String simpleName = TaskA.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        System.out.println(path);
        return path;
    }
}
