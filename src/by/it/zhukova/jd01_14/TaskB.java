package by.it.zhukova.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        String fileData = getFilePath(TaskB.class, "text.txt");
        String fileTxt = getFilePath(TaskB.class, "resultTaskB.txt");
        StringBuilder text = new StringBuilder();
        readData(fileData, text);
        int countWords = getCountWords(text);
        int countSign = getCountSign(text);
        printConsole(countWords, countSign);
        printFile(fileTxt,countWords,countSign);
    }

    private static void printConsole(int countWords, int countSign) {
        System.out.printf("words=%d, punctuation marks=%d",countWords,countSign);
    }

    private static int getCountWords (StringBuilder text) {
        int count = 0;
        Pattern p2 = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m2 = p2.matcher(text);
        while (m2.find()){
            count ++;
        }
        return count;
    }
    private static int getCountSign (StringBuilder text) {
        int count = 0;
        Pattern p2 = Pattern.compile("\\p{Punct}+");
        Matcher m2 = p2.matcher(text);
        while (m2.find()){
            count ++;
        }
        return count;
    }

    private static void printFile(String fileTxt,int countWords, int countSign) {
        try (
                PrintWriter printWriter = new PrintWriter(new FileWriter(fileTxt))
        ){ printWriter.printf("words=%d, punctuation marks=%d",countWords,countSign);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readData(String fileData, StringBuilder text) {
        try (
            BufferedReader buf = new BufferedReader(new FileReader(fileData))
        ) {
            for ( ; ; ){
                String s = buf.readLine();
                if (s==null) break;
                text.append(s).append(" ");
            }
           }
        catch (IOException e) {
            e.printStackTrace();
        }
     }

    private static String getFilePath(Class<?> bClass, String filename) {
        String path = getPath(bClass);
        return path +filename;
    }

    private static String getPath(Class<?> bClass) {
        String src= System.getProperty("user.dir");
        String name = bClass.getName();
        String simpleName = bClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName,"").replace(".",separator);
        path=src+separator+"src"+separator+path;
        return path;
    }
}
