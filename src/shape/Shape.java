/**
 * 
 */
package shape;

import java.util.List;

/**
 * This interface provides a functional contract with all implementing classes.
 * In other words, classes that implement the Shape interface *MUST* declare
 * method bodies for each method defined in this interface. Any class that
 * implements this interface that does *not* declare all method bodies must be
 * abstract. Methods defined in interfaces are automatically defined as public
 * and abstract.
 * 
 * @author Promineo
 *
 */
public interface Shape {
  /**
   * @return the area of the shape.
   */
  double area();

  /**
   * @return the perimeter of the shape.
   */
  double perimeter();

  /**
   * Creates a description of the shape with the area, perimeter, number of
   * sides, etc.
   * 
   * @return A list of text Strings that can be printed.
   */
  List<String> describe();
}
