package ru.nsu.seleznev.a.jsonreader;


import java.util.Objects;

/**
 * JsonCook class for correct parsing of Cooks from Json.
 */
public class JsonCook {
  private final String name;
  private final int experience;

  /**
   * Constructor for JsonCook.
   *
   * @param name       name of the cook
   * @param experience experience of the cook
   */
  public JsonCook(String name, int experience) {
    this.name = name;
    this.experience = experience;
  }

  /**
   * Function that returns name of the cook from Json.
   *
   * @return name of cook
   */
  public String getName() {
    return name;
  }

  /**
   * Function that returns experience of the cook from Json.
   *
   * @return experience of the cook
   */
  public int getExperience() {
    return experience;
  }

  /**
   * Equals function that compares JsonCook objects.
   *
   * @param o object need to compare with
   * @return true if equals, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JsonCook jsonCook = (JsonCook) o;
    return experience == jsonCook.experience
        && Objects.equals(name, jsonCook.name);
  }

  /**
   * Function that counts hash of the object.
   *
   * @return hash of the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, experience);
  }
}
