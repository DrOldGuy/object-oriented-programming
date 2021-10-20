/**
 * 
 */
package shape;

import java.util.LinkedList;
import java.util.List;

/**
 * This abstract class implements the Shape interface. This is a convenience
 * class that provides an implementation of the {@link #describe()} method. It
 * declares two other abstract methods: {@link #shapeName()} and
 * {@link #shapeInfo()}. These methods are used to correctly build the text in
 * the {@link #describe()} method.
 * 
 * @author Promineo
 *
 */
public abstract class BaseShape implements Shape {
  /**
   * The maximum line length in the lines returned by {@link #describe()}.
   */
  private static final int MAX_LENGTH = 60;

  /**
   * This allows the derived class to return the name of the shape that the
   * class implements. It has the protected access modifier so that the method
   * is only visible to a derived class.
   * 
   * @return The name of the shape ("triangle", "square", etc.).
   */
  protected abstract String shapeName();

  /**
   * This is implemented by a derived class to list the number of sides and any
   * other pertinent information.
   * 
   * @return A list of text lines for printing, with the maximum line length of
   *         {@link #MAX_LENGTH}.
   */
  protected abstract String shapeInfo();

  /**
   * Implementation of the describe method declared in {@link Shape}. This calls
   * the {@link #shapeName()}, {@link #shapeInfo()}, {@link Shape#area()} and
   * {@link Shape#perimeter()} methods to build the description. Note that this
   * abstract class can declare an abstract method like {@link #shapeName()} and
   * use it without defining a body. This is because the class is abstract,
   * which means that a {@link BaseShape} cannot be created with the new
   * operator.
   */
  @Override
  public List<String> describe() {
    /* Format the area and perimeter as a String with two decimal places. */
    String area = String.format("%.2f", area());
    String perimeter = String.format("%.2f", perimeter());

    String desc =
        "This shape is a " + shapeName() + ". It has " + shapeInfo() + ".";

    desc += " The perimeter of this " + shapeName() + " is " + perimeter + ".";
    desc += " The area of this " + shapeName() + " is " + area + ".";

    return splitString(desc);
  }

  /**
   * Creates a list of String in which each String is at most
   * {@link #MAX_LENGTH} characters in length.
   * 
   * @param desc
   * @return
   */
  private List<String> splitString(String desc) {
    List<String> lines = new LinkedList<>();

    while (!desc.isEmpty()) {
      int pos = findSplitPoint(desc, MAX_LENGTH);
      lines.add(desc.substring(0, pos));
      desc = desc.substring(Math.min(desc.length(), pos + 1));
    }

    return lines;
  }

  /**
   * Finds the point at which to split the String. The String is split at a
   * space so that it is as long as possible but not longer than the given
   * length.
   * 
   * @param desc The String to split.
   * @param maxLength The maximum length of the split String.
   * @return The point at which to split the String.
   */
  private int findSplitPoint(String desc, int maxLength) {
    int pos = maxLength;

    if (desc.length() <= maxLength) {
      pos = desc.length();
    } else {
      do {
        if (desc.charAt(pos) == ' ') {
          break;
        }

        pos--;
      } while (pos >= 0);
    }

    return pos < 0 ? maxLength : pos;
  }

}
