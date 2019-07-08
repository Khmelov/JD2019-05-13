package by.it.yaskevich.calc;

public class FullReportBuilder extends ReportBuilder {
    @Override
    void buildName() {
        name = "Full report";
    }

    @Override
    void buildEvent(String event) {
        events.add(getDateNow() + " " + event);
    }

    @Override
    void buildException(Exception exception) {exception.printStackTrace();
        String data = "";
        StackTraceElement[] stackTrace = exception.getStackTrace();
        for (StackTraceElement traceElement : stackTrace) {
            data += traceElement.toString() + "\n";
        }
        exceptions.add(getDateNow() + " " + exception.getMessage() + "\n" + data);
    }
}
