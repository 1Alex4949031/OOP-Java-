package ru.nsu.seleznev.a;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * NoteBook class implementation.
 * Console application that creates
 * JSON file with notes.
 * User can use this commands:
 *  1) -add nodeTitle nodeDescription
 *  For example: -add "Train" "I want to train more!"
 *  Usage: Adds the note to the NoteBook
 *  2) -remove nodeTitle
 *  For example: -remove "Illness" "I'm ill!"
 *  Usage: Removes the note from the NoteBook
 *  3) -show
 *  Usage: Shows all notes in the NoteBook
 *  4) -show TimeA TimeB subStr1,...,subStrN
 *  Usage: Shows all notes in the NoteBook with
 *  parameters: note created in a period (TimeA, TimeB)
 *  with substrings in title subStr1,...,subStrN. N is a Natural.
 *  Make Jar and try it!
 */
public class NoteBook {

  private static Map<LocalDateTime, Note> noteBook;
  public static final File baseFile = new File("NoteBook.json");

  /**
   * Add note function that adds current note to the Json file:
   * -add nodeTitle nodeDescription.
   *
   * @param commandLine command line with arguments and options
   */
  private static void addNote(CommandLine commandLine) {
    String[] args = commandLine.getOptionValues("add");
    Note note = new Note(args[0], args[1]);
    noteBook.put(LocalDateTime.now(), note);
  }

  /**
   * Remove note function that removes current note
   * from the Json file:
   * -remove noteTitle.
   *
   * @param commandLine command line with arguments and options
   */
  private static void removeNote(CommandLine commandLine) {
    String[] args = commandLine.getOptionValues("remove");
    for (Map.Entry<LocalDateTime, Note> entry : noteBook.entrySet()) {
      if (entry.getValue().title().equals(args[0])) {
        noteBook.remove(entry.getKey());
        break;
      }
    }
  }

  /**
   * Function that show all notes in the NoteBook in
   * different ways.
   * To show all notes:
   * -show
   * To show notes with parameters:
   * -show TimeA TimeB subStr1,...,subStrN (check description).
   *
   * @param commandLine command line with arguments and options
   * @throws JsonProcessingException exception for all problems encountered when processing (parsing, generating) JSON
   */
  private static void showNote(CommandLine commandLine) throws JsonProcessingException {
    String[] args = commandLine.getOptionValues("show");
    ObjectMapper mapper = new ObjectMapper();
    if (args == null) {
      System.out.print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(noteBook));
    } else {
      String[] subStrings = Arrays.copyOfRange(args, 2, args.length);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
      LocalDateTime start = LocalDateTime.parse(args[0], formatter);
      LocalDateTime end = LocalDateTime.parse(args[1], formatter);
      TreeMap<LocalDateTime, Note> notesToWrite = new TreeMap<>();
      for (Map.Entry<LocalDateTime, Note> entry : noteBook.entrySet()) {
        if (entry.getKey().isAfter(start)
            && entry.getKey().isBefore(end)
            && Arrays.stream(subStrings)
            .filter(i -> entry.getValue().title().contains(i)).count() == subStrings.length) {
          notesToWrite.put(entry.getKey(), entry.getValue());
        }
      }
      System.out.print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(notesToWrite));
    }
  }

  /**
   * Function that checks the existence of the Json file.
   *
   * @throws IOException exception connected with input or output
   */
  private static void checkFile() throws IOException {
    if (!baseFile.exists()) {
      if(!baseFile.createNewFile()){
        throw new RuntimeException("Unable to create file");
      }
      PrintWriter writer = new PrintWriter(baseFile);
      writer.write("{}");
      writer.close();
    }
  }

  /**
   * Function that writes Json objects to the file.
   *
   * @throws IOException exception connected with input or output
   */
  private static void writeJsonObjects() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(baseFile, noteBook);
  }

  /**
   * Function that reads Json objects to the file.
   *
   * @throws IOException exception connected with input or output
   */
  private static void readJsonObjects() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    TypeReference<TreeMap<LocalDateTime, Note>> typeRef = new TypeReference<>() {
    };
    noteBook = mapper.readValue(baseFile, typeRef);
  }

  /**
   * Function that creates help menu with common commands.
   *
   * @param options options of console application
   */
  private static void showHelp(Options options) {
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("NoteBook v1.0", options);
  }

  /**
   * Function that returns all options for console application.
   *
   * @return options
   */
  private static Options createOptions() {
    Options options = new Options();
    options.addOption(createOption("add", """
        This operation has 2 arguments.
        Usage: Adds your note to the Notebook.""", 2));
    options.addOption(createOption("remove", """
        This operation has 1 arguments.
        Usage: Removes your note from the Notebook.""", 1));
    options.addOption(createOption("show", """
            This operation has 2 variants of usage.
            1) -show
            Usage: Shows all records in the Notebook.
            2) -show "dd.MM.yyyy HH:mm" "dd.MM.yyyy HH:mm" + unlimited amount of arguments:
            substrings of the title of any note in the Notebook!
            Usage: Shows all records in the Notebook in current period with substrings included.""",
        Option.UNLIMITED_VALUES));
    options.addOption(createOption("help",
        "Usage: Shows all commands for the Notebook.\n" +
            "Try it!", 0));
    return options;
  }

  /**
   * Function that creates and returns each option for console application.
   *
   * @param name name of option
   * @param description description of option
   * @param argsCount number of arguments in the option
   * @return option
   */
  private static Option createOption(String name, String description, int argsCount) {
    Option opt = new Option(name, description);
    opt.setOptionalArg(true);
    opt.setArgs(argsCount);
    return opt;
  }

  /**
   * Main function with the whole logic of application.
   *
   * @param args arguments of the command line
   */
  public static void main(String[] args) {
    try {
      checkFile();
      readJsonObjects();
      CommandLineParser parser = new DefaultParser();
      Options options = createOptions();
      CommandLine commandLine = parser.parse(options, args);
      if (commandLine.hasOption("add")
          && args.length == 3) {
        addNote(commandLine);
      } else if (commandLine.hasOption("remove")
          && args.length == 2) {
        removeNote(commandLine);
      } else if (commandLine.hasOption("show")
          && ((args.length == 1) || (args.length > 2))) {
        showNote(commandLine);
      } else if (commandLine.hasOption("help")) {
        showHelp(options);
      } else {
        showHelp(options);
      }
      writeJsonObjects();
    } catch (IOException | ParseException e) {
      throw new IllegalArgumentException("Incorrect data!");
    }
  }
}