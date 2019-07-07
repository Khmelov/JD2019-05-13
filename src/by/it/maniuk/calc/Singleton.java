package by.it.maniuk.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Singleton {
    private static Singleton instance;
    private Date date = new Date();
    private SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss");
    private Singleton(){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    void printErrorToLog(Exception e){
        String path = getFilePath( Singleton.class, "log.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(path,true))) {
            String mess = printerror(e.getMessage());
            out.print(e +" - " + mess +" - " + ResManager.INSTANCE.getTime(date)+ " " + sdf.format(date));
            out.println();

    } catch (IOException ex) {
           printErrorToLog(ex);
        }

    }
    public void printMessageToLog(String e) {
        String path = getFilePath(Singleton.class, "log.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(path, true))) {
            System.out.println(e);
            out.print(e +" - "+   ResManager.INSTANCE.getTime(date)+ " " + sdf.format(date));
            out.println();

        } catch (IOException ex) {
            printErrorToLog(ex);

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
    private String printerror(String mes){
        ResManager manager = ResManager.INSTANCE;
        mes = manager.get(mes);
        System.out.println(mes);
        return mes;
    }
    String returnError(Exception e){
        String mess =e.getMessage();
        ResManager manager = ResManager.INSTANCE;
        mess = manager.get(mess);
        return (e +" - " + mess +" - " + ResManager.INSTANCE.getTime(date)+ " " + sdf.format(date));

    }
}
