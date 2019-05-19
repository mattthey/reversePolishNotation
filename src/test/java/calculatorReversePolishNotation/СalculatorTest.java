package calculatorReversePolishNotation;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class СalculatorTest
{
    @org.junit.Test
    public void isNumeric() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        Calculator calculator = new Calculator();
        Method isNumeric = null;
        isNumeric = Calculator.class.getDeclaredMethod("isNumber", String.class);
        isNumeric.setAccessible(true);

        assertEquals(isNumeric.invoke(calculator, "2"), true);
        assertEquals(isNumeric.invoke(calculator, "-15"), true);

        assertEquals(isNumeric.invoke(calculator, "+"), false);
        assertEquals(isNumeric.invoke(calculator, "1.5"), false);
    }

    @org.junit.Test
    public void main()
    {
        Calculator calculator = new Calculator();
        assertEquals(calculator.calculate("1 1 +"), 2);
        assertEquals(calculator.calculate("1 -1 +"), 0);
        assertEquals(calculator.calculate("15 7 1 1 + - ÷ 3 × 2 1 1 + + -"), 5);
        assertEquals(calculator.calculate("7 1 -"), 6);
        assertEquals(calculator.calculate("1 2 + 4 × 3 +"), 15);
    }
}
