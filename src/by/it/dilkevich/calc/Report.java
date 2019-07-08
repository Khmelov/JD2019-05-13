package by.it.dilkevich.calc;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Report {

    static String startSession;
    static String endSession;

    public String getStartSession() {
        return startSession;
    }

    public String getEndSession() {
        return endSession;
    }

    private String header;
    private String startTime;
    private String endTime;
    private String operations;
    private String logs;

    public void setLogs(String logs) {
        this.logs = logs;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    void printReport(){
        StringBuilder sb = new StringBuilder();
        sb.append(new Date().toString()).append("\n").append(header).append("\n\n").append(operations).append("\n\n").append(logs);
        System.out.println(sb.toString());
    }
}
