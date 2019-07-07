package by.it.adamovichjr.calc.report;

import java.util.List;

public class ShortReportBuilder extends ReportBuilder {
    @Override
    void buildName() {
        report.setReportName("SHORT REPORT");
    }

    @Override
    void buildTime(List<String> time) {
        for (String el : time) {
            report.addTime(el);
        }
    }

    @Override
    void buildEvents(List<String> events) {
        for (String event : events) {
            report.addEvents(event);
        }
    }

    @Override
    void buildExceptions(List<Throwable> exceptions,List<String> events,List<String> time) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < exceptions.size(); i++) {
            buffer.append("Event with Exception: ").append(events.get(i)).append("\n")
                    .append(exceptions.get(i).getMessage()).append("\n")
                    .append("Time of exception: ").append(time.get(i)).append("\n\n");
        }
        report.addExceptions(buffer.toString());
    }

}
