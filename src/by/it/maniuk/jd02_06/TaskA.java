package by.it.maniuk.jd02_06;

public class TaskA {
    public static void main(String[] args) {
       Singleton log = Singleton.getInstance();
        for (int i = 1; i < 11; i++) {
            log.printToLog("Error № "+i);
    }


    }
}
