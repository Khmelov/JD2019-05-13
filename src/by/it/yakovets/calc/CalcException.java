package by.it.yakovets.calc;

public class CalcException extends Exception {

    public CalcException() {
        super("ERROR:");
    }

    public CalcException(String message) {
        super("ERROR:"+message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR:"+message, cause);
    }

    public CalcException(Throwable cause) {
        super("ERROR:"+cause);
    }

    protected CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
