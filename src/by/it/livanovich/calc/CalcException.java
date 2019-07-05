package by.it.livanovich.calc;

import by.it.livanovich.calc.Text.Helper;
import by.it.livanovich.calc.Text.Messages;

public class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(String message) {
        super(Helper.INSTANCE.getKey(Messages.ERROR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(Helper.INSTANCE.getKey(Messages.ERROR)+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(Helper.INSTANCE.getKey(Messages.ERROR)+message, cause, enableSuppression, writableStackTrace);
    }
}
