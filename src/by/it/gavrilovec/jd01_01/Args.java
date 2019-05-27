package by.it.gavrilovec.jd01_01;

public class Args {
    private String[] args;
    public Args(String[] args){
        this.args=args;
    }
    public void printArgs(){
        for(String s:args){
            System.out.println(s);
        }
    }
}
