package calculatorReversePolishNotation;

import java.util.Stack;

public class Calculator
{
    private final Stack<Integer> stack;

    public Calculator()
    {
        stack = new Stack<Integer>();
    }


    private static boolean isNumber(String input)
    {
        try
        {
            Integer.parseInt(input);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }

    public int calculate(String input)
    {
        String[] equation = input.split(" ");
        for(String c: equation)
        {
            if (isNumber(c))
                stack.push(Integer.parseInt(c));
            else
            {
                int first = stack.pop();
                int second = stack.pop();
                switch (c)
                {
                    case ("+"): stack.push(second + first); break;
                    case ("-"): stack.push(second - first); break;
                    case ("×"):
                    case ("*"): stack.push(second * first); break;
                    case ("÷"):
                    case ("/"): stack.push(second / first); break;
                    default:
                        throw new RuntimeException("I don't now this operation " + c);
                }
            }
        }
        int result = stack.pop();
        stack.clear();
        return result;
    }
}
