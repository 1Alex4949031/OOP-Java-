package ru.nsu.seleznev.a.build;

import static ru.nsu.seleznev.a.directories.Directories.copyDirectory;
import static ru.nsu.seleznev.a.directories.Directories.createDirectory;
import static ru.nsu.seleznev.a.directories.Directories.deleteDirectory;
import static ru.nsu.seleznev.a.directories.Directories.writeNewHtmlFile;
import static ru.nsu.seleznev.a.git.GitApi.checkCommitsInPeriod;
import static ru.nsu.seleznev.a.grades.Grades.calculateTotalMark;
import static ru.nsu.seleznev.a.grades.Grades.toStringGrades;
import static ru.nsu.seleznev.a.parser.Parser.parseConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProgressListener;
import ru.nsu.seleznev.a.DSL;
import ru.nsu.seleznev.a.html.HtmlTableBuilder;
import ru.nsu.seleznev.a.model.GivenTask;
import ru.nsu.seleznev.a.model.Lesson;
import ru.nsu.seleznev.a.model.Mark;
import ru.nsu.seleznev.a.model.Task;
import ru.nsu.seleznev.a.xml.JacocoXmlParser;

/**
 * Builder class with main functionality for the application.
 */
public class Builder {
  /**
   * Function that builds all test for laboratory work.
   *
   * @param studentId student's id
   * @param task      task
   * @return true if all tests are built, false otherwise
   * @throws FileNotFoundException exception
   */
  public static boolean buildTests(String studentId, String task)
      throws FileNotFoundException {
    File projectDir = new File("./DSL/git/ID" + studentId + "/" + task);
    if (!projectDir.exists()) {
      throw new FileNotFoundException("No such directory for " + studentId + "."
          + " Did you clone the repository?");
    }
    try (var conn = GradleConnector.newConnector()
        .forProjectDirectory(projectDir).connect()) {
      conn.newBuild().forTasks("test").addProgressListener(
          (ProgressListener) event -> System.out.println(event.getDescription())
      ).run();
    } catch (Exception e) {
      System.out.println("Failed to build tests " + e.getMessage());
      return false;
    }
    try {
      createDirectory("./DSL/test/ID" + studentId + "/" + task);
      copyDirectory(
          projectDir.toPath() + "/build/reports/tests",
          "./DSL/test/ID" + studentId + "/" + task);
      deleteDirectory(projectDir.toPath() + "/build/reports/tests");
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("\nTests were successfully built!\n");
    return true;
  }

  /**
   * Function that generates jacoco test report for laboratory work.
   *
   * @param studentId student's id
   * @param task      task
   * @throws FileNotFoundException exception
   */
  public static void getJacocoTestReport(String studentId, String task)
      throws FileNotFoundException {
    File projectDir = new File("./DSL/git/ID" + studentId + "/" + task);
    if (!projectDir.exists()) {
      throw new FileNotFoundException(
          "Initially build all tests for getting Jacoco Test Report."
              + "Make sure you cloned the repository of the project");
    }
    try {
      createDirectory("./DSL/jacoco/ID" + studentId + "/" + task);
      deleteDirectory(projectDir.toPath() + "/build/test-results/test/binary");

      File[] files = new File(projectDir, "build/test-results/test").listFiles();
      if (files == null || files.length == 0) {
        throw new IllegalStateException(" There are no files to generate Jacoco test report. "
            + "Check jacoco folder.");
      }

      int fileCount = 1;
      for (var file : files) {
        String table = JacocoXmlParser.parseXml(file);
        writeNewHtmlFile("./DSL/jacoco/ID" + studentId + "/"
            + task + "/" + "TestFile" + fileCount, table);
        fileCount++;
      }

      deleteDirectory(projectDir.toPath() + "/build/test-results/test");
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("""
        Jacoco Test Report is generated! Files were created!
        But xml files were deleted! If you want to regenerate report, delete the jacoco folder!
        """);
  }


  /**
   * Function that checks code coverage.
   *
   * @param studentId name of the student
   * @param task      task need to check
   * @return true if java code style was checked successfully, false otherwise
   * @throws FileNotFoundException file not found exception
   */
  public static boolean checkCodeStyle(String studentId, String task) throws FileNotFoundException {
    File dir = new File("./DSL/git/ID" + studentId + "/" + task);
    if (!dir.exists()) {
      throw new FileNotFoundException("No such directory for " + studentId);
    }
    insertCheckStylePlugin(dir);
    checkCheckStyleXml(studentId, task);
    try (var conn = GradleConnector.newConnector().forProjectDirectory(dir)
        .useGradleVersion("8.0").connect()) {
      conn.newBuild().forTasks("checkstyleMain").addProgressListener(
          (ProgressListener) event -> System.out.println(event.getDescription())
      ).run();
    } catch (Exception e) {
      System.out.println(
          "Failed to check Java Code Style!"
              + " Check added plugin in build.gradle of the project!"
              + e.getMessage());
      return false;
    }
    try {
      createDirectory("./DSL/checkstyle/ID" + studentId + "/" + task);
      copyDirectory(
          dir.toPath() + "/build/reports/checkstyle",
          "./DSL/checkstyle/ID" + studentId + "/" + task);
      deleteDirectory(dir.toPath() + "/build/reports/checkstyle");
    } catch (IOException e) {
      throw new RuntimeException("Failed to move files!"
          + "(Operations: createDirectory, copyDirectory, deleteDirectory)");
    }
    System.out.println("\nJava Code Style was successfully checked!\n");
    return true;
  }

  /**
   * Function that checks checkstyle.xml file for Checkstyle plugin.
   *
   * @param studentId student's id
   * @param task      task
   */
  private static void checkCheckStyleXml(String studentId, String task) {
    try {
      File checkStyleXml = new File("./DSL/git/ID" + studentId + "/"
          + task + "/config/checkstyle/checkstyle.xml");
      File configFile = new File("./config/checkstyle/checkstyle.xml");
      if (!checkStyleXml.exists()) {
        checkStyleXml.delete();
      }
      FileUtils.copyFile(configFile, checkStyleXml);
    } catch (IOException e) {
      throw new RuntimeException("Checking checkStyle.xml failed!");
    }
    System.out.println("Checkstyle.xml checked successfully!");
  }

  /**
   * Function that inserts checkstyle plugin
   * for build.gradle file of the project.
   *
   * @param projectDir project directory
   */
  private static void insertCheckStylePlugin(File projectDir) {
    try {
      List<String> plugin = new ArrayList<>(List.of("plugins\n{\nid 'checkstyle'\n}"));
      File buildGradle = new File(projectDir, "build.gradle");
      plugin.addAll(FileUtils.readLines(buildGradle, StandardCharsets.UTF_8));
      FileUtils.writeLines(buildGradle, plugin);
    } catch (IOException e) {
      throw new RuntimeException("Inserting CheckStyle plugin failed!");
    }
    System.out.println("\nCheckStyle plugin was inserted successfully!\n");
  }

  /**
   * Function that generates Java documentation.
   *
   * @param studentId student's id
   * @param task      task
   * @return true if the documentation was generated successfully, false otherwise
   * @throws FileNotFoundException exception
   */
  public static boolean generateJavaDoc(String studentId, String task)
      throws FileNotFoundException {
    File projectDir = new File("./DSL/git/ID" + studentId + "/" + task);
    if (!projectDir.exists()) {
      throw new FileNotFoundException("Project directory not found: " + studentId);
    }
    try (var conn = GradleConnector.newConnector()
        .forProjectDirectory(projectDir).connect()) {
      conn.newBuild().forTasks("javadoc").addProgressListener(
          (ProgressListener) event -> System.out.println(event.getDescription())
      ).run();
    } catch (Exception e) {
      System.out.println("Failed to generate JavaDoc: " + e.getMessage());
      return false;
    }
    try {
      createDirectory("./DSL/documentation/ID" + studentId + "/" + task);
      copyDirectory(
          projectDir.toPath() + "/build/docs/javadoc",
          "./DSL/documentation/ID" + studentId + "/" + task);
      deleteDirectory(projectDir.toPath() + "/build/docs/javadoc");
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("\nJava documentation was generated successfully!\n");
    return true;
  }

  /**
   * Function that generates html report for student.
   *
   * @param studentId student's id
   * @param task      task
   * @throws FileNotFoundException exception
   */
  public static void generateStudentHtml(String studentId, String task)
      throws FileNotFoundException {
    DSL actualDsl = (DSL) parseConfiguration(new File("./DSL/config/ID"
        + studentId + ".groovy"), DSL.class);
    String studentName = actualDsl.getStudent().getName();

    HtmlTableBuilder tableBuilder = new HtmlTableBuilder(
        "Info for student with ID: " + studentId, true);

    tableBuilder.addTableHeader("Student", "Build", "Doc", "Style");
    tableBuilder.addRowValues(studentName,
        checkCondition(Builder.buildTests(studentId, task)),
        checkCondition(Builder.generateJavaDoc(studentId, task)),
        checkCondition(Builder.checkCodeStyle(studentId, task)));
    try {
      createDirectory("./DSL/studentReport/ID" + studentId);
      writeNewHtmlFile("./DSL/studentReport/ID" + studentId
          + "/" + task, tableBuilder.build());
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("\nHtml student report was generated successfully!\n");
  }

  /**
   * Function that generates html group report.
   *
   * @param groupNumber number of the group
   * @throws FileNotFoundException exception
   */
  public static void generateGroupHtml(String groupNumber) throws FileNotFoundException {
    File configDir = new File("./DSL/config/");
    if (!configDir.exists()) {
      throw new FileNotFoundException("There is no config file here!");
    }
    File[] files = configDir.listFiles();
    if (files == null || files.length == 0) {
      throw new IllegalStateException("The directory is empty!");
    }
    HtmlTableBuilder tableBuilder = new HtmlTableBuilder("Group " + groupNumber, true);
    int group = Integer.parseInt(groupNumber);
    Arrays.stream(files).forEach(i -> {
      DSL actualDsl = (DSL) parseConfiguration(i, DSL.class);
      tableBuilder.addTableHeader("StudentID", "Task", "Build", "Doc", "Style");
      if (actualDsl.getGroup().getNumber() == group) {
        List<GivenTask> tasks = actualDsl.getTasks().getTasks();
        tasks.forEach(j -> {
          try {
            String studentId = String.valueOf(actualDsl.getStudent().getId());
            tableBuilder.addRowValues(studentId, j.id(),
                checkCondition(buildTests(studentId, j.id())),
                checkCondition(generateJavaDoc(studentId, j.id())),
                checkCondition(checkCodeStyle(studentId, j.id())));
            getJacocoTestReport(studentId, j.id());
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        });
        List<Mark> marks = actualDsl.getMarks().getMarks();
        List<Task> tasksInfo = actualDsl.getTasksInfo().getTasks();
        tableBuilder.addTableHeader("StudentName", "Credits", "Total Mark");
        double totalMark = calculateTotalMark(marks, tasksInfo);
        String grades = toStringGrades(marks, tasksInfo);
        String studentName = actualDsl.getStudent().getName();
        tableBuilder.addRowValues(studentName, grades, String.valueOf(totalMark));
      }
    });
    try {
      createDirectory("./DSL/groupReport/" + groupNumber);
      writeNewHtmlFile("./DSL/groupReport/" + groupNumber
          + "/" + groupNumber, tableBuilder.build());
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("\nHtml group report was generated successfully!\n");
  }

  /**
   * Function that generates html attendance report for the group.
   *
   * @param studentId student's id
   * @throws FileNotFoundException exception
   */
  public static void generateAttendanceStudentReport(String studentId)
      throws FileNotFoundException {
    File configDir = new File("./DSL/config/");
    File projectRepo = new File("./DSL/git/ID" + studentId);
    if (!configDir.exists() || !projectRepo.exists()) {
      throw new FileNotFoundException("Check that git repo and config files are exist!");
    }
    DSL actualDsl = (DSL) parseConfiguration(new File("./DSL/config/ID"
        + studentId + ".groovy"), DSL.class);
    List<Lesson> lessons = actualDsl.getLessons().getLessonList();
    String studentName = actualDsl.getStudent().getName();
    HtmlTableBuilder tableBuilder = new HtmlTableBuilder(
        "Student with ID: " + studentId, true);
    tableBuilder.addTableHeader("Name", studentName);
    tableBuilder.addRowValues("Date", "Attendance");
    lessons.forEach(l -> {
      try {
        String date = l.date().toString();
        tableBuilder.addRowValues(
            date, checkCondition(checkCommitsInPeriod(projectRepo, l.date())));
      } catch (GitAPIException e) {
        throw new RuntimeException(
            "Something goes wrong with checking commits for attendance");
      }
    });
    try {
      createDirectory("./DSL/studentAttendanceReport");
      writeNewHtmlFile("./DSL/studentAttendanceReport/ID" + studentId, tableBuilder.build());
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("\nHtml attendance report for the student was generated successfully!\n");
  }

  /**
   * Function that generates attendance report for the group.
   *
   * @param groupNumber number of the group
   * @throws FileNotFoundException exception
   */
  public static void generateAttendanceGroupReport(String groupNumber)
      throws FileNotFoundException {
    File configDir = new File("./DSL/config/");
    if (!configDir.exists()) {
      throw new FileNotFoundException("Check that config file exists!");
    }
    File[] files = configDir.listFiles();
    if (files == null || files.length == 0) {
      throw new IllegalStateException("The directory is empty!");
    }
    HtmlTableBuilder tableBuilder = new HtmlTableBuilder("Group " + groupNumber, true);
    int group = Integer.parseInt(groupNumber);
    Arrays.stream(files).forEach(i -> {
      DSL actualDsl = (DSL) parseConfiguration(i, DSL.class);
      tableBuilder.addTableHeader("Name", actualDsl.getStudent().getName());
      tableBuilder.addRowValues("Date", "Attendance");
      if (actualDsl.getGroup().getNumber() == group) {
        List<Lesson> lessons = actualDsl.getLessons().getLessonList();
        lessons.forEach(l -> {
          try {
            File projectDir = new File(
                "./DSL/git/ID" + actualDsl.getStudent().getId());
            String date = l.date().toString();
            tableBuilder.addRowValues(
                date, checkCondition(checkCommitsInPeriod(projectDir, l.date())));
          } catch (GitAPIException e) {
            throw new RuntimeException("Something goes wrong with checking commits for attendance");
          }
        });
      }
    });
    try {
      createDirectory("./DSL/groupAttendanceReport/" + groupNumber);
      writeNewHtmlFile("./DSL/groupAttendanceReport/" + groupNumber
          + "/" + groupNumber, tableBuilder.build());
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("\nHtml attendance report for the group was generated successfully!\n");
  }

  /**
   * Function that returns + if the condition is true, - otherwise.
   *
   * @param cond condition need to check
   * @return + or -
   */
  private static String checkCondition(Boolean cond) {
    return cond ? "+" : "-";
  }
}