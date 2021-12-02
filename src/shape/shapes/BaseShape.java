/**
 * 
 */
package shape.shapes;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import shape.Shape;
import shape.ShapeInfo;
import shape.SideInfo;
import java.util.TreeMap;

/**
 * This abstract class implements the Shape interface. This is a convenience class that provides an implementation of
 * the {@link #describe()} method. It declares two other abstract methods: {@link #shapeName()} and
 * {@link #shapeInfo()}. These methods are used to correctly build the text in the {@link #describe()} method.
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
   * Returns information about the shape for the {@link #describe()} method.
   */
  protected abstract ShapeInfo shapeInfo();

  /**
   * Implementation of the describe method declared in {@link Shape}. This calls the {@link #shapeName()},
   * {@link #shapeInfo()}, {@link Shape#area()} and {@link Shape#perimeter()} methods to build the description. Note
   * that this abstract class can declare an abstract method like {@link #shapeName()} and use it without defining a
   * body. This is because the class is abstract, which means that a {@link BaseShape} cannot be created with the new
   * operator.
   */
  @Override
  public List<String> describe() {
    /* Format the area and perimeter as a String with two decimal places. */
    String area = String.format("%.2f", area());
    String perimeter = String.format("%.2f", perimeter());
    ShapeInfo info = shapeInfo();

    String desc = "This shape is a " + info.getName() + ". It has " + info.getSides().size() + " sides:";

    Map<String, Double> sides = dedupeSides(info);

    for (Entry<String, Double> entry : sides.entrySet()) {
      desc += " " + entry.getKey() + "=" + entry.getValue() + ",";
    }

    desc = desc.substring(0, desc.length() - 1) + ".";
    desc += " The perimeter of this " + info.getName() + " is " + perimeter + ".";
    desc += " The area of this " + info.getName() + " is " + area + ".";

    return splitString(desc);
  }

  /**
   * This will "dedupe" the side names. So, a square has four sides but they're all the same. So only one side should be
   * printed.
   * 
   * @param info
   * @return
   */
  private Map<String, Double> dedupeSides(ShapeInfo info) {
    Map<String, Double> sides = new TreeMap<>();

    for (SideInfo side : info.getSides()) {
      sides.put(side.getName(), side.getLength());
    }

    return sides;
  }

  /**
   * Creates a list of String in which each String is at most {@link #MAX_LENGTH} characters in length.
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
   * Finds the point at which to split the String. The String is split at a space so that it is as long as possible but
   * not longer than the given length.
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
