package by.it.adamovichjr.jd01_09_v2;

interface Operation {
    Var add(Scalar other);
    Var add(Vector other);
    Var add(Matrix other);

    Var sub(Scalar other);
    Var sub(Vector other);
    Var sub(Matrix other);

    Var mul(Scalar other);
    Var mul(Vector other);
    Var mul(Matrix other);

    Var div(Scalar other);
    Var div(Vector other);
    Var div(Matrix other);
}