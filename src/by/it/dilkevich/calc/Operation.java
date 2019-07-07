package by.it.dilkevich.calc;

import java.io.IOException;

public interface Operation {
    Var add(Var other) throws CalcException, IOException;
    Var sub(Var other) throws CalcException, IOException;
    Var mul(Var other) throws CalcException, IOException;
    Var div(Var other) throws CalcException, IOException;
}
