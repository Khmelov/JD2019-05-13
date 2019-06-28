package by.it.maniuk.jd01_12;


import java.util.Deque;
import java.util.LinkedList;


public class TaskC3 {
    public static void main(String[] args) {
       //String text =  "«(», «)»,«[», «]», «{», «}»";
      //  String text =  "()[]{}";
  String text =  "([]{}(";

        System.out.println(validation(text));


    }
    private static boolean validation(String text){
        Deque<Character> queue = new LinkedList<>();
        for (char c : text.toCharArray()) {
            if (isClosingBracket(c) && queue.isEmpty()){
                return false;
            }
            if (isOpeningBracket(c)){
                queue.push(c);

            }
            if (isClosingBracket(c)){

                if (isOk(queue.element(), c)){
                    queue.pop();
                } else {
                    return false;
                }

            }
        }
   //     Е рор() - возвращает элемент, находящийся в голове двунаправленной очереди, одновременно удаляя его из очереди.
        //     Возбуждает исключение NoSuchElementException, если очередь пуста.
     //   void push(Е obj) - добавляет элемент в голову двунаправленной очереди.
        //   Если в очереди фиксированного объема нет места, возбуждает исключение IllegalStateException.
        return queue.isEmpty();
    }

    private static boolean isClosingBracket(char bracket) {
        return ")}]".indexOf(bracket) != -1;
    }
    private static boolean isOpeningBracket(char bracket) {
        return "({[".indexOf(bracket) != -1;
    }
    private static boolean isOk(char opening, char closing) {
        return opening == '(' && closing == ')' || opening == '['
                && closing == ']' || opening == '{' && closing == '}';
    }
}
