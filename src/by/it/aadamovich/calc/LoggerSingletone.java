package by.it.aadamovich.calc;

import by.it.aadamovich.calc.names.Path;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum LoggerSingletone {

    LOGGER;

    private String filepath = getFilePath();
    private boolean appendLoggerData = false;

    LoggerSingletone() {
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
            pw.println(ResourceManager.INSTANCE.getDate());
            pw.flush();
            if (!appendLoggerData) appendLoggerData = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getFilePath() {

        Class<LoggerSingletone> cls = LoggerSingletone.class;
        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = cls.getName().replace(cls.getSimpleName(), "").replace(".", sep);
        return srcPath + classPath + Path.PATH_FOR_LOGS;
    }


}
