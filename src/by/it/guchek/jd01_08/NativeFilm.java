package by.it.guchek.jd01_08;

public class NativeFilm implements Film {

    public void chooseFilm() {
        System.out.println("Для просмотра выбран отечественный фильм");

    }

    public boolean turnOnFilm() {
        return true;
    }

    public void watchFilm() {
        System.out.println("Смотрим отечественный фильм");

    }

    public boolean turnOffFilm() {
        return true;
    }
}
