/**
 * 
 */
package shape;

/**
 * This class provides information about a side, storing its name and length.
 * For example, a rectangle has two sides: width and height.
 * 
 * @author Promineo
 *
 */
public class SideInfo {
  private String name;
  private double length;

  /**
   * @param name
   * @param length
   */
  public SideInfo(String name, double length) {
    this.name = name;
    this.length = length;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the length
   */
  public double getLength() {
    return length;
  }

  @Override
  public String toString() {
    return "Side [name=" + name + ", length=" + length + "]";
  }

}
