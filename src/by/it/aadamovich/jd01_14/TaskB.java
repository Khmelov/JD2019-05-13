package by.it.aadamovich.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) {
        String taskText = getFilePath("text.txt");
        String fileResult = getFilePath("resultTaskB.txt");
        readTextWriteResult(taskText, fileResult);
    }

    private static void readTextWriteResult(String task, String result) {
        try (BufferedReader br = new BufferedReader
                (new FileReader(task));
             PrintWriter pw = new PrintWriter(new FileWriter(result))
        ) {
            String line;
            int words = 0;
            int marks = 0;
            Pattern p = Pattern.compile("(((?<=\\s)-|[.,!?;:]+)|[а-яА-ЯёЁ]+)");
            Matcher m;

            while ((line = br.readLine()) != null) {
                m = p.matcher(line);
                while (m.find()) {
                    if (m.group().matches("[а-яА-ЯёЁ]+")) words++;
                    else marks++;
                }
            }
            System.out.printf("words=%d, punctuation marks=%d", words, marks);
            pw.printf("words=%d, punctuation marks=%d", words, marks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Class<TaskA> cls = TaskA.class;

    private static String getFilePath(String filename) {
        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = cls.getName().replace(cls.getSimpleName(), "").replace(".", sep);
        return srcPath + classPath + filename;
    }
}
