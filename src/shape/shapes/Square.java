/**
 * 
 */
package shape.shapes;

import shape.ShapeInfo;
import shape.SideInfo;

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

  @Override
  protected ShapeInfo shapeInfo() {
    ShapeInfo info = new ShapeInfo("square");
    
    info.getSides().add(new SideInfo("side", width));
    info.getSides().add(new SideInfo("side", width));
    info.getSides().add(new SideInfo("side", width));
    info.getSides().add(new SideInfo("side", width));
    
    return info;
  }

}
