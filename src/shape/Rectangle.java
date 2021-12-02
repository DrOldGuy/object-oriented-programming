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
  protected double width;
  protected double height;

  /**
   * Rectangles are 4-sided shapes in which the opposite sides have the same
   * length. The constructor supplies the lengths of the two sides.
   * 
   * @param width The width of the rectangle
   * @param height The height of the rectangle
   */
  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /**
   * The area of a rectangle is the product of the lengths of the two adjacent
   * sides.
   */
  @Override
  public double area() {
    return width * height;
  }

  /**
   * The perimeter of a rectangle is the sum of all four sides.
   */
  @Override
  public double perimeter() {
    return (width + height) * 2;
  }

  @Override
  protected ShapeInfo shapeInfo() {
    ShapeInfo info = new ShapeInfo("rectangle");
    
    info.getSides().add(new SideInfo("width", width));
    info.getSides().add(new SideInfo("height", height));
    info.getSides().add(new SideInfo("width", width));
    info.getSides().add(new SideInfo("height", height));
    
    return info;
  }

}
