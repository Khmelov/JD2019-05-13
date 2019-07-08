package by.it.adamovichjr.calc.report;

import by.it.adamovichjr.calc.ResourceManager;
import by.it.adamovichjr.calc.text.All_messages;

public class Report {
    private StringBuilder reportName = new StringBuilder();
    private StringBuilder time = new StringBuilder();
    private StringBuilder events = new StringBuilder();
    private StringBuilder exceptions = new StringBuilder();

    void setReportName(String name){
        this.reportName.append(name).append("\n");
    }
    void addTime(String time){
        this.time.append(time).append("\n");
    }
    void addEvents(String event){
        this.events.append(event).append("\n");
    }
    void addExceptions(String exception){
        this.exceptions.append(exception).append("\n");
    }

    @Override
    public String toString() {
        return reportName.append("\n")
                .append(time).append("\n")
                .append(ResourceManager.INSTANCE.get(All_messages.TITLE_EVENTS)).append("\n\n")
                .append(events).append("\n")
                .append(ResourceManager.INSTANCE.get(All_messages.TITLE_EXCEPTIONS)).append("\n\n")
                .append(exceptions).toString();
    }
}
