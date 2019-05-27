package by.it.tbabich.jd01_01;

public class Args {
    private String[] arguments;

    public String[] getArguments() {
        return arguments;
    }

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    void printArguments() {
        for (String arg: arguments)
            System.out.println(arg);
        }
    }

