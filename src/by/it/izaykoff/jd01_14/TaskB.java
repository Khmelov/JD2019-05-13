package by.it.izaykoff.jd01_14;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class TaskB {
    public static void main(String[] args) {

        String fileText = getFilePath(TaskB.class, "text.txt");
        StringBuilder strBuild = new StringBuilder();


        //textRide
        textRide(fileText, strBuild);
        
        System.out.println(strBuild);


//        File file = new File(fileText);
//        FileReader fileReader = null;
//        try {
//            fileReader = new FileReader(file);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fileReader != null) {
//                    fileReader.close();
//                }
//            }catch(IOException e){
//                e.printStackTrace();
//            }
//        }


    }

    private static void textRide(String fileText, StringBuilder strBuild) {
        try ( BufferedReader bur = new BufferedReader(new FileReader(fileText))){
            while (bur.read() > 0){
                strBuild.append(bur.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getFilePath(Class<TaskB> bClass, String filename) {
        return getPath(bClass) + filename;
    }

    private static String getPath(Class<TaskB> bClass) {
        String root = System.getProperty("user.dir");
        String name = bClass.getName();
        String simpleName = bClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

}
