package by.it.izaykoff.calc;

public class CalcException extends Exception {
    public CalcException(String s, Var var, Var other) {
        super("ERROR: " + "Операция " + var + " / " + other + " невозможна" );
    }

    public CalcException(String message) {
        super("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
