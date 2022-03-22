/**
 * 
 */
package shape.shapes;

import shape.ShapeInfo;
import shape.Dimension;

/**
 * This is an abstraction of a circle.
 * 
 * @author Promineo
 *
 */
public class Circle extends BaseShape {
  private double radius;

  /**
   * The constructor takes the radius, which is used to calculate the area and
   * perimeter.
   * 
   * @param radius
   */
  public Circle(double radius) {
    this.radius = radius;
  }

  /**
   * Compute the area of the circle: pi * radius^2.
   */
  @Override
  public double area() {
    return Math.PI * radius * radius;
  }

  /**
   * Compute the perimeter (circumference) of the circle: 2 * pi * radius.
   */
  @Override
  public double perimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  protected ShapeInfo shapeInfo() {
    ShapeInfo info = new ShapeInfo("circle");

    info.getDimensions().add(new Dimension("radius", radius));

    return info;
  }

}
