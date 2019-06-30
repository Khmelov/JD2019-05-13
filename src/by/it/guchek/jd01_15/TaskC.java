package by.it.guchek.jd01_15;

import java.io.File;
import java.util.Scanner;

public class TaskC {

    private static File file = new File(getPath(TaskC.class));

    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir");
        String name = aClass.getName();
        String simpleName = aClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        System.out.print(file.getAbsolutePath() + ">");

        while (!(line = sc.nextLine()).equals("end")) {
            if (line.contains("cd")) {

                String[] commandLines = line.trim().split(" ");
                if (commandLines[0].equals("cd..")) {
                    file = new File(file.getParent());
                    System.out.println(file.getAbsolutePath());
                } else {
                    StringBuilder sb = new StringBuilder(file.getAbsolutePath());
                    sb.append('/').append(commandLines[1]);
                    String files = sb.toString();
                    System.out.println(files);
                }
            }
            if (line.equals("dir")) {
                File[] files = file.listFiles();

                for (int i = 0; i < files.length; i++) {

                        System.out.printf("<DIR>  %17s", files[i].getName());
                        System.out.println();
                }
                System.out.println(file.getAbsolutePath() + ">");
            }
            //else System.out.println("Правильно вводите комманды");
        }

    }

}








