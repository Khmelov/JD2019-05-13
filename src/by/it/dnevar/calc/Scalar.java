package by.it.dnevar.calc;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strValue) {
        this.value=Double.parseDouble(strValue);
    }

    Scalar(Scalar scalar) {
        this.value=scalar.value;
    }

    @Override
    public Var add(Var other) throws CalcException{
        if(other instanceof Scalar){
            double res = this.value + ((Scalar)other).value;
            Log.setLog(this.value+"+"+((Scalar)other).value+"="+res);
            return new Scalar(res);
        }else{
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if(other instanceof Scalar){
            double res = this.value - ((Scalar)other).value;
            Log.setLog(this.value+"-"+((Scalar)other).value+"="+res);
            return new Scalar(res);
        }else{
            return new Scalar(-1).mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if(other instanceof Scalar){
            double res = this.value * ((Scalar)other).value;
            Log.setLog(this.value+"*"+((Scalar)other).value+"="+res);
            return new Scalar(res);
        }else{
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) throws CalcException{
        if(other instanceof Scalar){
            if(((Scalar)other).value!=0){
                double res = this.value / ((Scalar)other).value;
                Log.setLog(this.value+"/"+((Scalar)other).value+"="+res);
                return new Scalar(res);
            }else{
                Log.setLog("Деление на ноль");
            throw new CalcException("Деление на ноль");
            }
        }
        return super.div(other);

    }

    @Override
    public String toString(){
        return Double.toString(value);
    }
}
