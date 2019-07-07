package by.it.yakimovich.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

class Logger {

    private String filename;
    private static Logger logger;
    private DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);

    private Logger () {
        filename = getFilePath("log.txt");
    }

    static Logger loggingError(){
        if (logger==null){
            logger = new Logger();

        }
        return logger;
    }

    void toLog (String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename,true)))
        {
            printWriter.println(message + " " +  dateFormat.format(new Date())+ "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFilePath(String filename) {
        return  getPath() + filename;
    }

    private static  String getPath(){
        String root = System.getProperty("user.dir");
        String name = Logger.class.getName();
        String simpleName = Logger.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName,"").replace(".",separator);

        path = root+separator+"src"+separator+path;
        return path;
    }
}
