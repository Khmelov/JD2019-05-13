package by.it.tbabich.calc.builder;

import java.io.File;

public class FullReportBuilder extends ReportBuilder{

    private File file;
    private HeadReport head;
    private FooterReport footer;
    private StringBuilder bodyReport;

    @Override
    public void addExpressionToBody(String expression) {
        this.bodyReport.append(expression).append("\n");
    }

    @Override
    public void addExceptionToBody(Exception exception) {
        this.bodyReport.append("Exception: ")
                .append(exception.getClass())
                .append(" : ")
                .append(exception.getMessage())
                .append("\n");
    }

    @Override
    public void setHeadReport(HeadReport head) {
        this.head = head;
    }

    @Override
    public void setFooterReport(FooterReport footer) {
        this.footer = footer;
    }

    @Override
    public void setFile(String filename) {
        this.file = new File(getFilePath(filename));
    }

    public Report getFullReport(){
        return new Report(file, head, footer, bodyReport);
    }

    @Override
    public void setStringBuilder(StringBuilder bodyReport) {
        this.bodyReport = bodyReport;
    }
}
