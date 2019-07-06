package by.it.zhukova.calc;
import by.it.zhukova.calc.exceptions.Exceptions;

public class CalcException extends Exception{
    public CalcException() {
        super(ConsoleRunner.manager.get(Exceptions.ERROR));
    }

    public CalcException(String message) {
        super(ConsoleRunner.manager.get(Exceptions.ERROR)+message);
    }

    public CalcException(String message, Throwable cause) {
        super(ConsoleRunner.manager.get(Exceptions.ERROR)+message, cause);
    }

    public CalcException(Throwable cause) {
        super(ConsoleRunner.manager.get(Exceptions.ERROR)+cause);
    }
}
