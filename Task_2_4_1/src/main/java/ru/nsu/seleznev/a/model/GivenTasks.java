package ru.nsu.seleznev.a.model;

import groovy.lang.Closure;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ru.nsu.seleznev.a.strings.GivenTaskString;

public class GivenTasks {
  private List<GivenTask> tasks = new ArrayList<>();

  public List<GivenTask> getTasks() {
    return tasks;
  }

  public GivenTasks() {
  }

  public GivenTasks(List<GivenTask> tasks) {
    this.tasks = tasks;
  }

  public void task(Closure<?> closure) {
    GivenTaskString taskString = new GivenTaskString();
    closure.setDelegate(taskString);
    closure.setResolveStrategy(Closure.DELEGATE_ONLY);
    closure.call();
    tasks.add(new GivenTask(taskString.getId(),
        LocalDate.parse(taskString.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
  }

  @Override
  public String toString() {
    return "GivenTasks{" +
        "tasks=" + tasks +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GivenTasks that = (GivenTasks) o;
    return Objects.equals(tasks, that.tasks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tasks);
  }
}
