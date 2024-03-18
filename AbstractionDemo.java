abstract class Shape {
  public abstract double calculateArea(); // Abstract method
  public void printDetails() {
    System.out.println("This is a shape."); // Concrete method
  }
}

class Circle extends Shape {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double calculateArea() {
    return Math.PI * radius * radius;
  }
}

public class AbstractionDemo {
  public static void main(String[] args) {
    Shape shape = new Circle(5); // Upcasting - possible with abstract classes
    shape.printDetails(); // Calls concrete method from Shape
    System.out.println("Area of circle: " + shape.calculateArea()); // Calls overridden method from Circle
  }
}