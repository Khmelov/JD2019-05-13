package by.it.orlov.jd02_06;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

class Log {
    private Log(){ }
    static void putLog(String log) throws IOException {
        BufferedWriter br = new BufferedWriter (new FileWriter("src/by/it/orlov/jd02_06/log.txt",true));
        br.write(log);
        br.append(" ")
          .append(new Date().toString())
          .append("\n")
          .close();

    }
}
