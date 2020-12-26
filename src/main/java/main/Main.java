package main;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import calculatorReversePolishNotation.Calculator;

public class Main
{
    private static final String FIRST_MSG =
            "Enter an expression in the reverse Polish notation." + System.lineSeparator()
                    + "To exit, enter close()." + System.lineSeparator();
    private static final String ERROR_MSG = "Sorry, I don't understand." + System.lineSeparator();
    private static final String CLOSE_COMMAND = "close()";

    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();
        String input;
        try (var bw = new BufferedOutputStream(System.out);
             var br = new BufferedReader(new InputStreamReader(System.in)))
        {
            while (true)
            {
                bw.write(FIRST_MSG.getBytes(StandardCharsets.UTF_8));
                bw.flush();
                input = br.readLine();
                if (input.equals(CLOSE_COMMAND))
                {
                    break;
                }
                try
                {
                    bw.write((calculator.calculate(input) + System.lineSeparator()).getBytes(StandardCharsets.UTF_8));
                    bw.flush();
                }
                catch (Exception e)
                {
                    bw.write((ERROR_MSG).getBytes(StandardCharsets.UTF_8));
                    bw.flush();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
