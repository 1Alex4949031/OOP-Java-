package ru.nsu.seleznev.a.config;

import java.io.*;

public class Configuration {
  public void makeConfiguration(String studentId, String studentName, String studentRepo) throws IOException {
    File file = new File("./DSL/config/ID" + studentId + ".groovy");
    if (file.exists()) {
      System.out.println("File with this student already exists!");
    } else {
      file.createNewFile();
      try (FileWriter writer = new FileWriter(file)) {
        writer.write("student " + "{" +
            "id = " + studentId + "\n" +
            "name = " + "\"" + studentName + "\"" + "\n" +
            "repoURL = " + "\"" + studentRepo + "\"" + "\n" +
            "}" + "\n" +
            "group" + "{ \"Write number of the group\" }" + "\n" +
            "tasks" + "{ \"Write some tasks here\" }" + "\n" +
            "marks" + "{ \"Write some marks here\" }" + "\n" +
            "tasksInfo" + "{ \"Write information about the tasks\" }" + "\n" +
            "lessons" + "{ \"Write lessons here\" }"
        );
      }
    }
  }

  public void printConfiguration(String id) throws IOException {
    File file = new File("./DSL/config/ID" + id + ".groovy");
    if (!file.exists()) {
      throw new FileNotFoundException("No such file for: " + id);
    }
    System.out.println("Configuration for student with id: " + id);
    StringBuilder content = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append(System.lineSeparator());
      }
      System.out.println(content);
    }
  }
}
