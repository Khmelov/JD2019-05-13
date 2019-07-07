package by.it.adamovichjr.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public enum  SingeltonLogger {
    LOGGER;
    private String filepath = getFilePath();
    private boolean clearLogfile = false;
    SingeltonLogger(){}

    void writeLogInFile(String expression) {
        try(PrintWriter pw = new PrintWriter(new FileWriter(filepath, clearLogfile))) {
            pw.println(expression);
            pw.flush();
            if(!clearLogfile){
                clearLogfile = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void writeLogInFile (Throwable e) {
        try(PrintWriter pw = new PrintWriter(new FileWriter(filepath, clearLogfile))) {
            pw.println(e.getMessage());
            for (StackTraceElement element : e.getStackTrace()) {
                pw.println(element.toString());
            }
            pw.println(ResourceManager.INSTANCE.getTime());
            pw.flush();
            if(!clearLogfile){
                clearLogfile = true;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private static String getFilePath() {
        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = SingeltonLogger.class.getName().replace(SingeltonLogger.class.getSimpleName(), "").replace(".", sep);
        return srcPath + classPath + "log.txt";
    }
}
