package by.it.yakovets.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void calc() throws CalcException {
        Parser parser = new Parser();
        Var actual = parser.calc("A=2+5.3");
        assertEquals("Сложение скаляров не работает","7.3",actual.toString());
        actual = parser.calc("B=19.7-3.5");
        assertEquals("Вычитание скаляров не работает","16.2",actual.toString());
        actual = parser.calc("C=-13.2*2.7");
        assertEquals("Умножение скаляров не работает","-35.64",actual.toString());
        actual = parser.calc("D=8/2");
        assertEquals("Деление скаляров не работает","4.0",actual.toString());

    }
}