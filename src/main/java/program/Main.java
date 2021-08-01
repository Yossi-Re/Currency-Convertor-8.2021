package program;

import builder.CoinFactory;
import builder.Coins;
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
        ArrayList<Result> resultList = new ArrayList<>();
        do {

            Coin coin = null;
            String action = null;

            s = otherOptionWrongChoice(chooseOption);

            if (s.equals("1")) {
                coin = CoinFactory.getCoinInstance(Coins.ILS);
                System.out.println("Dollars to Shekels");
                action="USD to ILS";
            } else if (s.equals("2")) {
                coin = CoinFactory.getCoinInstance(Coins.USD);
                System.out.println("Shekels to Dollars");
                action="ILS to USD";
            } else if(s.equals("3")) {
                coin = CoinFactory.getCoinInstance(Coins.EUR);
                System.out.println("Shekels to EUR");
                action="ILS to EUR";
            }

            double y = notNumericAmount(chooseOption); // Read user input - y = amount to convert
            double resultValue = coin.calculate(y);

            Result result1=new Result(resultValue, action );
            System.out.println(result1);
            resultList.add(result1);
            s = otherOptionYN(chooseOption);

        }
        while (s.equalsIgnoreCase("y"));
        System.out.println("Thanks for using our currency converter");
        System.out.println(resultList);

        try {

            FileWriter coinText= new FileWriter("C:\\Users\\ereuv\\Desktop\\results.txt");
            coinText.write("These are the converted amounts:\n");
            for (Result amount: resultList){
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
        while (!s.equalsIgnoreCase("1") && (!s.equalsIgnoreCase("2")) && (!s.equalsIgnoreCase("3"))) {
            System.out.println("Please choose an option (1/2/3)");
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