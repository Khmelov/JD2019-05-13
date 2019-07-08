package by.it.yaskevich.calc;

public class CalcException extends Exception {
    public CalcException() {
        super(ResourcesManager.INSTANCE.getString(Resources.ERROR));
        Logger.INSTANCE.log(getMessage());
    }

    public CalcException(String message) {
        super(ResourcesManager.INSTANCE.getString(Resources.ERROR) + message);
        Logger.INSTANCE.log(getMessage());
    }

    public CalcException(String message, Throwable cause) {
        super(ResourcesManager.INSTANCE.getString(Resources.ERROR) + message, cause);
        Logger.INSTANCE.log(getMessage());
    }

    public CalcException(Throwable cause) {
        super(ResourcesManager.INSTANCE.getString(Resources.ERROR), cause);
        Logger.INSTANCE.log(getMessage());
    }
}
