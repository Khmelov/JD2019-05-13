package by.it.zhukova.calc;
import by.it.zhukova.calc.exceptions.Exceptions;

import static by.it.zhukova.calc.ConsoleRunner.*;

public class CalcException extends Exception{
    public CalcException() {
        super(manager.get(Exceptions.ERROR));
    }

    public CalcException(String message) {

        super(manager.get(Exceptions.ERROR)+message);
        exp=manager.get(Exceptions.ERROR)+message;
        Logger.printException(exp);
    }

    public CalcException(String message, Throwable cause) {
        super(manager.get(Exceptions.ERROR)+message, cause);
        exp=manager.get(Exceptions.ERROR)+message+cause;
        Logger.printException(exp);
    }

    public CalcException(Throwable cause) {
        super(manager.get(Exceptions.ERROR)+cause);
        exp=manager.get(Exceptions.ERROR)+cause;
        Logger.printException(exp);
    }
    String exp;

}
