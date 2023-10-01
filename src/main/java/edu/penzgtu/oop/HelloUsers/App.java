package edu.penzgtu.oop.HelloUsers;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Enter username: ");
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();
        System.out.println("Hello " + userName + "!");
    }

}