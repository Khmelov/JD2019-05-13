package by.it.adamovichjr.calc.report;

import by.it.adamovichjr.calc.ResourceManager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public enum Director {
    DIRECTOR;
    ReportBuilder builder;
    private List<Throwable> exceptions = new ArrayList<>();
    private List<String> events = new LinkedList<>();
    private List<String> time = new LinkedList<>();
    private List<String> timeOfExceptions = new ArrayList<>();
    private List<String> eventsWithExceptions = new ArrayList<>();


    public void SetBuilder(ReportBuilder builder) {
        this.builder = builder;
    }

    public void putTime(String message) {
        this.time.add(message + ResourceManager.INSTANCE.getTime());
    }

    public void putExceptionToDirector(Throwable exception, String event, String time) {
        this.exceptions.add(exception);
        this.timeOfExceptions.add(time);
        this.eventsWithExceptions.add(event);
    }

    public void putEventToDirector(String event) {
        this.events.add(event);
    }

    public Report BuildReport() {
        builder.createReport();
        builder.buildName();
        builder.buildTime(time);
        builder.buildEvents(events);
        builder.buildExceptions(exceptions, eventsWithExceptions, timeOfExceptions);
        return builder.getReport();
    }

}
