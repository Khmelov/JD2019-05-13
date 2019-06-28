
package by.it.maniuk.jd01_15;



import java.io.*;


public class TaskB {
    public static void main(String[] args) {
        String fileName = getFilePath(TaskB.class, "TaskB.java");
        readFile(fileName);
    }

    // eerferer
    // gfgfg
    private static void readFile(String file) {
        char buf[] = new char[file.length()];
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(new File(file)))) {
            int count = 0;
            for (int i = in.read(buf); i >= 0; i = in.read(buf)) {
                sb.append(buf, 0, i);
            }
//                if (sb.toString().contains("/**") || sb.toString().contains("/*")){
            boolean flag = false;
            int start = 0;
            int end = 0;
            //      String[] ar = sb.toString().split(" ");
            char[] array = sb.toString().toCharArray();
            for (int i = 0; i < array.length; i++) {
                if ((array[i] == '/') && (array[i + 1] == '/')) {
                    start = i;
                    flag = true;
                }
                if (array[i] == '\n' && flag) {
                    flag = false;
                    end = i;
                    sb.delete(start,end);
                    array = sb.toString().toCharArray();
                    i=0;
//                    for (int j = start; j < end; j++) {
//                        array[j] = ' ';
//                    }
                    // System.out.println(sb.toString());
                }
            }
            for (int i = 0; i < array.length; i++) {
                if ((array[i] == '/') && (array[i + 1] == '*')) {
                    start = i;
                    flag = true;
                }
                if (flag && (array[i] == '*') && (array[i + 1] == '/')) {
                    flag = false;
                    end = i;
                    for (int j = start; j < end; j++) {
                        array[j] = '\r';
                    }
                }
            }
            for (char c : array) {
                System.out.print(c);
            }
            printToWile(array);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static String getFilePath(Class<TaskB> aClass, String filename) {
        return getPath(aClass) + filename;
    }

    private static String getPath(Class<TaskB> aClass) {
        String root = System.getProperty("user.dir");
        String name = TaskB.class.getName();
        String simpleName = TaskB.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);

        path = root + separator + "src" + separator + path;
        return path;
    }

    private static void printToWile(char[] array) {
        String fileName = getFilePath(TaskB.class, "TaskB.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
                for (char e : array) {
                    out.print( e);
                }
                out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


