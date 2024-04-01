import java.util.Scanner;

public class BinaryConverter {
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        int decimal = 0;
        /* Determines whether or not number is binary*/
        for (int i = 0; i < binaryString.length(); i++) {
            char ch = binaryString.charAt(i);
            if (ch == '0' || ch == '1') {
                decimal = decimal * 2 + (ch - '0');
            } else {
                throw new BinaryFormatException("Not a binary number.");
            }
        }
        return decimal;
    }

   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
       /* Gets user input for number*/
    System.out.print("Enter a binary number: ");
    String binaryString = scanner.nextLine();

    try {
        int decimal = bin2Dec(binaryString);
        System.out.println("Decimal equivalent: " + decimal);
    } catch (BinaryFormatException e) {
        System.out.println("Not a binary number.");
    }
   }
}
