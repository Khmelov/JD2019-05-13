package by.it.akhmelev.jd01_01;

public class Args {

    private String[] arguments;

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    public String[] getArguments() {
        return arguments;
    }

    void printArguments(){
        for (String argument : arguments) {
            System.out.println(argument);
        }
    }
}
