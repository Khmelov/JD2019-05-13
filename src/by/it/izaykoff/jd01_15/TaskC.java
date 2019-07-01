package by.it.izaykoff.jd01_15;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.Consumer;

public class TaskC {
    private static File currentDir = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        setCurrentDir(null);
        System.out.println(getCurrentDir());

        Map<String, Consumer<String>> commands = new HashMap<String, Consumer<String>>() {
            {
                put("cd", TaskC::commnadCD);
                put("dir", TaskC::commnadDIR);
            }
        };

        String rawData;
        while (!"end".equals(rawData = scanner.nextLine())) {
            rawData = rawData.trim();
            String commandName = rawData;
            String commandArgument = "";
            int index = rawData.indexOf(" ");
            if (index != -1) {
                commandName = rawData.substring(0, index);
                commandArgument = rawData.substring(index + 1).trim();
            }

            Consumer<String> command = commands.get(commandName);
            if (command != null) {
                command.accept(commandArgument);
            }
        }
    }

    private static void commnadDIR(String argument) {
        if (argument.isEmpty()) {
            System.out.printf("Directory of %s\n\n", getCurrentDir().getAbsolutePath());
            printCurrentDir();
        } else {
            File temp = getCurrentDir();
            try {
                setCurrentDir(new File(argument));
                System.out.printf("Directory of %s\n\n", getCurrentDir().getAbsolutePath());
                printCurrentDir();
            }
            finally {
                setCurrentDir(temp);
            }
        }
        System.out.println();
    }

    private static void printCurrentDir() {
        File[] files = currentDir.listFiles();
        if (files != null) {
            for (File file : files) {
                try {
                    BasicFileAttributes attributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);

                    System.out.printf("%1$td.%1$tm.%1$tY  %1$tH:%1$tM    %2$5s %3$10s %4$s\n",
                            attributes.creationTime().toMillis(),
                            attributes.isDirectory() ? "<DIR>" : "",
                            attributes.isDirectory() ? "" : Long.toString(attributes.size()),
                            file.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void commnadCD(String argument) {
        setCurrentDir(new File(argument));
        System.out.println(getCurrentDir());
        System.out.println();
    }

    private static void setCurrentDir(File file) {
        if (file != null) {
            File temp = null;

            if (file.isAbsolute()) {
                temp = Paths.get(file.getAbsolutePath()).toFile();
            } else {
                try {
                    temp = Paths.get(currentDir.getAbsolutePath(), file.getName()).toFile().getCanonicalFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if ((temp != null) && temp.exists() && temp.isDirectory()) {
                currentDir = temp;
            }
        } else {
            currentDir = getCurrentDir();
        }
    }

    private static File getCurrentDir() {
        if (currentDir == null) {
            Class<?> aClass = MethodHandles.lookup().lookupClass();
            return Paths.get(
                    System.getProperty("user.dir"), "src",
                    aClass.getPackage().getName().replace(".", File.separator)).toFile();
        } else {
            return currentDir;
        }
    }
}