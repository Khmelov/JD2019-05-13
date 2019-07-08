package by.it.yakovets.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

class Logger {
    private static Logger logger;

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(Exception e) {

        String path = getPath(Logger.class, "log.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(path, true))) {
            out.println();
            out.println(e + " " + new Date().toString());

        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }


    private static String getPath(Class<?> aClass, String filename) {
        return getPath(aClass) + filename;
    }

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
