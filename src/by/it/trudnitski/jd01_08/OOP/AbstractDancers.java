package by.it.trudnitski.jd01_08.OOP;

public abstract class AbstractDancers implements Dancers {
   public AbstractDancers(){

   }
    @Override
    public boolean isTired() {
        return false;
    }

    @Override
    public void isHealth() {
        System.out.println(" I'm not good feeling");
    }

    @Override
    public void isReady() {
        System.out.println(" Yes, I'm ready to dance!");
    }
    public abstract void Salary();
}
