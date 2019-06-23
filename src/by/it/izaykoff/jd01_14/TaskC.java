package by.it.izaykoff.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {

    public static StringBuilder strBuild = new StringBuilder();

    public static void main(String[] args) {

        String fileResult = getPath(TaskC.class, "resultTaskC.txt");
        File file = new File(System.getProperty("user.dir")
                + File.separator
                + "src"
                + File.separator
                + "by"
                + File.separator
                + "it"
                + File.separator
                + "izaykoff");

        printFilesToConsole(file);
        printWriteFile(fileResult, strBuild);
    }

    private static void printWriteFile(String fileResult, StringBuilder strBuild) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileResult))) {
            out.write(String.valueOf(strBuild));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFilesToConsole(File file) {
        File[] arrFiles = file.listFiles();
        for (int i = 0; i < arrFiles.length; i++) {
            if (arrFiles[i].isDirectory() && !arrFiles[i].isHidden()){
                String s = arrFiles[i].getName();
                strBuild.append("dir:").append(s).append("\n");
                System.out.printf("dir:%s\n",arrFiles[i].getName());
                printFilesToConsole(arrFiles[i]);

            } else if (arrFiles[i].isFile() && !arrFiles[i].isHidden()){
                String s = arrFiles[i].getName();
                strBuild.append("file:").append(s).append("\n");
                System.out.printf("file:%s\n",arrFiles[i].getName());
            }
        }
    }

    private static String getPath(Class<?> cClass, String filename) {
        return getPath(cClass) + filename;
    }

    private static String getPath(Class<?> cClass) {
        String root = System.getProperty("user.dir");
        String name = cClass.getName();
        String simpleName = cClass.getSimpleName();
        String separator = File.separator;
        String path = name.replace(simpleName, "").replace(".", separator);
//        String path = name.replace("jd01_14.TaskC","").replace(".", separator);
        path = root + separator + "src" + separator + path;
        return path;
    }

}
