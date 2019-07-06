package by.it.aadamovich.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;

public enum Singleton {

    LOGGER;

    private String filepath = getFilePath("log.txt", Singleton.class);
    private DateFormat df;

    Singleton() {
        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
    }

    void writeLog(String message, boolean append) {
        try (PrintWriter pw = new PrintWriter
                (new FileWriter(filepath, append))
        ) {
            pw.write(message);
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeLog(Throwable error, boolean append, int i) {
        try (PrintWriter pw = new PrintWriter
                (new FileWriter(filepath, append))
        ) {
            pw.format("Операция %d невозможна, произошла ошибка:%n%s%n", i, error.toString());
            StackTraceElement[] stackTrace = error.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                pw.println(element.toString());
            }
            Date date = Date.from(Instant.now());
            pw.printf("%s %tT%n", df.format(date), date);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFilePath(String filename, Class<?> cls) {

        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = cls.getName().replace(cls.getSimpleName(), "").replace(".", sep);
        return srcPath + classPath + filename;
    }
}
