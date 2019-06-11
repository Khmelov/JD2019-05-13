package by.it.lasotskaya.jd01_08.oop;

abstract class CommonShip implements Ship {
    public String country(String str) {
        return "Method country will return name of the country";
    }

    public String toString(){
        return "Method toString will return values in String";
    }

    @Override
    public boolean swim() {
        System.out.println("Method swim will return if the ship can swim:true or false");
        return false;
    }
}
