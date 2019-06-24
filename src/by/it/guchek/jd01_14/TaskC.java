package by.it.guchek.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {

    private static String fileInResult = dir((TaskC.class))+"resultTaskC.txt";
    private static File fileResult = new File(fileInResult);
    private static String filePuth = dir(TaskC.class);
    private static String dir (Class<?> cl){

        String path=System.getProperty("user.dir")+File.separator+"src"+File.separator;
        String classDir =cl.getName().replace(cl.getSimpleName(), "").replace(".",File.separator);
        return path+classDir;
    }

    private static void printInResult() {
        try (
                PrintWriter printWriter = new PrintWriter(
                        new FileWriter(fileResult))
        ) {
            try {
                File fileDir = new File(filePuth).getParentFile();
                File[] files2 = fileDir.listFiles();
                for (File file1 : files2) {

                    File[] filesFull2 = file1.listFiles();
                    if (file1.isDirectory()) {
                        printWriter.printf("%s:%s\n", "dir", file1.getName());

                    } else
                        System.out.printf("%s:%s\n", "file", file1.getName());
                    for (File lowFile : filesFull2) {

                        if (lowFile.isFile()) {
                            printWriter.printf("%s:%s\n", "file", lowFile.getName());

                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        public static void main(String[] args) {


        try {File fileDir = new File(filePuth).getParentFile();
            File[] files = fileDir.listFiles();

            for (File file1 : files) {

                File [] filesFull = file1.listFiles();
                if (file1.isDirectory())
                    System.out.printf("%s:%s\n","dir",file1.getName());

                else
                    System.out.printf("%s:%s\n","file",file1.getName());
                for (File lowFile : filesFull) {
                    if (lowFile.isFile())
                        System.out.printf("%s:%s\n","file",lowFile.getName());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();

        }

        printInResult();


    }
}
