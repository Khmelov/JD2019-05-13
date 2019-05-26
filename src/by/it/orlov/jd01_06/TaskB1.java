package by.it.orlov.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        String[] words = Poem.text.replaceAll("[^а-яА-ЯёЁ ]", " ").split("[ ]+");
        check(words);
    }
    private static void check(String[] words){
        String a = "а о и е ё э ы у ю я У Е Ё А О Э Я И Ю";
        for (int i = 0; i < words.length; i++) {
            if(!a.contains(String.valueOf(words[i].charAt(0)))){
                if (a.contains(String.valueOf(words[i].charAt(words[i].length()-1)))){
                    System.out.println(words[i]);
                }
            }
        }
    }





}
