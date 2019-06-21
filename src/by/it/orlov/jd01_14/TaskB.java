package by.it.orlov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        String txt = getFilePath(TaskA.class,"text.txt");
        String txt2 = getFilePath(TaskA.class,"ResultTaskB.txt");

        try (BufferedReader in = new BufferedReader(new FileReader((txt)));
         PrintWriter writer = new PrintWriter(new FileWriter(txt2))
        ){
           String s;
           int lenght = 0;
            int lenghtM = 0;

            Pattern pattern = Pattern.compile("[!.,;:?\\-]+");

            while ((s = in.readLine() )!= null){
                Matcher matcher = pattern.matcher(s);
              String[] word =  s.split("[ -/,+.;]");
                for (String s1 : word) {
                   if (s1.length()>=1)
                    lenght++;
                    if (matcher.find()){
                        lenghtM++;
                    }
                }
            }
            writer.println("words="+lenght);
             writer.println("punctuation marks="+lenghtM);

            System.out.println("words="+lenght);
            System.out.println("punctuation marks="+lenghtM);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static String getFilePath(Class<?> aClass, String filename) {
        return  getPath(aClass) + filename;
    }

    private static  String getPath(Class<?> aClass){
        String root = System.getProperty("user.dir");
        String name = TaskB.class.getName();
        String simpleName = TaskB.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName,"").replace(".",separator);

        path = root+separator+"src"+separator+path;
        return path;
    }
}
