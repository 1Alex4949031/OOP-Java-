package ru.nsu.seleznev.a.strings;


/**
 * StudentString class for reading dsl config.
 */
public class StudentString {
  private String id;
  private String name;
  private String repoURL;

  /**
   * Empty constructor.
   */
  public StudentString() {
  }

  /**
   * Function that returns student's id.
   *
   * @return student's id
   */
  public String getId() {
    return id;
  }

  /**
   * Function that returns student's name.
   *
   * @return student's name
   */
  public String getName() {
    return name;
  }

  /**
   * Function that returns student's repo url.
   *
   * @return student's repo url
   */
  public String getRepoURL() {
    return repoURL;
  }
}
