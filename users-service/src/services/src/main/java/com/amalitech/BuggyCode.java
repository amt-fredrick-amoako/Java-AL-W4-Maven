package com.amalitech;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class BuggyCode
{
    public static final String NAME = "Name; ";
    public int multiply(int firstNumber, int secondNumber){
        return firstNumber * secondNumber;
    }

    public int subtract(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }

    public static int divide(int firstNumber, int secondNumber){
        return firstNumber / secondNumber;
    }

    public static String readName(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        return NAME.concat(input);
    }

    public static void main(String[] args) {
        System.out.println(readName());

        System.out.println(divide(1, 0));
    }
}
