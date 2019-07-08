package by.it.aadamovich.calc.reportBuilder;

import by.it.aadamovich.calc.ResourceManager;

public class FullReportBuilder extends ReportBuilder {

    @Override
    public void buildReportName() {
        report.addReportName(ReportNames.FULL_NAME);
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
        StringBuilder sb = new StringBuilder();
        sb.append(error.getMessage()).append('\n');
        sb.append(String.format
                ((ReportNames.ERROR_TIME), ResourceManager.INSTANCE.getDate())).append('\n');
        StackTraceElement[] trace = error.getStackTrace();
        for (StackTraceElement element : trace) {
            sb.append(element.toString()).append('\n');
        }
        buildRuntimeEvents(error.getMessage());
        report.addRuntimeErrors(sb.toString());
    }
}
