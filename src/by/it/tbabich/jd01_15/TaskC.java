package by.it.tbabich.jd01_15;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TaskC {

    private static File file;

    public static void main(String[] args) {
        String startPath = getPath(TaskC.class);
        file = new File(startPath);
        Scanner sc = new Scanner(System.in);
        boolean isRun = true;
        while (isRun){
            String line = sc.nextLine();
            if (line.equals("dir")) dir(file);
            else if (line.matches("cd [.]{2}")) initParentFile();
            else if (line.matches("cd [^.]*")) initFile(line);
            else if (line.equals("end")) isRun = false;
        }
    }

    private static void initParentFile(){
        file = file.getParentFile();
    }

    private static void initFile(String s) {
        s = s.replace("cd ", "");
        String separator = File.separator;
        file = new File(file.getPath() + separator + s);
    }

    private static void dir(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.printf("%s\n", file1.getName());
        }
    }

    private static String getPath(Class<TaskC> cClass) {
        String root = System.getProperty("user.dir");
        String simpleName = TaskC.class.getSimpleName();
        String name = TaskC.class.getName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
        return path = root + separator + "src" + separator + path;
    }

}
