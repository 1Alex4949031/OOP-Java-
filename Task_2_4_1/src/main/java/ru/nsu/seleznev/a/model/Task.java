package ru.nsu.seleznev.a.model;


/**
 * Task record class.
 *
 * @param taskId   task id
 * @param taskName task name
 * @param points   task points
 */
public record Task(String taskId, String taskName, int points) {
}
