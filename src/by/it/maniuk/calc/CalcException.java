package by.it.maniuk.calc;

public class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(String message) {
        super(message);
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message,String text) {
        super(message + text);
    }



}
