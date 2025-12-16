package com.keno.solo;

import java.util.Scanner;

public class App 
{
    public static void main(String[] args) 
    { 
       Scanner scanner = new Scanner(System.in);
       System.out.println("Input number!");
       int col = scanner.nextInt();
       System.out.println("Number is " + col);
    }
}