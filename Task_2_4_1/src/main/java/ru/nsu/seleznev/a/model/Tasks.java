package ru.nsu.seleznev.a.model;

import groovy.lang.Closure;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ru.nsu.seleznev.a.strings.TaskString;

public class Tasks {
  private List<Task> tasks = new ArrayList<>();

  public Tasks() {
  }

  public Tasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public void taskInfo(Closure<?> closure) {
    TaskString taskString = new TaskString();
    closure.setDelegate(taskString);
    closure.setResolveStrategy(Closure.DELEGATE_ONLY);
    closure.call();
    tasks.add(new Task(taskString.getTaskId(),
        taskString.getTaskName(),
        Integer.parseInt(taskString.getPoints())));
  }

  public List<Task> getTasks() {
    return tasks;
  }

  @Override
  public String toString() {
    return "Tasks{" +
        "tasks=" + tasks +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Tasks tasks1 = (Tasks) o;
    return Objects.equals(tasks, tasks1.tasks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tasks);
  }
}
