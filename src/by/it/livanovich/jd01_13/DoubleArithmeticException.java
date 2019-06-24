package by.it.livanovich.jd01_13;

public class DoubleArithmeticException extends Exception {
    public DoubleArithmeticException(String message) {
        super(message);
    }

    public DoubleArithmeticException() {
        super();
    }

    public DoubleArithmeticException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoubleArithmeticException(Throwable cause) {
        super(cause);
    }
}
