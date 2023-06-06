package ru.nsu.seleznev.a.options;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * CommandLineOptions for console application
 */
public class CommandLineOptions {

  /**
   * Function that creates and returns each option for console application.
   *
   * @param name        name of option
   * @param description description of option
   * @param argsCount   number of arguments in the option
   * @return option
   */
  private static Option createOption(String name, String description, int argsCount) {
    Option opt = new Option(name, description);
    opt.setOptionalArg(true);
    opt.setArgs(argsCount);
    return opt;
  }

  /**
   * Function that returns all options for console application.
   *
   * @return options
   */
  public static Options createOptions() {
    Options options = new Options();
    options.addOption(createOption("makeConfig", """
        Make configuration file for student.""", 0));
    options.addOption(createOption("printConfig", """
        Print student's configuration file. Args: [student's id]""", 1));
    options.addOption(createOption("cloneRepo", """
        Cloning student's repository from the Github. Args: [student's id]""", 1));
    options.addOption(createOption("test", """
        Building all tests for laboratory work. Args: [student's id] [task id]""", 2));
    options.addOption(createOption("codeStyle", """
        Check Java Code Style for work. Args: [student's id] [task id]""", 2));
    options.addOption(createOption("documentation", """
        Generate java documentation. Args: [student's id] [task id]""", 2));
    options.addOption(createOption("jacocoTestReport", """
        Generate jacoco test report for task. Args: [student's id] [task id]""", 2));
    options.addOption(createOption("generateHtmlReport", """
        Build task and generate HTML report. Args: [student's id] [task id]""", 2));
    options.addOption(createOption("buildLab", """
        Build Html report for the task. Args: [student's id] [task id]""", 2));
    options.addOption(createOption("buildAll", """
        Build Html report for the group. Args: [group number]""", 1));
    options.addOption(createOption("attendance", """
        Generate attendance report for the student. Args: [student's id]""", 1));
    options.addOption(createOption("attendanceAll", """
        Generate attendance report for all students in the group. Args: [group number]""", 1));
    return options;
  }

  /**
   * Function that creates help menu with common commands.
   *
   * @param options options of console application
   */
  public static void showHelp(Options options) {
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("Own Gradle v1.0", options);
  }
}
