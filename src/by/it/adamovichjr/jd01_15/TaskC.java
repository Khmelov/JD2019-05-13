package by.it.adamovichjr.jd01_15;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class TaskC {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line;

        while (!(line = sc.nextLine()).equals("end")) {

            switch (line) {
                case "cd":
                    printThisDir();
                    break;
                case "cd ..":
                    parentDir();
                    break;
                case "dir":
                    printDirData();
                    break;
                default:
                    enterNextDir(line);
            }
        }
    }

    private static File thisDir = new File(getFilePath());

    private static String getFilePath() {
        Class<TaskC> cls = TaskC.class;
        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = cls.getName().replace(cls.getSimpleName(), "").replace(".", sep);
        return srcPath + classPath;
    }

    private static void parentDir() {
        thisDir = new File(thisDir.getParent());
    }

    private static void printThisDir() {
        System.out.println(thisDir);
    }

    private static void enterNextDir(String line) {
        if (line.matches("cd[ ]+[^/:*?<>\"]+")) {
            String nextDir = line.substring(2).trim();

            File[] files = thisDir.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().equalsIgnoreCase(nextDir) && files[i].isDirectory())
                    thisDir = new File(thisDir + File.separator + files[i].getName());
                else if (i == files.length - 1)
                    System.out.println("Системе не удается найти указанный путь.");
            }
        } else {
            System.out.printf("\"%s\" не является внутренней или внешней командой, исполняемой программой или пакетным файлом\n", line);
        }
    }

    private static void printDirData() {

        System.out.printf("Содержимое папки %s", thisDir);

        String s = "<DIR>";
        int fileCount = 0;
        int dirCount = 0;
        long filesSize = 0;
        long freeSpace = thisDir.getFreeSpace();
        Date timeModified;

        File[] files = thisDir.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                timeModified = new Date(file.lastModified());
                System.out.printf("%1$td.%1$tm.%1$tY  %1$tR%2$9s%3$10s%4$s%n",
                        timeModified, s, " ", file.getName());
                dirCount++;
            } else {
                timeModified = new Date(file.lastModified());
                System.out.printf("%1$td.%1$tm.%1$tY  %1$tR%2$18d %3$s%n",
                        timeModified, file.length(), file.getName());
                fileCount++;
                filesSize += file.length();
            }
        }
        System.out.printf("%16d файлов %15d байт%n", fileCount, filesSize);
        System.out.printf("%16d папок  %15d байт свободно%n", dirCount, freeSpace);
    }

}
