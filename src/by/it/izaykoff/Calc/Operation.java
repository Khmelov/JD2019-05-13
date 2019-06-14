package by.it.izaykoff.Calc;

interface Operation {
    String OPERATION = "[-+/*=]";
    String SCALAR = "-?[0-9]+\\.?[0-9]*";
    String VECTOR = "\\{((-?[0-9]+\\.?[0-9]*),?)+}";
    String MATRIX = "\\{(\\{((-?[0-9]+\\.?[0-9]*),?)+},?)+}";

    Var add(Var other);
    Var sub(Var other);
    Var mul(Var other);
    Var div(Var other);
}