package by.it.yakovets.calc;

public class CalcException extends Exception {

    public CalcException() {
        super("ERROR:");
        Logger.log(this);

    }

    public CalcException(String message) {
        super("ERROR:"+message);
        Logger.log(this);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR:"+message, cause);
        Logger.log(this);
    }

    protected CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR:"+message, cause, enableSuppression, writableStackTrace);
        Logger.log(this);
    }

    public CalcException(Throwable cause) {
        super("ERROR:"+cause);
        Logger.log(this);
    }

}

