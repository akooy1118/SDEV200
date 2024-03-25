import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a credit card number as a long integer: ");
        long number = input.nextLong();

        /** Says whether or not number is valid */
        if (isValid(number)) {
            System.out.println(number + " is valid.");
        } else {
            System.out.println(number + " is invalid.");
        }
    }

    /** Return true if the card number is valid */
    public static boolean isValid(long number) {
        int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        return (sum % 10 == 0);
    }

    /** Return true if the card number is valid */
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);

        for (int i = numStr.length() - 2; i >= 0; i -= 2) {
            int digit = Integer.parseInt(numStr.substring(i, i + 1));
            sum += getDigit(digit * 2);
        }
        return sum;
    }

    /** Return this number if it is a single digit, otherwise,
   * return the sum of the two digits */
    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return number / 10 + number % 10;
        }
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);

        for (int i = numStr.length() - 1; i >= 0; i -= 2) {
           int digit = Integer.parseInt(numStr.substring(i, i + 1));
           sum += digit; 
        }
        return sum;
    }
    //** Return true if the number d is a prefix for number */
    public static boolean prefixMatched(long number, int d) {
        return (getPrefix(number, getSize(d)) == d);
    }

    /** Return the number of digits in d */
    public static int getSize(long d) {
        String numStr = Long.toString(d);
        return numStr.length();
        }
    
     /** Return the first k number of digits from number. If the
   * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k) {
        String numStr = Long.toString(number);
        if (numStr.length() <= k) {
            return number;
        } else {
            return Long.parseLong(numStr.substring(0, k));
        }
    }
}
