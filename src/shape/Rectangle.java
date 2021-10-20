/**
 * 
 */
package shape;

/**
 * This class defines a rectangle shape.
 * 
 * @author Promineo
 *
 */
public class Rectangle extends BaseShape {
  protected double side1;
  protected double side2;

  /**
   * Rectangles are 4-sided shapes in which the opposite sides have the same
   * length. The constructor supplies the lengths of the two sides.
   * 
   * @param side1 The length of one side
   * @param side2 The length of the other side
   */
  public Rectangle(double side1, double side2) {
    this.side1 = side1;
    this.side2 = side2;
  }

  /**
   * The area of a rectangle is the product of the lengths of the two adjacent
   * sides.
   */
  @Override
  public double area() {
    return side1 * side2;
  }

  /**
   * The perimeter of a rectangle is the sum of all four sides.
   */
  @Override
  public double perimeter() {
    return (side1 + side2) * 2;
  }

  /**
   * 
   */
  @Override
  protected String shapeName() {
    return "rectangle";
  }

  /**
   * 
   */
  @Override
  protected String shapeInfo() {
    return "4 sides of which opposite sides are equal. Side 1=" + side1
        + ", side 2=" + side2;
  }

}
