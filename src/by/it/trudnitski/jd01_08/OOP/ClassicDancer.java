package by.it.trudnitski.jd01_08.OOP;

public class ClassicDancer extends AbstractDancers {
    @Override
    public void Salary() {
        System.out.println("I want more money!");
    }

    @Override
    public boolean isTired() {
        return super.isTired();
    }
}
