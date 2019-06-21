package by.it.izaykoff.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {

        String fileText = getFilePath(TaskB.class, "text.txt");
        String fileResult = getFilePath(TaskB.class, "resultTaskB.txt");
        StringBuilder strBuild = new StringBuilder();

        textRide(fileText, strBuild);

        String mark = "[-.,:!]+";
        String word = "[а-яА-ЯёЁ]+";

        System.out.printf("words=%d", searchWord(strBuild, word));
        System.out.printf("\npunctuation marks=%d\n", searchWord(strBuild, mark));
        System.out.println(strBuild);

        printWrite(fileResult, strBuild);
    }

    private static void printWrite(String fileResult, StringBuilder strBuild) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileResult))) {
            out.write(String.valueOf(strBuild));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int searchWord(StringBuilder strBuild, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(strBuild);
        int countWord = 0;
        while (matcher.find()){
            countWord++;
        }
        return countWord;
    }

    private static void textRide(String fileText, StringBuilder strBuild) {
        try ( BufferedReader bur = new BufferedReader(new FileReader(fileText))){
            String s;
            while ((s=bur.readLine()) != null){
                strBuild.append(s).append(" ");
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
