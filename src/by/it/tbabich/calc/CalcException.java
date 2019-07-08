package by.it.tbabich.calc;


import by.it.tbabich.calc.names.Errors;

public class CalcException extends Exception {

    public CalcException() {
        super(Settings.manager.get(Errors.ERROR));
    }

    public CalcException(String message) {
        super(Settings.manager.get(Errors.ERROR) + message);
        Settings.fullReportBuilder.addExceptionToBody(this);
        Settings.shortReportBuilder.addExceptionToBody(this);
        Settings.log(Settings.manager.get(Errors.ERROR) + message);
    }

    //    public CalcException(String message, Throwable cause) {
//        super(Settings.manager.get(Errors.ERROR) + message, cause);
//    }
//
//    public CalcException(Throwable cause) {
//        super(Settings.manager.get(Errors.ERROR), cause);
//    }
    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: " + message, cause, enableSuppression, writableStackTrace);
    }

}
