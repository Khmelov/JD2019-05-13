package by.it.guchek.jd01_08;

public class Comedy extends NativeFilm {

    @Override
    public void chooseFilm() {
        System.out.println("Для просмотра выбрана отечественная комедия");
    }

    @Override
    public void watchFilm() {
        System.out.println("Смотрим отечественную комению");
    }
}
