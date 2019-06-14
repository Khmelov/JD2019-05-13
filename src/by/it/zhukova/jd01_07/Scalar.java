package by.it.zhukova.jd01_07;

 class Scalar extends Var{
    private double value;
     Scalar(double value) {
        this.value = value;
    }
 Scalar (Scalar scalar){
        this.value=scalar.value;
}
     Scalar (String strvalue){
        this.value= Double.parseDouble(strvalue);
    }
    @Override
    public String toString() {
        return Double.toString(value);
    }
}
