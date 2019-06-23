package by.it.maniuk.jd01_15;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Scanner;

public class TaskC {


    public static void main(String[] args)  {
        File dir = new File("D:/JD2019-05-13/src/by/it/maniuk/");

        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("by/it/maniuk/jd01_15/");
        while (!( s = scanner.nextLine()).equals("end")){


            if (s.contains("cd")){
                pathFromFile(s);
            }
            if (s.contains("dir")){
                getContents(dir);
            }
        }
    }

    private static void pathFromFile(String s) {
       s = s.replaceAll("cd", "").trim();
        String txt = getFilePath(TaskC.class,s);
        File file = new File(txt);

        Path path = Paths.get(txt);
        System.out.print(" " +path.getFileName() + "" +file.getTotalSpace());

    }
    private static void getContents(File dir) {

        for (File item : Objects.requireNonNull(dir.listFiles())) {
            if (item.isDirectory()) {

                SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                System.out.printf("%-10s   <DIR>   %10d     %-10s\n", sdf.format(item.lastModified()),getFileDir(item), item.getName());

            } else {
                SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                System.out.printf("%-10s                     %-10s\n", sdf.format(item.lastModified()), item.getName());

            }

        }
    }
    private static int getFileDir(File item) {
        String[] list;
        list =item.list();
        return list.length;
    }
    
    private static String getFilePath(Class<TaskC> aClass, String filename) {
        return getPath(aClass) + filename;
    }

    private static String getPath(Class<TaskC> aClass) {
        String root = System.getProperty("user.dir");
        String name = TaskC.class.getName();
        String simpleName = TaskC.class.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);

        path = root + separator + "src" + separator + path;
        return path;
    }
}
