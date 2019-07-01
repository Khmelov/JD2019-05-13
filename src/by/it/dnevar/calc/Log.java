package by.it.dnevar.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Log {

    static List<String> logs = new ArrayList<>();

    private static String logsTxt = getFilePath(Var.class,"logs.txt");

    static void setLog(String message){
        logs.add(message);
    }

    static void logsToTxt(){
        try(PrintWriter out = new PrintWriter(new FileWriter(logsTxt))){
            if(logs.size()==0){
                out.println("Нет операций");
            }else if(logs.size()>50){
                logs=logs.subList(logs.size()-50,logs.size());
            }
            Iterator<String> iterator = logs.iterator();
            while(iterator.hasNext()){
                out.println(iterator.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath (Class<?> aClass){
        String root = System.getProperty("user.dir")
                + File.separator
                +"src"
                +File.separator;
        String name = aClass.getName()
                .replace(aClass.getSimpleName(),"")
                .replace(".", File.separator);
        return root+name;
    }

    private static String getFilePath(Class<?> aClass, String filename){
        return getPath(aClass)+filename;
    }

}
