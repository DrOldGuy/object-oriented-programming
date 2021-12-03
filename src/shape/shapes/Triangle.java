/**
 * 
 */
package shape.shapes;

import shape.ShapeInfo;
import shape.SideInfo;

/**
 * This class defines a triangular shape. Note the object-oriented principle of
 * abstraction: for the purposes of this class it is not necessary to know the
 * angles of the triangle. So, only the line lengths are stored.
 * 
 * @author Promineo
 *
 */
public class Triangle extends BaseShape {
  private double a;
  private double b;
  private double c;

  /**
   * Create a {@link Triangle} object.
   * 
   * @param a The length of side 1
   * @param b The length of side 2
   * @param c The length of side 3
   */
  public Triangle(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  /**
   * This uses Heron's formula to calculate the area of the Triangle without
   * knowing the height and base.
   */
  @Override
  public double area() {
    double p = perimeter() / 2.0;
    double pa = p - a;
    double pb = p - b;
    double pc = p - c;

    return Math.sqrt(p * pa * pb * pc);
  }

  /**
   * The perimeter of a triangle is the sum of the length of its sides.
   */
  @Override
  public double perimeter() {
    return a + b + c;
  }

  @Override
  protected ShapeInfo shapeInfo() {
    ShapeInfo info = new ShapeInfo("triangle");

    info.getSides().add(new SideInfo("a", a));
    info.getSides().add(new SideInfo("b", b));
    info.getSides().add(new SideInfo("c", c));

    return info;
  }
}
