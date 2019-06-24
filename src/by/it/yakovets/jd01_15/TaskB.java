package by.it.yakovets.jd01_15;
import java.io.*;
//первый комментарий
//второй комментарий
/*третий
комментарий
 */
/*четвертый
комментарий
 */
/**
 * Пятый комментарий
 */
public class TaskB {
    public static void main(String[] args) throws IOException {
        String filename = getPath(TaskB.class, "TaskB.txt");
        String classname = getPath(TaskB.class) + TaskB.class.getSimpleName() + ".java";
        StringBuilder text = progReader(classname);
        commentsDelete(text);
        System.out.println(text);
        printProg(text, filename);


    }

    private static void commentsDelete(StringBuilder text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '/' && text.charAt(i + 1) == '/') {
                boolean stop = true;
                while (stop) {
                    text.deleteCharAt(i);
                    if (text.charAt(i) == '\n') {

                        stop = false;
                    }
                }
                i--;
            }

            if (text.charAt(i) == '/' && text.charAt(i + 1) == '*' && text.charAt(i + 2) == '*') {
                boolean stop = true;
                while (stop) {
                    text.deleteCharAt(i);
                    if (text.charAt(i) == '*' && text.charAt(i + 1) == '/') {
                        for (int j = 0; j < 3; j++) {
                            text.deleteCharAt(i);
                        }
                        stop = false;
                    }
                }
                i--;
            }
            if (text.charAt(i) == '/' && text.charAt(i + 1) == '*') {
                boolean stop = true;
                while (stop) {
                    text.deleteCharAt(i);
                    if (text.charAt(i) == '*' && text.charAt(i + 1) == '/') {
                        for (int j = 0; j < 3; j++) {
                            text.deleteCharAt(i);
                        }
                        stop = false;
                    }
                }
                i--;
            }

        }
    }

    private static StringBuilder progReader(String classname) throws IOException {
        StringBuilder progText = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(classname))) {
            int b;
            while ((b = in.read()) != -1) {


                progText.append((char) b);
            }
        }
        return progText;
    }

    private static void printProg(StringBuilder text, String filename) throws IOException {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(filename)
        )) {
            out.print(text);
        }
    }

    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

    private static String getPath(Class<?> aClass, String fileName) {
        return getPath(aClass) + fileName;
    }


}