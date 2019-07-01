package by.it.tbabich.jd01_15;

import java.io.*;

public class TaskB {

    private static BufferedReader br;
    private static PrintWriter pw;

    /*
    Метод main
     */
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new FileReader(new File(getFilePath(TaskB.class, "TaskB.java"))));
            pw = new PrintWriter(new FileWriter(new File(getFilePath(TaskB.class, "TaskB.txt"))));

            StringBuilder sb = new StringBuilder();
            while (br.ready()){
                sb.append(br.readLine()).append("\n");
            }
            boolean isStartManyComment = false;
            boolean isStopManyComment = false;
            boolean isStopWrite = false;
            char[] chars = sb.toString().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if ((i != chars.length - 1) && (chars[i] == '/' && chars[i + 1] == '/')){
                    isStopWrite = true;
                }
                else if ((i != chars.length - 1) && (chars[i] == '/' && chars[i + 1] == '*')) {
                    isStartManyComment = true;
                } else if (chars[i] == '\n'){
                isStopWrite = false;} else if ((i != chars.length - 1) && (chars[i] == '*' && chars[i + 1] == '/')){
                    isStopManyComment = true;
                }
                if (chars[i] == '/' && chars[i - 1] == '*') continue;
                if (!isStopWrite && !isStartManyComment) {
                    pw.print(chars[i]);
                }
                if (isStartManyComment && isStopManyComment){
                    isStartManyComment = false;
                    isStopManyComment = true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Получить путь к классу
    private static String getPath(Class<TaskB> bClass) {
        String root = System.getProperty("user.dir");
        String simpleName = TaskB.class.getSimpleName();
        String name = TaskB.class.getName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        return path = root + separator + "src" + separator + path;
    }

    private static String getFilePath(Class<TaskB> bClass, String fileName) {
        return getPath(bClass) + fileName;
    }
}
