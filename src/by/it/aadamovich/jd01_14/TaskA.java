package by.it.aadamovich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class TaskA {

    public static void main(String[] args) {
        String fileBin = getFilePath("dataTaskA.bin");
        String fileTxt = getFilePath("resultTaskA.txt");

        writeFileBi(fileBin);
        readFileBi(fileBin);
        writeFileTxt(fileTxt);
    }

    private static void writeFileBi(String filename) {
        try (DataOutputStream outData = new DataOutputStream
                (new BufferedOutputStream
                        (new FileOutputStream(filename)))
        ) {
            for (int i = 0; i < 20; i++) {
                outData.writeInt((int) (Math.random() * 101));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Integer> list = new ArrayList<>();

    private static void readFileBi(String filename) {
        try (DataInputStream inData = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(filename)))
        ) {
            while (inData.available() > 0) {
                list.add(inData.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFileTxt(String filename) {
        try (PrintWriter outTxt = new PrintWriter
                (new FileWriter(filename))
        ) {
            double sum = 0;
            for (Integer number : list) {
                sum += number;
                System.out.printf("%d ", number);
                outTxt.printf("%d ", number);
            }
            System.out.printf(Locale.ENGLISH, "\navg=%.3f", sum / list.size());
            outTxt.printf(Locale.ENGLISH, "\navg=%.3f", sum / list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Class<TaskA> cls = TaskA.class;

    private static String getFilePath(String filename) {
        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = cls.getName().replace(cls.getSimpleName(), "").replace(".", sep);
        return srcPath + classPath + filename;
    }
}
