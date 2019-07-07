package by.it.yakovets.calc;

public class CalcException extends Exception {

    public CalcException() {
        super("ERROR:");
        new Logger(this);

    }

    public CalcException(String message) {
        super("ERROR:"+message);
        new Logger(this);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR:"+message, cause);
        new Logger(this);
    }

    protected CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR:"+message, cause, enableSuppression, writableStackTrace);
        new Logger(this);
    }

    public CalcException(Throwable cause) {
        super("ERROR:"+cause);
        new Logger(this);
    }

}

