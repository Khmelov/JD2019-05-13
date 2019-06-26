package by.it.livanovich.jd01_15;

import java.io.File;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String startDir = TaskC.class.getName().replace(TaskC.class.getSimpleName(), "").replace(".", File.separator);
        String absolute = root + startDir;
        File file = new File(startDir);
        Scanner sc = new Scanner(System.in);
        String in;
        System.out.println(startDir);
        while (!(in = sc.nextLine()).equals("end")) {
            if (in.startsWith("cd")) {
                String nameDir = in.replace("cd", "").trim();
                startDir = file.getParent() + File.separator + nameDir;
                File check = new File(root + startDir);
                File check2=new File(file.getParent());
                File check3=new File(root+check2.getParent()+File.separator+nameDir);

                if (check.exists()){
                    absolute=root+startDir;
                    System.out.println(file.getParent() + File.separator + nameDir);}
                else if (check3.exists()){
                    absolute=check3.getPath();
                      System.out.println(check3);}
                else
                    System.out.println("no exists");
            } else if (in.equals("dir")) {
                System.out.println("Содержимое папки "+startDir+":");
                printDir(absolute);
            }
            else System.out.println("Incorrect command");
        }
    }

    static void printDir(String path) {
        File dir = new File(path);
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                System.out.print(sdf.format(file.lastModified()));
                System.out.printf("  %-10s", file.getName());
                System.out.println();
            }
            else if (file.isDirectory()){
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                System.out.print(sdf.format(file.lastModified()));
                System.out.printf(" <DIR> %-10s", file.getName());
                System.out.println();
                printDir(file.getPath());
            }
        }
        System.out.println(dir.list().length+" файлов");
    }
}
