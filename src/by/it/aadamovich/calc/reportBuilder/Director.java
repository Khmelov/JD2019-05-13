package by.it.aadamovich.calc.reportBuilder;

public enum Director {

    DIRECTOR;

    private ReportBuilder builder;

    public void setBuilder(ReportBuilder builder) {
        this.builder = builder;
    }

    public Report getReport() {
        return builder.getReport();
    }

    public void startReport() {
        builder.createNewReport();
        builder.buildReportName();
        builder.buildStartEndTime(ReportNames.START_TIME);
    }

    public void addEvent(String event) {
        builder.buildRuntimeEvents(event);
    }

    public void addError(Throwable error) {
        builder.buildRuntimeErrors(error);
    }

    public void endReport() {
        builder.buildStartEndTime(ReportNames.END_TIME);
    }

}
