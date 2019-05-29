package by.it.akhmelev.jd01_07;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar){
        this(scalar.value);
    }

    Scalar(String strValue){
        this(Double.parseDouble(strValue));
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}
