package by.it.kobrinets.jd02_04;

class Vars {

    Var getVar(String str) throws CalcException {
        str = str.replaceAll("\\s*", "");
        if (str.matches(Patterns.SCALAR))
            return new Scalar(str);
        if (str.matches(Patterns.VECTOR))
            return new Vector(str);
        if (str.matches(Patterns.MATRIX))
            return new Matrix(str);
        if (str.matches(Patterns.VAR))
            return Var.vars.get(str);
        throw new CalcException("Ошибка " + str);
    }
}

