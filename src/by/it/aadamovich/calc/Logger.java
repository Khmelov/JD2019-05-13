package by.it.aadamovich.calc;

import by.it.aadamovich.calc.names.Path;
import by.it.aadamovich.calc.names.Patterns;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;

public enum Logger {

    LOGGER;

    private String filepath = getFilePath();
    private DateFormat df;
    private boolean appendLoggerData = false;

    Logger() {
    }

    void writeLog(String message) {
        try (PrintWriter pw = new PrintWriter
                (new FileWriter(filepath, appendLoggerData))
        ) {
            pw.println(message);
            pw.flush();
            if (!appendLoggerData) appendLoggerData = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeLog(Throwable error) {
        try (PrintWriter pw = new PrintWriter
                (new FileWriter(filepath, appendLoggerData))
        ) {
            pw.println(error.getMessage());
            StackTraceElement[] stackTrace = error.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                pw.println(element.toString());
            }
            Date date = Date.from(Instant.now());
            df = DateFormat.getDateInstance
                    (DateFormat.LONG, ResourceManager.INSTANCE.getLocale());
            pw.printf("%s %tT%n", df.format(date), date);
            pw.flush();
            if (!appendLoggerData) appendLoggerData = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getFilePath() {

        Class<Logger> cls = Logger.class;
        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = cls.getName().replace(cls.getSimpleName(), "").replace(".", sep);
        return srcPath + classPath + Path.DIR_FOR_LOGS + sep + Path.FILE_FOR_LOGS;
    }
}
