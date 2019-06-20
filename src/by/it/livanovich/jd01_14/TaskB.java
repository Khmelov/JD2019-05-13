package by.it.livanovich.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        try (BufferedReader soi = new BufferedReader(new FileReader(dir(TaskB.class) + "text.txt"));
            PrintWriter out=new PrintWriter (new FileWriter(dir(TaskA.class)+"resultTaskB.txt"))) {
            String line;
            int countword = 0;
            int countpunct=0;
            while ((line = soi.readLine()) != null) {
                Pattern pattern=Pattern.compile("[-,.!:]");
                Matcher matcher=pattern.matcher(line.replaceAll("\\.{3}","."));
                while (matcher.find()) {
                    countpunct++;
                }
                String[] word = line.replaceAll("- ","").split("\\s");
                countword += word.length;
            }
            System.out.printf("words=%d",countword);
            System.out.printf("\npunctuation marks=%d",countpunct);
            out.printf("words=%d",countword);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }
}
