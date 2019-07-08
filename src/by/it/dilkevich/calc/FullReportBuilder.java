package by.it.dilkevich.calc;

import java.io.*;

public class FullReportBuilder extends AbstractReportBuilder {

    @Override
    String makeInputResultOperations() throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new FileReader("E:\\MyProjects\\JD2019-05-13\\src\\by\\it\\dilkevich\\calc\\operations.txt"));
        String line = "";
        int countSpaces = 0;

        while (countSpaces != 2) {
            if(line==null)
                countSpaces++;
            else {
                line = bf.readLine();
                sb.append(line);
                countSpaces = 0;
            }
        }
        getReport().setOperations(sb.toString());
        return sb.toString();
    }

    @Override
    String makeLogOperations() throws IOException {

        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new FileReader("E:\\MyProjects\\JD2019-05-13\\src\\by\\it\\dilkevich\\calc\\log.txt"));
        String line = "";
        int countSpaces = 0;

        while (countSpaces != 2) {
            if(line==null)
                countSpaces++;
            else {
                line = bf.readLine();
                sb.append(line);
                countSpaces = 0;
            }
        }
        getReport().setLogs(sb.toString());
        return sb.toString();
    }

    @Override
    String createReportName() throws IOException {

        getReport().setHeader(SessionCounter.getSessionName());
        return SessionCounter.getSessionName();
    }

    @Override
    void printReport() {
        getReport().printReport();
    }


}
