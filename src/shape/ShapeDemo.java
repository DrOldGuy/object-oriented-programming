/**
 * 
 */
package shape;

import shape.shapes.Circle;
import shape.shapes.Rectangle;
import shape.shapes.Square;
import shape.shapes.Triangle;

/**
 * This is the entry point for the application. It creates some shapes and calls the describe method
 * on each shape.
 * 
 * @author Promineo
 *
 */
public class ShapeDemo {

  /**
   * @param args
   */
  public static void main(String[] args) {
    /*
     * Create a triangle with side lengths 3, 4, and 5. Each shape is assigned to a variable of type
     * Shape. The only methods available on the variable are those defined in the Shape interface.
     * So, even though the abstract class BaseShape defines more abstract methods, they are not
     * visible to a variable of type Shape.
     */
    Shape triangle = new Triangle(3, 4, 5);

    /*
     * The describe method returns a list of description lines that are split according to a maximum
     * length. The forEach method loops through the lines in order. Use a Lambda expression to print
     * the line. In the expression, "line" is a parameter of type String. (The type is inferred
     * because the Java compiler knows that the describe method returns a List of String.) Next,
     * there is the Lambda operator ("->") followed by the expression body. The body simply prints
     * the line to the console.
     */
    triangle.describe().forEach(line -> System.out.println(line));

    System.out.println();

    /*
     * Create a rectangle shape. Each shape has a constructor applicable to the shape. A rectangle
     * has a constructor that sets the dimensions of the two sides. Once the object is created, only
     * the methods on the Shape interface are available.
     */
    Shape rect = new Rectangle(5, 6);
    rect.describe().forEach(line -> System.out.println(line));

    System.out.println();

    /*
     * A square is a rectangle with the constraint that all sides must be the same length. The
     * Square class extends Rectangle and simply provides the same length to each side in the
     * Rectangle constructor. The Square class uses the area and perimeter methods of the Rectangle
     * class (inheritance) but overrides the shapeName and shapeInfo methods (polymorphism).
     */
    Shape square = new Square(4);
    square.describe().forEach(line -> System.out.println(line));

    System.out.println();

    /*
     * The circle does not really have any sides, but it does have a radius. The radius is supplied
     * in the constructor. Note that in this example, the simple Lambda expression is replaced with
     * an even simpler method reference. It does the same thing as the Lambda expression.
     */
    Shape circle = new Circle(8);
    circle.describe().forEach(System.out::println);
  }

}
