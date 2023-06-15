package ru.nsu.seleznev.a.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

/**
 * Configuration class.
 */
public class Configuration {
  /**
   * Function that makes initial config for the student.
   *
   * @param studentId   student's id
   * @param studentName student's name
   * @param studentRepo student's repository
   * @throws FileAlreadyExistsException exception
   */
  public void makeConfiguration(String studentId, String studentName, String studentRepo)
      throws FileAlreadyExistsException {
    File file = new File("./DSL/config/ID" + studentId + ".groovy");
    if (file.exists()) {
      throw new FileAlreadyExistsException("File with this student already exists!");
    } else {
      try {
        file.createNewFile();
        try (FileWriter writer = new FileWriter(file)) {
          writer.write("student "
              + "{" + "id = " + studentId + "\n"
              + "name = " + "\"" + studentName + "\"" + "\n"
              + "repoURL = " + "\"" + studentRepo + "\"" + "\n"
              + "}" + "\n" + "group" + "{ \"Write number of the group\" }" + "\n"
              + "tasks" + "{ \"Write some tasks here\" }" + "\n"
              + "marks" + "{ \"Write some marks here\" }" + "\n"
              + "tasksInfo" + "{ \"Write information about the tasks\" }" + "\n"
              + "lessons" + "{ \"Write lessons here\" }"
          );
        }
      } catch (IOException e) {
        throw new RuntimeException("Couldn't make files for configuration!");
      }
      System.out.println("Configuration was made successfully!");
    }
  }

  /**
   * Function that prints configuration for the student.
   *
   * @param id student's id
   * @throws FileNotFoundException exception
   */
  public void printConfiguration(String id) throws FileNotFoundException {
    File file = new File("./DSL/config/ID" + id + ".groovy");
    if (!file.exists()) {
      throw new FileNotFoundException("No such file for student with ID: " + id);
    }
    System.out.println("Configuration for student with id: " + id);
    StringBuilder content = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append(System.lineSeparator());
      }
      System.out.println(content);
    } catch (IOException e) {
      throw new RuntimeException("Something goes wrong with reading config file!");
    }
  }
}
