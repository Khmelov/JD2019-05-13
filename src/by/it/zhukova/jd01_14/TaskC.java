package by.it.zhukova.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {
    public static void main(String[] args) {
        String fileTxt = getFilePath(TaskC.class, "resultTaskC.txt");
        String pow= System.getProperty("user.dir");
        String separator = File.separator;
        String name = "zhukova";
        String path=pow+separator+"src"+separator+"by"+separator+"it"+separator+name;
        printAllFiles(path);
        printFile(fileTxt,path);
    }
    private static void printFile(String fileTxt,String path) {
        try (
                PrintWriter printWriter = new PrintWriter(new FileWriter(fileTxt,true))
        ){
            final File folder = new File(path);
            for (File file: folder.listFiles()){
                if (file.isDirectory()){
                    String dir =file.getName();
                    printWriter.printf("dir:%s\n",dir);
                    String path2= path+File.separator+dir;
                    printFile(fileTxt,path2);
                } else {
                    printWriter.printf("file:%s\n",file.getName());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printAllFiles(String path) {
        final File folder = new File(path);
        for (File file: folder.listFiles()){
            if (file.isDirectory()){
                String dir =file.getName();
                System.out.printf("dir:%s\n",dir);
                String path2= path+File.separator+dir;
                printAllFiles(path2);
            } else {
                System.out.printf("file:%s\n",file.getName());
            }
        }
    }
    private static String getFilePath(Class<?> cClass, String filename) {
        String path = getPath(cClass);
        return path +filename;
    }

    private static String getPath(Class<?> cClass) {
        String src= System.getProperty("user.dir");
        String name = cClass.getName();
        String simpleName = cClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName,"").replace(".",separator);
        path=src+separator+"src"+separator+path;
        return path;
    }
}
