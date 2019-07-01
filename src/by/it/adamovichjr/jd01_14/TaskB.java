package by.it.adamovichjr.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static String getFilePath (Class<?> clas, String fileName){
        String sep = File.separator;
        String path = System.getProperty("user.dir") + sep + "src" + sep;
        return path + clas.getName().replace(clas.getSimpleName(), "").replace(".", sep) + fileName;
    }

    public static void main(String[] args) {
        String pathTask = getFilePath(TaskB.class,"text.txt");
        String resultPath = getFilePath(TaskB.class,"resultTaskB.txt");
        readTextAndcount(pathTask,resultPath);

    }
    private static void readTextAndcount(String filePathRead,String filePathResult){
        try(BufferedReader br = new BufferedReader(
                new FileReader(filePathRead));
            PrintWriter pw = new PrintWriter(new FileWriter(filePathResult))
        ) {
            String line;
            int words =0;
            int marks = 0;
            Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+|[.,!?:-]+");
            Matcher m;

            while ((line = br.readLine()) != null){
                m = pattern.matcher(line);
                while (m.find()){
                    if (m.group().matches("[а-яА-ЯёЁ]+")) words++;
                    else marks++;
                }
            }
            System.out.printf("words=%d, marks=%d", words, marks);
            pw.printf("words=%d, marks=%d", words, marks);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
