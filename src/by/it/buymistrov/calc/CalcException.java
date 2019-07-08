package by.it.buymistrov.calc;

import by.it.buymistrov.calc.names.Messages;

public class CalcException extends Exception {


    private static final long serialVersionUID = 343245862944858063L;

    public CalcException() {
        super(ResManager.INSTANCE.get(Messages.ERROR));
    }

    public CalcException(String message) {
        super(ResManager.INSTANCE.get(Messages.ERROR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ResManager.INSTANCE.get(Messages.ERROR) + message, cause);
    }

    public CalcException(Throwable cause) {
        super(ResManager.INSTANCE.get(Messages.ERROR), cause);
    }
}
