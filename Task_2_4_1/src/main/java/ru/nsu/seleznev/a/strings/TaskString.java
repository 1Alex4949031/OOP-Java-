package ru.nsu.seleznev.a.strings;


/**
 * TaskString class for reading dsl config.
 */
public class TaskString {
  private String taskId;
  private String taskName;
  private String points;

  /**
   * Empty constructor.
   */
  public TaskString() {

  }

  /**
   * Function that returns task id.
   *
   * @return task id
   */
  public String getTaskId() {
    return taskId;
  }

  /**
   * Function that returns task name.
   *
   * @return task name
   */
  public String getTaskName() {
    return taskName;
  }

  /**
   * Function that returns task points.
   *
   * @return task points
   */
  public String getPoints() {
    return points;
  }
}
