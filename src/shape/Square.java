/**
 * 
 */
package shape;

/**
 * A square is a rectangle with the constraint that all sides are the same
 * length. In other words, a square is a subset of rectangles. A square is a
 * rectangle but a rectangle is not necessarily a square. This allows the Square
 * to use the {@link Rectangle#area()} and {@link Rectangle#perimeter()} methods
 * (inheritance).
 * 
 * @author Promineo
 *
 */
public class Square extends Rectangle {
  /**
   * Only one length needs to be provided to create a square.
   * 
   * @param side The length of each side.
   */
  public Square(double side) {
    /*
     * Call the Rectangle constructor passing in the same length for each side
     * of the Rectangle.
     */
    super(side, side);
  }

  /**
   * The Square overrides the shapeName method defined in the Rectangle class
   * (polymorphism). This means that when the BaseShape class calls the
   * shapeName method on a Rectangle, the shapeName method in the Rectangle
   * class is called. However, when the shapeName method is called on a Square,
   * the shapeName method in the Square class is called.
   */
  @Override
  protected String shapeName() {
    return "square";
  }

  /**
   * This overrides the shapeInfo method defined in the Rectangle class.
   */
  @Override
  protected String shapeInfo() {
    return "4 sides of which all sides have the same length. The length "
        + "of each side is " + side1;
  }
}
