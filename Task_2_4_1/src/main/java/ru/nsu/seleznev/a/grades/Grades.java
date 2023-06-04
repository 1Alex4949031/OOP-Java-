package ru.nsu.seleznev.a.grades;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ru.nsu.seleznev.a.model.Mark;
import ru.nsu.seleznev.a.model.Task;

public class Grades {
  public static String toStringGrades(List<Mark> marks, List<Task> tasksInfo) {
    return Stream.concat(
            marks.stream().map(mark -> String.valueOf(mark.getMark() * 2)),
            tasksInfo.stream().map(task -> String.valueOf(task.getPoints()))
        )
        .collect(Collectors.joining(" "));
  }

  public static double calculateTotalMark(List<Mark> marks, List<Task> tasksInfo) {
    return (marks.stream().mapToDouble(Mark::getMark).sum()
        + tasksInfo.stream().mapToDouble(Task::getPoints).sum() / 2) / (marks.size() + tasksInfo.size());
  }
}
