package by.it.adamovichjr.calc.report;

import by.it.adamovichjr.calc.ResourceManager;
import by.it.adamovichjr.calc.text.All_messages;

import java.util.List;

public class FullReportBuilder extends ReportBuilder {
    @Override
    void buildName() {
        report.setReportName(ResourceManager.INSTANCE.get(All_messages.FULL_REPORT_NAME));
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
            buffer.append(ResourceManager.INSTANCE.get(All_messages.EVENT_WITH_EXCEPTION)).append(events.get(i)).append("\n")
                    .append(exceptions.get(i).getMessage()).append("\n")
                    .append(ResourceManager.INSTANCE.get(All_messages.TIME_OF_EXCEPTION)).append(time.get(i)).append("\n");
            for (StackTraceElement element : exceptions.get(i).getStackTrace()) {
                buffer.append(element).append("\n");
            }
            buffer.append("\n");
        }
        report.addExceptions(buffer.toString());
    }
}
