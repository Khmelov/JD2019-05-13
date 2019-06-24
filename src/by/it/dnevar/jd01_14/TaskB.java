package by.it.dnevar.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        String fileText = getFilePath(TaskB.class,"text.txt");
        String fileResultTxt = getFilePath(TaskB.class,"resultTaskB.txt");
        StringBuilder text = new StringBuilder();

        readTxt(fileText, text);
        int wordsNum = findCountWords(text);
        int marksNum = findCountMarks(text);
        printConsole(wordsNum, marksNum);
        printFileTxt(fileResultTxt, wordsNum, marksNum);

    }

    private static void printFileTxt(String fileResultTxt, int wordsNum, int commaNum) {
        try(PrintWriter out = new PrintWriter(new FileWriter(fileResultTxt))){
            out.printf("words=%d, punctuation marks=%d",wordsNum, commaNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printConsole(int wordsNum, int commaNum) {
        System.out.printf("words=%d, punctuation marks=%d",wordsNum, commaNum);
    }

    private static int findCountMarks(StringBuilder text) {
        Pattern marks = Pattern.compile("[^а-яёА-ЯЁ \\n]+");
        Matcher wordMatcher = marks.matcher(text);
        int marksNum =0;
        while(wordMatcher.find()){
            marksNum++;
        }
        return marksNum;
    }

    private static int findCountWords(StringBuilder text) {
        Pattern word = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher wordMatcher = word.matcher(text);
        int wordsNum =0;
        while(wordMatcher.find()){
            wordsNum++;
        }
        return wordsNum;
    }

    private static void readTxt(String fileText, StringBuilder text) {
        try(FileReader fr = new FileReader(new File(fileText))){
            while(fr.ready()){
                text.append((char)fr.read());
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
