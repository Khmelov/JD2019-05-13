package by.it.dilkevich.calc;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class AbstractReportBuilder {

    private Report report;

    public Report getReport() {
        return report;
    }

    public void createReport() {
        report = new Report();
    }

    abstract String makeInputResultOperations() throws IOException;
    abstract String makeLogOperations() throws IOException;
    abstract String createReportName() throws IOException;
    abstract void printReport();
}
