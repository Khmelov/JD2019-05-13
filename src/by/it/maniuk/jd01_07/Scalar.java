package by.it.maniuk.jd01_07;

public class Scalar extends Var {

    private double  value;

    Scalar(double value) {
        this.value = value;
    }
    Scalar (Scalar scalar){
        this.value = scalar.value;
    }
    Scalar (String strValue){
        this.value = Double.parseDouble(strValue);
    }



    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
