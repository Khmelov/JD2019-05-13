package by.it.guchek.jd01_15;

import java.io.File;

public class TaskC {

    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }


}
