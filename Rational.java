import java.math.BigInteger;
import java.util.Scanner;

public class Rational extends Number implements Comparable<Rational>{
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = (denominator.compareTo(BigInteger.ZERO) > 0 ? BigInteger.ONE : BigInteger.ONE.negate()).multiply(numerator).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }

    public BigInteger getNumerator() {
        return numerator;
    }
    public BigInteger getDenominator() {
        return denominator;
    }

    public Rational add(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    public Rational subtract(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }
 
    public Rational multiply(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    public Rational divide(Rational secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    public String toString() {
        if (denominator.equals(BigInteger.ONE))
            return numerator.toString() + " ";
        else
            return numerator.toString() + "/" + denominator.toString();
    }

    public boolean equals(Object other) {
        if ((this.subtract((Rational)(other))).getNumerator().equals(BigInteger.ZERO))
            return true;
        else
            return false;
    }

    public int intValue() {
        return (int)doubleValue();
    }

    public float floatValue() {
        return (float)doubleValue();
    }

    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    public long longValue() {
        return (long)doubleValue();
    }

    public int compareTo(Rational o) {
        if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0)
            return 1;
        else if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) < 0)
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first rational number: ");
        String[] fraction1 = input.nextLine().split(" ");
        BigInteger numerator1 = new BigInteger(fraction1[0]);
        BigInteger denominator1 = new BigInteger(fraction1[1]);

        System.out.print("Enter the second rational number: ");
        String[] fraction2 = input.nextLine().split(" ");
        BigInteger numerator2 = new BigInteger(fraction2[0]);
        BigInteger denominator2 = new BigInteger(fraction2[1]);

        Rational rational1 = new Rational(numerator1, denominator1);
        Rational rational2 = new Rational(numerator2, denominator2);

        Rational sum = rational1.add(rational2);
        Rational difference = rational1.subtract(rational2);
        Rational product = rational1.multiply(rational2);
        Rational quotient = rational1.divide(rational2);

        System.out.println(rational1 + " + " + rational2 + " = " + sum);
        System.out.println(rational1 + " - " + rational2 + " = " + difference);
        System.out.println(rational1 + " * " + rational2 + " = " + product);
        System.out.println(rational1 + " / " + rational2 + " = " + quotient);

        input.close();
        }
 }

