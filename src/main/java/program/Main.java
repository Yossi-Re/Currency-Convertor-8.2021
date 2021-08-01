package program;

import coin.Coin;
import coin.ILS;
import coin.USD;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to currency converter");
        String s = "Y";
        Scanner chooseOption = new Scanner(System.in);  // Create a Scanner object - chooseOption
        ArrayList<Double> resultList = new ArrayList<>();
        do {

            Coin coin = null;

            s = otherOptionWrongChoice(chooseOption);

            if (s.equals("1")) {
                coin = new ILS();
                System.out.println("Dollars to Shekels");



            } else if (s.equals("2")) {
                coin = new USD();
                System.out.println("Shekels to Dollars");


            }

            double y = notNumericAmount(chooseOption); // Read user input - y = amount to convert
            double result = coin.calculate(y);
            System.out.println(result);
            resultList.add(result);
            s = otherOptionYN(chooseOption);


        }
        while (s.equalsIgnoreCase("y"));
        System.out.println("Thanks for using our currency converter");
        System.out.println(resultList);

        try {

            FileWriter coinText= new FileWriter("C:\\Users\\ereuv\\Desktop\\results.txt");
            coinText.write("These are the converted amounts:\n");
            for (Double amount: resultList){
                coinText.write(amount.toString());
                coinText.write("\n");
            }
            coinText.flush();
            coinText.close();
        } catch (IOException e) {
            System.out.println("Could not create the requested file");
        }


    }

    public static String otherOptionYN(Scanner t) {
        String s = "";
        while (!s.equalsIgnoreCase("y") && (!s.equalsIgnoreCase("n"))) {
            System.out.println("Do you want to start over? Y/N");
            s = t.nextLine();

        }
        return s;

    }

    public static String otherOptionWrongChoice(Scanner t) {
        String s = "";
        while (!s.equalsIgnoreCase("1") && (!s.equalsIgnoreCase("2"))) {
            System.out.println("Please choose an option (1/2)");
            s = t.nextLine();

        }
        return s;

    }

    public static double notNumericAmount(Scanner t) {
        double y = 0;
        boolean correctValue = false;
        while (!correctValue) {
            System.out.println("Please enter an amount to convert: ");
            String amountRead = t.nextLine();
            try {
                y = Double.parseDouble(amountRead);
                correctValue = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }

        }
        return y;
    }
}