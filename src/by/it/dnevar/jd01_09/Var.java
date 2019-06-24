package by.it.dnevar.jd01_09;

abstract class Var implements Operation {

    public static Var createVar(String operand){
        operand = operand.trim().replaceAll("\\s+","");
        if(operand.matches(Operation.SCALAR)){
            return new Scalar(operand);
        }else if(operand.matches(Operation.VECTOR)){
            return new Vector(operand);
        }else if(operand.matches(Operation.MATRIX)){
            return new Matrix(operand);
        }else{
            return  null;
        }
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция "+this+" + "+other+" невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция "+this+" - "+other+" невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция "+this+" * "+other+" невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция "+this+" / "+other+" невозможна");
        return null;
    }

    @Override
    public String toString(){
        return "Этот класс Var";
    }


}
