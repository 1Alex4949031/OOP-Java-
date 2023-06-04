package ru.nsu.seleznev.a.model;


import java.util.Objects;

public class Task {
  private String taskId;
  private String taskName;
  private int points;

  public Task(String taskId, String taskName, int points) {
    this.taskId = taskId;
    this.taskName = taskName;
    this.points = points;
  }

  public Task() {
  }

  public String getTaskId() {
    return taskId;
  }

  public String getTaskName() {
    return taskName;
  }

  public int getPoints() {
    return points;
  }

  @Override
  public String toString() {
    return "Task{" +
        "taskId=" + taskId +
        ", taskName='" + taskName + '\'' +
        ", points=" + points +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Task task = (Task) o;
    return Objects.equals(taskId, task.taskId) && points == task.points && Objects.equals(taskName, task.taskName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskId, taskName, points);
  }
}
