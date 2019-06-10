package by.it.lasotskaya.jd01_07;

class Scalar extends Var {

    private  double value;

    Scalar (double value){
        this.value=value;
    }

    Scalar (String str){
        value=Double.parseDouble(str);
    }

    Scalar (Scalar otherScalar){
        this.value=otherScalar.value;
    }


    @Override
    public String toString() {
        return  Double.toString(value);
    }
}
