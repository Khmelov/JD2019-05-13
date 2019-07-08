package by.it.dilkevich.calc;

import java.io.IOException;

public class ReportBuilderDirector {

    AbstractReportBuilder abstractReportBuilder;

    void setReportBuilder(AbstractReportBuilder abstractReportBuilder){

        this.abstractReportBuilder = abstractReportBuilder;
    }

    void createReport() throws IOException {

        abstractReportBuilder.createReport();
        abstractReportBuilder.createReportName();
        abstractReportBuilder.makeInputResultOperations();
        abstractReportBuilder.makeLogOperations();
        abstractReportBuilder.printReport();

    }


}
