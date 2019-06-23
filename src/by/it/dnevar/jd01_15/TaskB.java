package by.it.dnevar.jd01_15;

import java.io.*;

import static by.it.dnevar.jd01_15.TaskBFlagCommentes.*;

public class TaskB {

    private static String fileTaskB = getFilePath(TaskA.class, "TaskB.java");
    private static String fileResultTxt = getFilePath(TaskA.class, "TaskB.txt");
    private static StringBuilder text = new StringBuilder();

    public static void main(String[] args){

        deleteComentsPrintToConsole();
        System.out.println(text);
        printToFile();

    }

    //  однострочный комментарий

    private static void printToFile() {
        try (PrintWriter out = new PrintWriter(fileResultTxt)) {
            out.print(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //  однострочный комментарий

    private static void deleteComentsPrintToConsole(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileTaskB))) {
            boolean add = true;
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line.contains(openComent[0]) || line.contains(openComent[1]) || line.contains(openComent[2])) {
                    add = false;
                }
                if (add) {
                    text.append(line).append("\n");
                }
                if (line.contains(closeComent[0]) || line.contains(closeComent[1])) {
                    add = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * комментарий в виде javadoc
     *
     * @param aClass
     * @return
     */

    private static String getPath(Class<?> aClass) {
        String root = System.getProperty("user.dir")
                + File.separator
                + "src"
                + File.separator;
        String name = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return root + name;
    }

    /* комментарий
    из
    нескольких
    строк*/

    private static String getFilePath(Class<?> aClass, String filename) {
        return getPath(aClass) + filename;
    }
}
