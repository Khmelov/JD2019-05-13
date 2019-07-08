package by.it.adamovichjr.calc;

import by.it.adamovichjr.calc.text.All_messages;

public class CalcException extends Exception {


    public CalcException() {
        super(ResourceManager.INSTANCE.get(All_messages.ERROR));
    }

    public CalcException(String message) {
        super(ResourceManager.INSTANCE.get(All_messages.ERROR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ResourceManager.INSTANCE.get(All_messages.ERROR) + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    protected CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(ResourceManager.INSTANCE.get(All_messages.ERROR) + message, cause, enableSuppression, writableStackTrace);
    }
}
