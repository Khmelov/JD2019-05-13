package by.it.aadamovich.calc.reportBuilder;

public class Report {

    private StringBuilder reportName;
    private StringBuilder startEndTime;
    private StringBuilder runtimeEvents;
    private StringBuilder runtimeErrors;

    Report() {
        reportName = new StringBuilder();
        startEndTime = new StringBuilder();
        runtimeEvents = new StringBuilder();
        runtimeErrors = new StringBuilder();
    }

    void addReportName(String name) {
       reportName.append(name).append('\n');
    }

    void addStartEndTime(String time) {
        startEndTime.append(time).append('\n');
    }

    void addRuntimeEvents(String event) {
        runtimeEvents.append(event).append('\n');
    }

    void addRuntimeErrors(String error) {
        runtimeErrors.append(error).append('\n');
    }

    @Override
    public String toString() {
        return reportName.append("\n")
                .append(startEndTime).append('\n')
                .append(ReportNames.RUN_EVENTS).append("\n\n")
                .append(runtimeEvents).append('\n')
                .append(ReportNames.RUN_ERRORS).append("\n\n")
                .append(runtimeErrors).toString();
    }
}
