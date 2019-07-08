package by.it.aadamovich.calc;

import by.it.aadamovich.calc.names.ResData;

public class CalcException extends Exception {
    private static final long serialVersionUID = 3347445202504798190L;

    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super(String.format
                (ResourceManager.INSTANCE.getString(ResData.ERROR_MESSAGE),message));
    }

    public CalcException(String message, Throwable cause) {
        super(String.format
                (ResourceManager.INSTANCE.getString(ResData.ERROR_MESSAGE),message), cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(String.format
                (ResourceManager.INSTANCE.getString
                        (ResData.ERROR_MESSAGE),message), cause, enableSuppression, writableStackTrace);
    }

}
