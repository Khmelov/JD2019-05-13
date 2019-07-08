package by.it.yaskevich.calc;

class ShortReportBuilder extends ReportBuilder {
    @Override
    void buildName() {
        name = "Short report";
    }

    @Override
    void buildEvent(String event) {
        events.add(getDateNow() + " " + event);
    }

    @Override
    void buildException(Exception exception) {
        exceptions.add(getDateNow() + " " + exception.getMessage());
    }
}
