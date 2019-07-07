package by.it.dilkevich.calc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

        FileWriter fr = new FileWriter("E:\\MyProjects\\JD2019-05-13\\src\\by\\it\\dilkevich\\calc\\log.txt",true);
        BufferedWriter br = new BufferedWriter(fr);
        OperationsSaver.saveResultOperatonsFile("Logger: "+log);
        br.write(log);
        br.append(" " + new Date().toString()+"\n");
        br.close();

    }
}
