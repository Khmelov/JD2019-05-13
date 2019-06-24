package by.it.aadamovich.jd01_15;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class TaskC {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line;
        boolean end = false;

        while (!end) {
            System.out.printf("%s>", currentDir); // Как поставить указатель для ввода с консоли
            switch (line = sc.nextLine()) {       //в конце строки?
                case "cd":
                    showCurrent();
                    break;
                case "cd ..":
                    moveParentDir();
                    break;
                case "dir":
                    printDirInfo();
                    break;
                case "end":
                    end = true;
                    break;
                default:
                    moveChildDir(line);
            }
        }
    }

    private static void showCurrent() {
        System.out.println(currentDir);
    }

    private static void moveParentDir() {
        currentDir = new File(currentDir.getParent());
    }

    private static void moveChildDir(String line) {
        if (line.matches("cd[ ]+[^/:*?<>\"]+")) {
            String dir = line.substring(2).trim();

            File[] files = currentDir.listFiles();
            assert files != null;
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().equalsIgnoreCase(dir) && files[i].isDirectory())
                    currentDir = new File(currentDir + File.separator + files[i].getName());
                else if (i == files.length - 1)
                    System.out.println("Системе не удается найти указанный путь.");
            }
        } else {
            System.out.printf("\"%s\" не является внутренней или внешней " +
                    "\nкомандой, исполняемой программой или пакетным файлом\n", line);
        }
    }

    private static void printDirInfo() {

        System.out.printf("Содержимое папки %s%n%n", currentDir);

        String s = "<DIR>";
        int fileCount = 0;
        int dirCount = 0;
        long filesSize = 0;
        long freeSpace = currentDir.getFreeSpace();
        Date timeModified;

        File[] files = currentDir.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                timeModified = new Date(file.lastModified());
                System.out.printf("%1$td.%1$tm.%1$tY  %1$tR%2$9s%3$10s%4$s%n",
                        timeModified, s, " ", file.getName());
                dirCount++;
            } else {
                timeModified = new Date(file.lastModified());
                System.out.printf("%1$td.%1$tm.%1$tY  %1$tR%2$,18d %3$s%n",
                        timeModified, file.length(), file.getName());
                fileCount++;
                filesSize += file.length();
            }
        }
        System.out.printf("%16d файлов %,15d байт%n", fileCount, filesSize);
        System.out.printf("%16d папок  %,15d байт свободно%n", dirCount, freeSpace);
    }

    private static File currentDir = new File(getFilePath());

    private static String getFilePath() {
        Class<TaskC> cls = TaskC.class;
        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = cls.getName().replace(cls.getSimpleName(), "").replace(".", sep);
        return srcPath + classPath;
    }
}