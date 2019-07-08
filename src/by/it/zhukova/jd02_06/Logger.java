package by.it.zhukova.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Logger {

    private static volatile Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        Logger localInstance = instance;
        if (localInstance == null) {
            synchronized (Logger.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Logger();
                }
            }
        }
        return localInstance;
    }

    public static void printException(String exp) {
        String fileTxt = getFilePath(Logger.class, "log.txt");
        printFile(fileTxt,exp);
    }

    private static void printFile(String fileTxt,String exp) {
        try (
                PrintWriter printWriter = new PrintWriter(new FileWriter(fileTxt,true))
        ){
            LocalDateTime ldt = LocalDateTime.now();
            ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("Europe/Minsk"));
            printWriter.printf(zdt.toString()+"\n").printf(exp+"\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFilePath(Class<?> aClass, String filename) {
        String path = getPath(aClass);
        return path +filename;
    }

    private static String getPath(Class<?> aClass) {
        String src= System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName,"").replace(".",separator);
        path=src+separator+"src"+separator+path;
        return path;
    }
}
