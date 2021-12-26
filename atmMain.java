import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class atmMain {

    private static final String usern = "Patrick";
    private static final String passw = "r1to20night";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String username = username();
        if (!username.equals(usern)) {
            System.out.print("You have entered your username incorrectly too many times, please try again in 5 minutes");
            return;
        }
        String password = password();
        if (!password.equals(passw)) {
            System.out.print("You have entered your password incorrectly too many times, please try again in 5 minutes");
            return;
        }
        System.out.println("Congratulations, you're successfully signed in");
        System.out.println("");
        main2_0();

    }
    static void main2_0() {
        Transactions trans = new Transactions();

        System.out.println("You currently have $" + trans.getCurrentAmount()+ " in your account");
        System.out.println("");
        Scanner in = new Scanner(System.in);
        message();
        do {
            String response0 = in.nextLine();
            try {
                int response1 = Integer.parseInt(response0);
                if (response1 <= 0 || response1 >= 6) {
                    throw new Num1234Exception(response1);
                }
                else if (response1 == 5) {
                    throw new messengerException(response1);
                }
                else if (response1 == 4) {
                    System.out.print("You have been successfully logged out!");
                    System.exit(0);
                }
                //transactions
                else if (response1 == 1) {
                    deposit();
                }
                else if (response1 == 2) {
                    withdraw();
                }
                else if (response1 == 3) {
                    transactions();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
                System.out.println("If you need to see the list of options again press 5");
            } catch (Num1234Exception e) {
                System.out.print("Please select a number from 1-4");
            } catch (messengerException e) {
                message();
            }
        } while(true);
    }

    public static void deposit() {
        Transactions trans = new Transactions();
        System.out.print("How much would you like to deposit? ");
        Scanner in = new Scanner(System.in);
        do {
            String ans = in.nextLine();
            try {
                Double depAmount = Double.parseDouble(ans);
                if (depAmount <= 0 || depAmount >= 100000){
                    throw new Exception();
                }
                trans.setCurrentAmount(depAmount);

                //gets current method's name
                String methodName = new Object() {}
                        .getClass()
                        .getEnclosingMethod()
                        .getName();
                //gets current date, time, and timezone
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());

                trans.setObj(date, methodName, depAmount);

                System.out.printf("You currently have $%.2f in your account\n", trans.getCurrentAmount());
                System.out.println("Is that all you would like to deposit? (Y/N) ");
                String ans1 = in.nextLine().toUpperCase(Locale.ROOT);
                while (!ans1.equals("Y") && !ans1.equals("N")){
                    System.out.print("Please enter a either Y or N ");
                    ans1 = in.nextLine().toUpperCase(Locale.ROOT);
                }
                if (ans1.equals("N")){
                    withdraw();
                }
                else {
                    System.out.print("Would you like to sign out? ");
                    String ans2 = in.nextLine().toUpperCase(Locale.ROOT);
                    while (!ans2.equals("Y") && !ans2.equals("N")){
                        System.out.print("Please enter a either Y or N ");
                        ans2 = in.nextLine().toUpperCase(Locale.ROOT);
                    }
                    if (ans2.equals("Y")) {
                        System.exit(0);
                    }
                    else {
                        main2_0();
                    }

                }
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a number");
                System.out.println("Your number must be greater than 0");
            } catch (Exception e) {
                System.out.println("The amount you have entered is either a number less than or equal to zero,");
                System.out.println("or a number greater than or equal to $100_000.");
                System.out.println("Please enter a valid amount");
            }
        } while (true);

    }
    private static void withdraw() {
        Transactions trans = new Transactions();
        System.out.print("How much would you like to withdraw? ");
        Scanner in = new Scanner(System.in);
        do {
            String ans = in.nextLine();
            try {
                Double depAmount = Double.parseDouble(ans);
                if (depAmount > trans.getCurrentAmount() || depAmount < 0){
                    throw new Exception();
                }
                trans.setCurrentAmount(0 - depAmount);

                //gets current method's name
                String methodName = new Object() {}
                        .getClass()
                        .getEnclosingMethod()
                        .getName();
                //gets current date, time, and timezone
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());

                trans.setObj(date, methodName, depAmount);

                System.out.printf("You currently have $%.2f in your account\n", trans.getCurrentAmount());
                System.out.println("Is that all you would like to withdraw? (Y/N) ");
                String ans1 = in.nextLine().toUpperCase(Locale.ROOT);
                while (!ans1.equals("Y") && !ans1.equals("N")){
                    System.out.print("Please enter a either Y or N ");
                    ans1 = in.nextLine().toUpperCase(Locale.ROOT);
                }
                if (ans1.equals("N")){
                    withdraw();
                }
                else {
                    System.out.print("Would you like to sign out? ");
                    String ans2 = in.nextLine().toUpperCase(Locale.ROOT);
                    while (!ans2.equals("Y") && !ans2.equals("N")){
                        System.out.print("Please enter a either Y or N ");
                        ans2 = in.nextLine().toUpperCase(Locale.ROOT);
                    }
                    if (ans2.equals("Y")) {
                        System.exit(0);
                    }
                    else {
                        main2_0();
                    }

                }
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
            catch (Exception e) {
                System.out.println("Please enter a valid amount for withdrawal!");
            }
        } while (true);
    }
    private static void transactions() {
        Transactions trans = new Transactions();
        Scanner in = new Scanner(System.in);
        trans.printTransactions();

        System.out.print("Would you like to sign out? ");
        String ans2 = in.nextLine().toUpperCase(Locale.ROOT);
        while (!ans2.equals("Y") && !ans2.equals("N")){
            System.out.print("Please enter a either Y or N ");
            ans2 = in.nextLine().toUpperCase(Locale.ROOT);
        }
        if (ans2.equals("Y")) {
            System.exit(0);
        }
        else {
            main2_0();
        }
    }

    static void message() {
        System.out.println("To deposit money into your account press 1");
        System.out.println("To withdraw money from your account press 2");
        System.out.println("To view past account transactions press 3");
        System.out.println("To logout press 4");
        System.out.println("To view the message again press 5");
    }

    static String password() {
        Scanner in = new Scanner(System.in);
        int attempt = 2;
        System.out.print("Please enter your password: ");
        String password = in.nextLine();
        while(!password.equals(passw) && attempt != 0) {
            attempt--;
            System.out.println("The password provided is incorrect");
            System.out.printf("You have %d attempts left!\n", attempt + 1);
            System.out.print("Please make sure your input has no spaces!");
            password = in.nextLine();
        }
        return password;
    }

    static String username () {
        Scanner in = new Scanner(System.in);
        int attempt = 2;
        System.out.println("Welcome to the atm machine!");
        System.out.print("Please enter your name: ");
        String name = in.nextLine();
        while(!name.equals(usern) && attempt != 0) {
            attempt--;
            System.out.println("The name provided is incorrect");
            System.out.printf("You have %d attempts left!\n", attempt + 1);
            System.out.print("Please make sure your input has no spaces or illegal characters!");
            name = in.nextLine();
        }
        return name;
    }


}

