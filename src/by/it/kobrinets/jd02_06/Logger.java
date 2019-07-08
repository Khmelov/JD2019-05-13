package by.it.kobrinets.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

class Logger {
    private String filename;
    private static Logger instance;
    private DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);

    private Logger () {
        filename = getPath("log.txt");
    }

    static Logger getLogger(){
        if (instance == null){
            synchronized (Logger.class) {
                if (instance == null)
                    instance = new Logger();
            }
        }
        return instance;
    }

    void toLog (String message) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename,true)))
        {
            printWriter.println(dateFormat.format(new Date()) + " " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String getPath(String filename) {
        return getPath()+filename;
    }

    private static String getPath() {
        String path = System.getProperty("user.dir");
        path+= File.separator + "src" + File.separator;
        path+= Logger.class
                .getName()
                .replace(Logger.class.getSimpleName(),"")
                .replace(".", File.separator);
        return path;
    }
}
