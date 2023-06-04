package ru.nsu.seleznev.a.model;

import groovy.lang.Closure;
import java.util.Objects;
import ru.nsu.seleznev.a.strings.GroupString;

public class Group {
  private int number;

  public Group() {
  }

  public Group(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public void group(Closure<?> closure) {
    GroupString groupString = new GroupString();
    closure.setDelegate(groupString);
    closure.setResolveStrategy(Closure.DELEGATE_ONLY);
    closure.call();
    number = Integer.parseInt(groupString.getGroupNumber());
  }

  @Override
  public String toString() {
    return "Group{" +
        "number=" + number +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Group group = (Group) o;
    return number == group.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
