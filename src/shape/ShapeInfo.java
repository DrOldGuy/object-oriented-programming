/**
 * 
 */
package shape;

import java.util.LinkedList;
import java.util.List;

/**
 * This class allows a shape class to provide a description about itself.
 * 
 * @author Promineo
 *
 */
public class ShapeInfo {
  private String name;
  private final List<Dimension> dimensions = new LinkedList<>();

  public ShapeInfo(String shapeName) {
    this.name = shapeName;
  }

  /**
   * @return the shape name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the sideInfo
   */
  public List<Dimension> getDimensions() {
    return dimensions;
  }

  /**
   * 
   */
  @Override
  public String toString() {
    return "ShapeInfo [name=" + name + ", dimensions=" + dimensions + "]";
  }
}
