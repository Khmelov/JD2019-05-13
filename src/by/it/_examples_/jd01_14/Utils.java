package by.it._examples_.jd01_14;

import by.it.zhukova.jd01_14.TaskA;

/**
 * Created by Alex on 05.06.2016.
 */
public class Utils {
    public static String getFilePath(String name) {
        String src = System.getProperty("user.dir") + "/src/by/it/_examples_/jd01_14/";
        return src + name;
    }
}
