/**
 * 
 */
package shape;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Promineo
 *
 */
public class ShapeInfo {
  private String name;
  private List<SideInfo> sides = new LinkedList<>();

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
  public List<SideInfo> getSides() {
    return sides;
  }

  /**
   * 
   */
  @Override
  public String toString() {
    return "ShapeInfo [name=" + name + ", sides=" + sides + "]";
  }
}
