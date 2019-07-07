package by.it.adamovichjr.calc.report;

public class Report {
    StringBuilder reportName = new StringBuilder();
    StringBuilder time = new StringBuilder();
    StringBuilder events = new StringBuilder();
    StringBuilder exceptions = new StringBuilder();

    public void setReportName(String name){
        this.reportName.append(name).append("\n");
    }
    public void addTime(String time){
        this.time.append(time).append("\n");
    }
    public void addEvents(String event){
        this.events.append(event).append("\n");
    }
    public void addExceptions(String exception){
        this.exceptions.append(exception).append("\n");
    }

    @Override
    public String toString() {
        return reportName.append("\n")
                .append(time).append("\n")
                .append("Events").append("\n\n")
                .append(events).append("\n")
                .append("Exceptions").append("\n\n")
                .append(exceptions).toString();
    }
}
