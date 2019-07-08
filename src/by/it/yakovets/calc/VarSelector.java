package by.it.yakovets.calc;

public class VarSelector {
    Var getVar(String stringVar) throws CalcException {
        Var var;
        if (stringVar.matches(Patterns.SCALAR)) {
            var = new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            var = new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MATRIX)) {
            var = new Matrix(stringVar);
        } else throw new CalcException("Невозможно создать " + stringVar);

        return var;
    }
}
