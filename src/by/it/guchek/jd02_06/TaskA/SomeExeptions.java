package by.it.guchek.jd02_06.TaskA;

import java.util.HashMap;

public class SomeExeptions {

    public static void main(String[] args) /*throws RuntimeException*/ {

        Logger logger = Logger.getInstance();

        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (Exception e) {
            e.printStackTrace();
            //распечатать стек путей ошибок в лог
            logger.printExeptionsOutLogFile(e);

        }
    }

}
