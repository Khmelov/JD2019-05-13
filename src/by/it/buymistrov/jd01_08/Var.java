package by.it.buymistrov.jd01_08;

abstract class   Var implements Operation {

    @Override
    public String toString() {
        return "abstract 2";
    }


    @Override
    public Var add(Var other) {
        System.out.printf("Операция сложения %s + %s невозможна", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция вычитания  %s - %s невозможна", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция умножения %s * %s невозможна", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция деления %s / %s невозможна", this, other);
        return null;
    }
}
