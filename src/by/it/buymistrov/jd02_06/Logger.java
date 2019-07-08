package by.it.buymistrov.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class Logger {

    private static DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.getDefault());
    private static String filename = getPath() + "log.txt";

    private Logger() {
    }

    static void toLog(String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename, true))) {
            printWriter.println(message + " " + dateFormat.format(new Date()) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath() {
        String root = System.getProperty("user.dir");
        String name = Logger.class.getName();
        String simpleName = Logger.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }
}