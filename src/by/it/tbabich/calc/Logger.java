package by.it.tbabich.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

class Logger {

    private static Logger instance;
    private static String fileName;
    private static ZonedDateTime zonedDateTime;
    private static DateTimeFormatter formatter;
    private static FileWriter fileWriter;
    private static File logFile;



    private Logger() {
        fileName = getFilePath(Logger.class, "log.txt");
        logFile = new File(fileName);
        try {
            fileWriter = new FileWriter(logFile, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss", Locale.ENGLISH);
        zonedDateTime = ZonedDateTime.now();

    }

    public static Logger getInstance(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void writeLog(String message){
        try {
            String line = String.format("%s : %s\n", zonedDateTime.format(formatter), message);
            System.out.println(line);
            fileWriter.write(line);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeLogger(){
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getPath() {
        String root = System.getProperty("user.dir");
        String simpleName = Logger.class.getSimpleName();
        String name = Logger.class.getName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        return path = root + separator + "src" + separator + path;
    }

    private static String getFilePath(Class<Logger> loggerClass, String fileName) {
        return getPath() + fileName;
    }
}
