package by.it.dilkevich.jd02_06;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;

public class Logger {

    private static Logger logger;
    private Logger(){ }

    static Logger getLogger(){

        if(logger == null){

            logger = new Logger();
            return logger;

        } else {

            return logger;
        }
    }

    static void setLog(String log) throws IOException {

        FileWriter fr = new FileWriter("E:\\MyProjects\\JD2019-05-13\\src\\by\\it\\dilkevich\\jd02_06\\log.txt",true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(log);
        br.append(" " + new Date().toString()+"\n");
        br.close();

    }
}
