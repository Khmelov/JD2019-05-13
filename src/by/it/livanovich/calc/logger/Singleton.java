package by.it.livanovich.calc.logger;

import java.io.IOException;
import java.util.logging.*;

public enum Singleton {
    INSTANCE;
    private Logger logger;
    public void createLog (Logger logger){


        try {
            FileHandler handler=new FileHandler("C:\\ProgramFiles\\Java\\JD2019-05-13\\src\\by\\it\\livanovich\\calc\\logger\\log.txt");
            logger.addHandler(handler);
            SimpleFormatter formatter=new SimpleFormatter();
            handler.setFormatter(formatter);


        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.WARNING,"something wrong",e);
        }
        logger.log(Level.INFO,"everything ok");
    }
}
