package by.it.tbabich.calc.builder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Report {

    private File file;
    private FileWriter fileWriter;
    private HeadReport head;
    private FooterReport footer;
    private StringBuilder bodyReport;

    public Report(File file, HeadReport head, FooterReport footer, StringBuilder bodyReport) {
        this.file = file;
        this.head = head;
        this.footer = footer;
        this.bodyReport = bodyReport;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeReport() {
        try {
            fileWriter.write(head.getHead());
            fileWriter.write(bodyReport.toString());
            fileWriter.write(footer.getFooter());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
