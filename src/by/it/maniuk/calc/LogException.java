package by.it.maniuk.calc;

import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

class LogException {

     LogException(Exception e)  {

        String path = getFilePath(LogException.class, "log.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(path,true))) {
            out.print(e + " - " +  new Date().toString());
            out.println();
            printerror(e.getMessage());


        } catch (IOException ex) {
            ex.printStackTrace();
        }
     }

    private  String getFilePath(Class<LogException> aClass, String filename) {
        return getPath(aClass) + filename;
    }

    private  String getPath(Class<LogException> aClass) {
        String root = System.getProperty("user.dir");
        String name = LogException.class.getName();
        String simpleName = LogException.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);

        path = root + separator + "src" + separator + path;
        return path;
    }
    private void printerror(String mes){
        ResManager manager = ResManager.INSTANCE;
        System.out.println(manager.get(mes));

    }
}
