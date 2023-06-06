package ru.nsu.seleznev.a.model;

import groovy.lang.Closure;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ru.nsu.seleznev.a.strings.TaskString;

/**
 * Tasks class.
 */
public class Tasks {
  private List<Task> tasks = new ArrayList<>();

  /**
   * Empty constructor.
   */
  public Tasks() {
  }

  /**
   * Constructor.
   *
   * @param tasks tasks
   */
  public Tasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  /**
   * TaskInfo closure for dsl.
   *
   * @param closure block of code with important values
   */
  public void taskInfo(Closure<?> closure) {
    TaskString taskString = new TaskString();
    closure.setDelegate(taskString);
    closure.setResolveStrategy(Closure.DELEGATE_ONLY);
    closure.call();
    tasks.add(new Task(taskString.getTaskId(),
        taskString.getTaskName(),
        Integer.parseInt(taskString.getPoints())));
  }

  /**
   * Function that returns all tasks.
   *
   * @return tasks list
   */
  public List<Task> getTasks() {
    return tasks;
  }

  /**
   * To String function.
   *
   * @return string value
   */
  @Override
  public String toString() {
    return "Tasks{" + "tasks=" + tasks + '}';
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
    Tasks tasks1 = (Tasks) o;
    return Objects.equals(tasks, tasks1.tasks);
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
