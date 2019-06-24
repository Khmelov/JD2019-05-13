package by.it.yakimovich.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) {
        String inpT= getFilePath("text.txt");
        String outT=getFilePath("ResultTaskB.txt");
        countLettersMarks(inpT, outT);

    }

    private static void countLettersMarks(String inpT, String outT) {
        try (BufferedReader in = new BufferedReader(new FileReader((inpT)));
             PrintWriter writer = new PrintWriter(new FileWriter(outT))
        ){
            String s;
            int amountLetters = 0;
            int amountMarks = 0;
            Pattern pattern = Pattern.compile("[-!.,;:?]+");

            while ((s = in.readLine() )!= null){
                Matcher matcher = pattern.matcher(s);
                String[] letters =  s.split("[ -/,+.;]");
                for (String s1 : letters) {
                    if (s1.length()>0)
                        amountLetters++;
                    if (matcher.find()){
                        amountMarks++;
                    }
                }
            }
            System.out.println("words="+amountLetters);
            writer.println("words="+amountLetters);
            System.out.println("punctuation marks="+amountMarks);
            writer.println("punctuation marks="+amountMarks);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getFilePath(String filename) {
        return  getPath() + filename;
    }

    private static  String getPath(){
        String root = System.getProperty("user.dir");
        String name = TaskB.class.getName();
        String simpleName = TaskB.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName,"").replace(".",separator);

        path = root+separator+"src"+separator+path;
        return path;
    }
}