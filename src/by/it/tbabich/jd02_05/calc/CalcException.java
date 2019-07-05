package by.it.tbabich.jd02_05.calc;

import by.it.tbabich.jd02_05.calc.names.Errors;

public class CalcException extends Exception {

    public CalcException() {
        super(Settings.manager.get(Errors.ERROR));
    }

    public CalcException(String message) {
        super(Settings.manager.get(Errors.ERROR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(Settings.manager.get(Errors.ERROR) + message, cause);
    }

    public CalcException(Throwable cause) {
        super(Settings.manager.get(Errors.ERROR), cause);
    }

}
