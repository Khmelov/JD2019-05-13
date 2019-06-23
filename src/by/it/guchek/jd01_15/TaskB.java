package by.it.guchek.jd01_15;

import java.io.File;

public class TaskB {
    //этот комментарий надо удалить
    // этот комментарий надо удалить
    /*бла бла бла
    бла бла
     */
    /*бла бла бла
    бла бла
     */
    /**
     * Это Джавадок
     * Это Джавадок
    */

    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

    static String fileName = getPath(TaskB.class)+"TaskB.java";
    public static void main(String[] args) {

        StringBuilder sb= new StringBuilder();
        


    }
}
