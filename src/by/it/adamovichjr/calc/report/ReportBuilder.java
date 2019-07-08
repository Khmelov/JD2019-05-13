package by.it.adamovichjr.calc.report;

import java.util.List;

abstract class ReportBuilder {
    Report report;
    void createReport(){report = new Report();}

    abstract void buildName();
    abstract void buildTime(List<String> time);
    abstract void buildEvents(List<String> events);
    abstract void buildExceptions(List<Throwable> exceptions,List<String> events,List<String> time);

    Report getReport(){return report;}
}
