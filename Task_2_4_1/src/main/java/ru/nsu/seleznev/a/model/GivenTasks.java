package ru.nsu.seleznev.a.model;

import groovy.lang.Closure;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ru.nsu.seleznev.a.strings.GivenTaskString;

/**
 * GivenTasks class.
 */
public class GivenTasks {
  private List<GivenTask> tasks = new ArrayList<>();

  public List<GivenTask> getTasks() {
    return tasks;
  }

  /**
   * Empty constructor.
   */
  public GivenTasks() {
  }

  /**
   * Constructor.
   *
   * @param tasks tasks
   */
  public GivenTasks(List<GivenTask> tasks) {
    this.tasks = tasks;
  }

  /**
   * Task closure for dsl.
   *
   * @param closure block of code with important values
   */
  public void task(Closure<?> closure) {
    GivenTaskString taskString = new GivenTaskString();
    closure.setDelegate(taskString);
    closure.setResolveStrategy(Closure.DELEGATE_ONLY);
    closure.call();
    tasks.add(new GivenTask(taskString.getId(),
        LocalDate.parse(taskString.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
  }
  /**
   * To String function.
   *
   * @return string value
   */
  @Override
  public String toString() {
    return "GivenTasks{" +
        "tasks=" + tasks +
        '}';
  }
  /**
   * Default equals function.
   *
   * @param o object need to compare with.
   * @return true if objects are equals, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GivenTasks that = (GivenTasks) o;
    return Objects.equals(tasks, that.tasks);
  }
  /**
   * Default hashcode function.
   *
   * @return hash code ot the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(tasks);
  }
}
