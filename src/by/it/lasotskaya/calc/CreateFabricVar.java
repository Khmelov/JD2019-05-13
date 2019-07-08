package by.it.lasotskaya.calc;

class CreateFabricVar {
    Var getVar(String strVar) throws CalcException {
        strVar=strVar.replaceAll("\\s*","");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
                return Var.vars.get(strVar);
        throw  new CalcException("не понимаю,ошибка "+strVar); }
}
