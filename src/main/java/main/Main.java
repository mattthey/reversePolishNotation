package main;

import java.util.Scanner;

import calculatorReversePolishNotation.Calculator;

public class Main
{
    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();
        String input;
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            System.out.println("Enter an expression in the reverse Polish notation");
            System.out.println("To exit, enter close()");
            input = sc.nextLine();
            if (input.equals("close()"))
                break;
            try
            {
                System.out.println(calculator.calculate(input));
            }
            catch (Exception e)
            {
                System.out.println("sorry, I don't understand");
            }
        }
    }
}
