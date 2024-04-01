import java.util.Scanner;

public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        super();
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    public double getSide1() {
        return side1;
    }
    
    public void setSide1(double side1) {
        this.side1 = side1;
    }
    
    public double getSide2() {
        return side2;
    }
    
    public void setSide2(double side2) {
        this.side2 = side2;
    }
    
    public double getSide3() {
        return side3;
    }
    
    public void setSide3(double side3) {
        this.side3 = side3;
    }
    
    /* Equations for triangle*/
    public double getArea() {
        double s = (side1 + side2 + side3) / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3 + ", " + super.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        /* Prompts user to enter in values for triangle sides, color, and if it's filled*/
        System.out.print("Enter three sides of the triangle: ");
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();

        System.out.print("Enter the color of the triangle: ");
        String color = scanner.next();

        System.out.print("Is the triangle filled? (true/false): ");
        boolean filled = scanner.nextBoolean();

        Triangle triangle = new Triangle(side1, side2, side3, color, filled);

        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled()); 
    }
}

