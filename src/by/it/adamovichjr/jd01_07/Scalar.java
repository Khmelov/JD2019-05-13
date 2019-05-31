package by.it.adamovichjr.jd01_07;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar (String str){
        this.value = Double.parseDouble(str);
    }

    Scalar (Scalar scalar){
        double buffer = scalar.value;
        this.value = buffer;
    }
    @Override
    public String toString() {

        return Double.toString(value);
    }
}
