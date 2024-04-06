import java.util.Comparator;
import java.util.Arrays;

public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public Circle() {   
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public int compareTo(Circle other) {
        if (this.radius < other.radius) {
            return -1;
        } else if (this.radius > other.radius) {
            return 1;
        }
        return 0;
    } 
    
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } 
        if (!(obj instanceof Circle)) {
            return false;
        }
        Circle other = (Circle) obj;
        return Double.compare(this.radius, other.radius) == 0;
    }


    public void printCircle() {
        System.out.println("The circle is created: " + getDateCreated() +
        " and the radius is " + radius);
     }
   
    public static void main(String[] args) {
        Circle[] circles = {
            new Circle(5.0),
            new Circle(3.5),
            new Circle(7.2)
        };
        Arrays.sort(circles);

        for (Circle circle : circles) {
            circle.printCircle();
        }
    }
}
