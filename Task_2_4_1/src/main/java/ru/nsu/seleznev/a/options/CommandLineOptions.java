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
        Make configuration file""", 0));
    options.addOption(createOption("printConfig", """
        Print student's configuration file""", 1));
    // Дополнить...
    return options;
  }

  /**
   * Function that creates help menu with common commands.
   *
   * @param options options of console application
   */
  public static void showHelp(Options options) {
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("Language ___ v1.0", options);
  }
}
