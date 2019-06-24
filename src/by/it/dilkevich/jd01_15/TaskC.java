package by.it.dilkevich.jd01_15;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        String pathToMainDir = System.getProperty("user.dir") + "\\" + "src" + "\\" + TaskC.class.getName().replaceAll("\\.", "\\\\").replaceAll("\\\\TaskC", "");

        File file = new File(pathToMainDir);
        Scanner scanner = new Scanner(System.in);
        String word;
        String currentDir = pathToMainDir;

        do {
            if(file.isDirectory())
            System.out.print(currentDir + " ");
            else
                System.out.println(currentDir + ".java" + " ");
            word = scanner.nextLine();

            if (word.equals("cd ..")){

                currentDir = file.getParent();
                File tempFile  = new File(currentDir);
                file = tempFile;
            }

            if(word.equals("dir")){

                String[] list = file.list();

                if(list != null) {

                    for (String element : list) {

                        System.out.println(element);
                    }
                }
                else {
                    Path path = Paths.get(currentDir);
                    System.out.println(path.getFileName() + ".java");

                }
            }

            if (word.matches("cd [A-Za-z_].+")){

                if(word.contains("\\.")){

                    String [] s = word.split(".");
                    word = s[0];
                }
                word = word.replace("cd ", "");
                String[] catalogues = file.list();

                for (String catalogue : catalogues) {
                    catalogue = catalogue.replaceAll("\\.java", "").replaceAll("\\.txt", "");

                    if (catalogue.equals(word)){

                        currentDir = currentDir + "\\" + word;
                        File tempFile  = new File(currentDir);
                        file = tempFile;
                    }
                }
            }
        }
        while (!word.equals("end"));




    }
}
