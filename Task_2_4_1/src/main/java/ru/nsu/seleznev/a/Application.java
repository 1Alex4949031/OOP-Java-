package ru.nsu.seleznev.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.cli.*;
import ru.nsu.seleznev.a.build.Builder;
import ru.nsu.seleznev.a.config.Configuration;
import ru.nsu.seleznev.a.git.GitApi;
import static ru.nsu.seleznev.a.options.CommandLineOptions.createOptions;

/**
 * Application class.
 */
public class Application {
  private static final String directory = "config";

  /**
   * Main function for the application.
   *
   * @param args arguments
   */
  public static void main(String[] args) {
    File projectDir = new File("./DSL/");
    if (!projectDir.exists()) {
      projectDir.mkdir();
      File subDir = new File(projectDir, directory);
      subDir.mkdir();
      System.out.println("Initial directories were made!");
    }
    try {
      CommandLineParser parser = new DefaultParser();
      Options options = createOptions();
      CommandLine commandLine = parser.parse(options, args);
      if (commandLine.hasOption("makeConfig")) {
        makeConfiguration();
      }
      if (commandLine.hasOption("printConfig")) {
        printConfiguration();
      }
      if (commandLine.hasOption("cloneRepo") && args.length == 2) {
        cloneRepository(commandLine);
      }
      if (commandLine.hasOption("test") && args.length == 3) {
        buildTests(commandLine);
      }
      if (commandLine.hasOption("codeStyle") && args.length == 3) {
        checkCodeStyle(commandLine);
      }
      if (commandLine.hasOption("documentation") && args.length == 3) {
        generateDocumentation(commandLine);
      }
      if (commandLine.hasOption("jacocoTestReport") && args.length == 3) {
        generateJacocoTestReport(commandLine);
      }
      if (commandLine.hasOption("buildLab") && args.length == 3) {
        generateHtmlStudentReport(commandLine);
      }
      if (commandLine.hasOption("buildAll") && args.length == 2) {
        generateHtmlGroupReport(commandLine);
      }
      if (commandLine.hasOption("attendance") && args.length == 2) {
        generateHtmlAttendanceStudentReport(commandLine);
      }
      if(commandLine.hasOption("attendanceAll") && args.length == 2){
        generateHtmlAttendanceGroupReport(commandLine);
      }
    } catch (ParseException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Function that generates html attendance report for group.
   *
   * @param commandLine command line with arguments
   */
  private static void generateHtmlAttendanceGroupReport(CommandLine commandLine) throws FileNotFoundException {
    String[] args = commandLine.getOptionValues("attendanceAll");
    Builder.generateAttendanceGroupReport(args[0]);
  }

  /**
   * Function that generates html attendance report.
   *
   * @param commandLine command line with arguments
   * @throws FileNotFoundException file not found exception
   */
  private static void generateHtmlAttendanceStudentReport(CommandLine commandLine) throws FileNotFoundException {
    String[] args = commandLine.getOptionValues("attendance");
    Builder.generateAttendanceStudentReport(args[0]);
  }

  /**
   * Function that builds all laboratory works for students in one group.
   *
   * @param commandLine command line with arguments
   * @throws FileNotFoundException file not found exception
   */
  private static void generateHtmlGroupReport(CommandLine commandLine) throws FileNotFoundException {
    String[] args = commandLine.getOptionValues("buildAll");
    Builder.generateGroupHtml(args[0]);
  }

  /**
   * Function that builds laboratory work for student
   * and generates html report.
   *
   * @param commandLine command line with arguments
   * @throws IOException InputOutput exception
   */
  private static void generateHtmlStudentReport(CommandLine commandLine) throws IOException {
    String[] args = commandLine.getOptionValues("buildLab");
    Builder.generateStudentHtml(args[0], args[1]);
  }

  /**
   * Function that generates Jacoco test report.
   *
   * @param commandLine command line with arguments
   * @throws IOException InputOutput exception
   */
  private static void generateJacocoTestReport(CommandLine commandLine) throws IOException {
    String[] args = commandLine.getOptionValues("jacocoTestReport");
    Builder.getJacocoTestReport(args[0], args[1]);
  }

  /**
   * Function that generates Java documentation.
   *
   * @param commandLine command line with arguments
   * @throws IOException InputOutput exception
   */
  private static void generateDocumentation(CommandLine commandLine) throws IOException {
    String[] args = commandLine.getOptionValues("documentation");
    Builder.generateJavaDoc(args[0], args[1]);
  }

  /**
   * Not working yet.
   *
   * @param commandLine command line with arguments
   * @throws FileNotFoundException file not found exception
   */
  private static void checkCodeStyle(CommandLine commandLine) throws FileNotFoundException {
    String[] args = commandLine.getOptionValues("codeStyle");
    Builder.checkCodeStyle(args[0], args[1]);
  }

  /**
   * Function that clones student's repository.
   *
   * @param commandLine command line with arguments
   * @throws IOException InputOutput exception
   */
  private static void cloneRepository(CommandLine commandLine) throws IOException {
    String[] args = commandLine.getOptionValues("cloneRepo");
    GitApi gitApi = new GitApi();
    gitApi.cloneRepository(args[0]);
  }

  /**
   * Function that makes the initial configuration for student.
   *
   * @throws IOException InputOutput exception
   */
  private static void makeConfiguration() throws IOException {
    Scanner scan = new Scanner(System.in);
    System.out.println("Write student's ID ");
    String studentID = scan.nextLine();
    System.out.println("Write student's name: ");
    String studentName = scan.nextLine();
    System.out.println("Write student's URL on Github.com: ");
    String studentURL = scan.nextLine();
    Configuration config = new Configuration();
    config.makeConfiguration(studentID, studentName, studentURL);
  }

  /**
   * Function that prints the configuration for student.
   *
   * @throws IOException InputOutput exception
   */
  private static void printConfiguration() throws IOException {
    Scanner scan = new Scanner(System.in);
    System.out.println("Write student's id: ");
    String studentId = scan.nextLine();
    Configuration config = new Configuration();
    config.printConfiguration(studentId);
  }

  /**
   * Function that builds all test for student's project.
   *
   * @param commandLine command line with arguments
   * @throws FileNotFoundException file not found exception
   */
  private static void buildTests(CommandLine commandLine) throws FileNotFoundException {
    String[] args = commandLine.getOptionValues("test");
    Builder.buildTests(args[0], args[1]);
  }
}

