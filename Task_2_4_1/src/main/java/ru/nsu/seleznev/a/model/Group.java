package ru.nsu.seleznev.a.model;

import groovy.lang.Closure;
import java.util.Objects;
import ru.nsu.seleznev.a.strings.GroupString;

/**
 * Group class.
 */
public class Group {
  private int number;

  /**
   * Empty constructor.
   */
  public Group() {
  }

  /**
   * Group constructor.
   *
   * @param number number of the group
   */
  public Group(int number) {
    this.number = number;
  }

  /**
   * Function that returns the number of the group.
   *
   * @return number
   */
  public int getNumber() {
    return number;
  }

  /**
   * Group closure for dsl.
   *
   * @param closure block of code with important values
   */
  public void group(Closure<?> closure) {
    GroupString groupString = new GroupString();
    closure.setDelegate(groupString);
    closure.setResolveStrategy(Closure.DELEGATE_ONLY);
    closure.call();
    number = Integer.parseInt(groupString.getGroupNumber());
  }

  /**
   * To String function.
   *
   * @return string value
   */
  @Override
  public String toString() {
    return "Group{" + "number=" + number + '}';
  }

  /**
   * Default equals function.
   *
   * @param o object need to compare with.
   * @return true if objects are equals, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return number == group.number;
  }

  /**
   * Default hashcode function.
   *
   * @return hash code ot the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
