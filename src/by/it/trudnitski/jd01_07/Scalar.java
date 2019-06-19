package by.it.trudnitski.jd01_07;

public class Scalar extends Var{
    private double value;

    @Override
    public String toString(){
        return Double.toString(value);
    }

    public Scalar(double value) {
        this.value=value;
    }
    public Scalar(Scalar scalar){
        this.value=scalar.value;
    }
    public Scalar(String strScalar){
        this.value=Double.parseDouble(strScalar);
    }
}
