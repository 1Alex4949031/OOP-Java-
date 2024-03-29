package ru.nsu.seleznev.a.jsonreader;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Gson parser for parsing Json file with
 * the values of cooks and couriers, orders, etc.
 */
public class GsonParser {
  private static final File baseFile =
      new File("Pizzeria.json");


  /**
   * CheckFile function that check the existence of the file Pizzeria.json.
   */
  private static void checkFile() {
    if (!baseFile.exists()) {
      try {
        baseFile.createNewFile();
      } catch (IOException e) {
        throw new RuntimeException("Something goes wrong with Json file!");
      }
      System.out.println("Created Pizzeria.json file...\n"
          + "You need to add some information!");
    }
  }

  /**
   * Parse function that parses the Json file.
   *
   * @return values of the Json file
   */
  public JsonValues parse() {
    checkFile();
    JsonValues values;
    Gson gson = new Gson();
    try {
      values = gson.fromJson(Files.newBufferedReader(
          Path.of(baseFile.getPath())), JsonValues.class);
    } catch (IOException e) {
      throw new RuntimeException("Exception connected with reading Json file!");
    }
    if (values == null) {
      throw new RuntimeException("Json file is incorrect!");
    }
    return values;
  }
}
