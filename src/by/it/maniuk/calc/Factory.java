package by.it.maniuk.calc;

import by.it.maniuk.calc.names.Messages;

class Factory {

    static Var create(String strVar) throws CalcException {
    strVar =strVar.replaceAll("\\s+","");
        if(strVar.matches(Patterns.SCALAR))
            return new  Scalar(strVar);
        else if(strVar.matches(Patterns.VECTOR))
            return new  Vector(strVar);
        else if(strVar.matches(Patterns.MATRIX))
            return new  Matrix(strVar);
        else if(Var.getVars().containsKey(strVar))
            return Var.getVars().get(strVar);
        else if(strVar.equals("ru")||strVar.equals("be")||strVar.equals("en"))return null;
        throw new CalcException(Messages.INPUTERROR);
}
}
