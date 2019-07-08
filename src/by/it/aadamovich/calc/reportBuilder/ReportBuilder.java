package by.it.aadamovich.calc.reportBuilder;

public abstract class ReportBuilder {

    Report report;

    Report getReport() {
        return report;
    }

    void createNewReport() {
        report = new Report();
    }

    public abstract void buildReportName();

    public abstract void buildStartEndTime(String time);

    public abstract void buildRuntimeEvents(String event);

    public abstract void buildRuntimeErrors(Throwable error);
}
