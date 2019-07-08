package by.it.maniuk.jd02_06;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void printToLog(String e){
        String path = getFilePath( Singleton.class, "log.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(path,true))) {
            out.print(e + " - " +  new Date().toString());
            out.println();

    } catch (IOException ex) {
           printToLog(ex.getMessage());
        }

    }
    private  String getFilePath(Class<Singleton> aClass, String filename) {
        return getPath(aClass) + filename;}

    private  String getPath(Class<Singleton> aClass) {
        String root = System.getProperty("user.dir");
        String name = Singleton.class.getName();
        String simpleName = Singleton.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);

        path = root + separator + "src" + separator + path;
        return path;
    }
}
