package by.it.aadamovich.calc.reportBuilder;

import by.it.aadamovich.calc.ResourceManager;

public class ShortReportBuilder extends ReportBuilder {

    @Override
    public void buildReportName() {
        report.addReportName(ReportNames.SHORT_NAME);
    }

    @Override
    public void buildStartEndTime(String time) {
        report.addStartEndTime(String.format(time, ResourceManager.INSTANCE.getDate()));
    }

    @Override
    public void buildRuntimeEvents(String event) {
        report.addRuntimeEvents(event);
    }

    @Override
    public void buildRuntimeErrors(Throwable error) {
        report.addRuntimeErrors(error.getMessage());
    }
}
