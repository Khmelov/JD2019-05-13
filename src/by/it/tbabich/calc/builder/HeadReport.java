package by.it.tbabich.calc.builder;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class HeadReport {

    private StringBuilder head = new StringBuilder();

    public HeadReport(String type) {
        if (type.equals("short")) {
            head.append("                       Краткий отчет");
        } else if
        (type.equals("full")) {
            head.append("                       Полный отчет");
        }
        head.append("\n");
        head.append("===================================================================================")
                .append("\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        head.append("Старт работы приложения: ")
                .append(ZonedDateTime.now().format(formatter))
                .append("\n");
    }

    public String getHead() {
        return head.toString();
    }
}

