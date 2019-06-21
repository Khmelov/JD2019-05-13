package by.it.dnevar.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {

    private static String fileResultTxt = getFilePath(TaskC.class,"resultTaskC.txt");

    public static void main(String[] args) {

        File file = new File(System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"by"+ File.separator+"it"+ File.separator+"dnevar");

        printFilesConsole(file);
        printFilesTxt(file);
    }

    private static void printFilesTxt(File file) {
        try(PrintWriter out = new PrintWriter(new FileWriter(fileResultTxt))){
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if(files[i].isDirectory()&& !files[i].isHidden()){
                    out.printf("dir:%s\n",files[i].getName());
                    printFilesTxt(files[i]);
                }else if(files[i].isFile() && !files[i].isHidden()) {
                    out.printf("file:%s\n", files[i].getName());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFilesConsole(File file) {
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(files[i].isDirectory() && !files[i].isHidden()){
                System.out.printf("dir:%s\n",files[i].getName());
                printFilesConsole(files[i]);
            }else if(files[i].isFile() && !files[i].isHidden()){
                System.out.printf("file:%s\n",files[i].getName());
            }

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
