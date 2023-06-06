package ru.nsu.seleznev.a.grades;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ru.nsu.seleznev.a.model.Mark;
import ru.nsu.seleznev.a.model.Task;

/**
 * Grades class.
 */
public class Grades {
  /**
   * Function that creates string grades for html table.
   *
   * @param marks     student's marks
   * @param tasksInfo student's tasks
   * @return string grades
   */
  public static String toStringGrades(List<Mark> marks, List<Task> tasksInfo) {
    return Stream.concat(
            marks.stream().map(mark -> String.valueOf(mark.mark() * 2)),
            tasksInfo.stream().map(task -> String.valueOf(task.points()))
        )
        .collect(Collectors.joining(" "));
  }

  /**
   * Function that calculates total mark.
   *
   * @param marks     student's mark
   * @param tasksInfo student's tasks
   * @return total mark double
   */
  public static double calculateTotalMark(List<Mark> marks, List<Task> tasksInfo) {
    return (marks.stream().mapToDouble(Mark::mark).sum()
        + tasksInfo.stream().mapToDouble(Task::points).sum() / 2) / (marks.size() + tasksInfo.size());
  }
}
