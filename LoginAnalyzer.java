import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class LoginAnalyzer {
    public static void main(String[] args) {
        int globalLoginAttempts = 0;
        int account_1_Attempts = 0;
        int account_2_Attempts = 0;
        boolean sessionFlagStatus = false;
        List<String> suspiciousAccounts = new ArrayList<>();
        String username1 = "username1";
        String password1 = "password1";
        String username2 = "username2";
        String password2 = "password2";
        Scanner input = new Scanner(System.in);
        while (globalLoginAttempts < 5) {
            System.out.println("Enter your username");
            String username = input.next();
            System.out.println("Enter your password");
            String password = input.next();
            if (username.equals(username1) && password.equals(password1)) {
                System.out.println("Login Successful");
                if (account_1_Attempts >2) {sessionFlagStatus = true; System.out.println("Your activity has been Flagged");
                    if (!suspiciousAccounts.contains(username1)) {suspiciousAccounts.add(username1);}}
                System.out.println("report:\nsuspicious accounts: " +suspiciousAccounts + "\nSessionFlagStatus:" + sessionFlagStatus);
                System.exit(0);}
            else if (username.equals(username2) && password.equals(password2)) {

                System.out.println("Login Successful");
                if (account_2_Attempts >2) {sessionFlagStatus = true; System.out.println("Your activity has been Flagged");
                    if (!suspiciousAccounts.contains(username2)) {suspiciousAccounts.add(username2);}}
                System.out.println("report:\nsuspicious accounts: " +suspiciousAccounts + "\nSessionFlagStatus:" + sessionFlagStatus);
                System.exit(0);}
            else {
                if(!(globalLoginAttempts == 4)) {System.out.println("Login Failed. Try again");}
                globalLoginAttempts = globalLoginAttempts + 1;
                if (globalLoginAttempts >2) {sessionFlagStatus = true;}
                if (username.equals(username1)) {
                    account_1_Attempts = account_1_Attempts +1;}
                else if (username.equals(username2)) {
                    account_2_Attempts = account_2_Attempts +1;}}
            if (username.equals(username1) && account_1_Attempts >2 && !suspiciousAccounts.contains(username1)) { suspiciousAccounts.add(username1);}
            if (username.equals(username2) && account_2_Attempts >2 && !suspiciousAccounts.contains(username2)) { suspiciousAccounts.add(username2);
            }
        }

        System.out.println("You have failed to login 5 consecutive times. Your activity has been suspended.");
        System.out.println("report:\nsuspicious accounts: " +suspiciousAccounts + "\nSessionFlagStatus:" + sessionFlagStatus);
    }

}

