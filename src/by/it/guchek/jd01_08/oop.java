package by.it.guchek.jd01_08;

public class oop {
    public static void main(String[] args) {
        Film film = new NativeFilm();
        film.chooseFilm();
        if (film.turnOnFilm()) System.out.println("Фильм включен "+film.turnOnFilm());
        film.watchFilm();
        if (film.turnOffFilm()) System.out.println("Окончен просмотр отечественного фильма");
        System.out.println();

        Film film1 = new Comedy();
        film1.chooseFilm();
        if (film1.turnOnFilm()) System.out.println("Фильм включен "+film1.turnOnFilm());
        film1.watchFilm();
        if (film1.turnOffFilm()) System.out.println("Окончен просмотр отечественной комедии");


    }
}
