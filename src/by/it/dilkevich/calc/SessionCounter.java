package by.it.dilkevich.calc;

import java.io.*;

public class SessionCounter {

    private static int actualSessionNumber;

    static String getSessionName() throws IOException {
        return "Session №" + actualSessionNumber;
    }

    static void setNewSession() throws IOException {

        BufferedReader fileReader = new BufferedReader(new FileReader("E:\\MyProjects\\JD2019-05-13\\src\\by\\it\\dilkevich\\calc\\text\\session.txt"));
        int read = fileReader.read();
        actualSessionNumber = read+1;
        fileReader.close();

        FileWriter fileWriter = new FileWriter("E:\\MyProjects\\JD2019-05-13\\src\\by\\it\\dilkevich\\calc\\text\\session.txt");
        fileWriter.write(actualSessionNumber);
        fileWriter.close();
    }



}
