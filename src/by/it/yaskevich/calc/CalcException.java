package by.it.yaskevich.calc;

public class CalcException extends Exception {
    public CalcException() {
        super(ResourcesManager.INSTANCE.getString(Resources.ERROR));
    }

    public CalcException(String message) {
        super(ResourcesManager.INSTANCE.getString(Resources.ERROR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(ResourcesManager.INSTANCE.getString(Resources.ERROR) + message, cause);
    }

    public CalcException(Throwable cause) {
        super(ResourcesManager.INSTANCE.getString(Resources.ERROR), cause);
    }
}
