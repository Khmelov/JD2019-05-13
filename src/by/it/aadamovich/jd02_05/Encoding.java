package by.it.aadamovich.jd02_05;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Encoding {

    static void encodingToAscii(String readFrom, String writeTo, Class<?> cls) {

        String filenameRead = getFilePath(readFrom, cls);
        String filenameWrite = getFilePath(writeTo, cls);

        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader
                        (new FileInputStream(filenameRead), StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter
                     (new OutputStreamWriter
                             (new FileOutputStream(filenameWrite), "US-ASCII"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static String getFilePath(String filename, Class<?> cls) {

        String sep = File.separator;
        String srcPath = System.getProperty("user.dir") + sep + "src" + sep;
        String classPath = cls.getName().replace(cls.getSimpleName(), "").replace(".", sep);
        return srcPath + classPath + filename;
    }
}
