package by.it.tbabich.calc.builder;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FooterReport {

    private StringBuilder footer = new StringBuilder();

    public FooterReport() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        footer.append("Конец работы приложения: ")
                .append(ZonedDateTime.now().format(formatter))
                .append("\n");
        footer.append("===================================================================================");

    }

    public String getFooter() {
        return footer.toString();
    }
}
