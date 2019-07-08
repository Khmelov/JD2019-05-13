package by.it.dilkevich.calc;

import java.io.FileWriter;
import java.io.IOException;

public class OperationsSaver {

    static void saveNewSession() throws IOException {
        FileWriter fileWriter = new FileWriter("E:\\MyProjects\\JD2019-05-13\\src\\by\\it\\dilkevich\\calc\\operations.txt", true);
        fileWriter.write("New session opened: " + Report.startSession + "\n");
        fileWriter.close();
    }

    static void saveEndSession() throws IOException {
        FileWriter fileWriter = new FileWriter("E:\\MyProjects\\JD2019-05-13\\src\\by\\it\\dilkevich\\calc\\operations.txt", true);
        fileWriter.write("Session closed: " + Report.endSession + "\n");
        fileWriter.close();
    }

    static void saveInputOperatonsFile(String input) throws IOException {
        FileWriter fileWriter = new FileWriter("E:\\MyProjects\\JD2019-05-13\\src\\by\\it\\dilkevich\\calc\\operations.txt", true);
        fileWriter.write("Input operaton: "+input+"\n");
        fileWriter.close();
    }

    static void saveResultOperatonsFile(String input) throws IOException {
        FileWriter fileWriter = new FileWriter("E:\\MyProjects\\JD2019-05-13\\src\\by\\it\\dilkevich\\calc\\operations.txt", true);
        fileWriter.write("Result operaton: "+ input+"\n\n");
        fileWriter.close();
    }
}
