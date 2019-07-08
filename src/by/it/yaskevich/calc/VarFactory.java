package by.it.yaskevich.calc;

public class VarFactory {
    public static Var getInstance(String strVar) throws CalcException {
        strVar = strVar.replaceAll("\\s+", "");

        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (Var.getVars().containsKey(strVar))
            return Var.getVars().get(strVar);
        else
            throw new CalcException(
                    ResourcesManager.INSTANCE.getString(Resources.UNABLETOCREATE) + " " + strVar);
    }
}
