package ru.nsu.seleznev.a.model;

import groovy.lang.Closure;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import ru.nsu.seleznev.a.strings.StudentString;


/**
 * Student class.
 */
public class Student {
  private int id;
  private String name;
  private URL repoURL;

  /**
   * Constructor.
   *
   * @param id      student's id
   * @param name    student's name
   * @param repoUrl student's repository url
   */
  public Student(int id, String name, URL repoUrl) {
    this.id = id;
    this.name = name;
    this.repoURL = repoUrl;
  }

  /**
   * Empty constructor.
   */
  public Student() {
  }

  /**
   * Function that returns student's id.
   *
   * @return student's id
   */
  public int getId() {
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
   * Function that returns student's repository url.
   *
   * @return repo url
   */
  public URL getRepoUrl() {
    return repoURL;
  }

  /**
   * Student closure for dsl.
   *
   * @param closure block of code with important values
   */
  public void student(Closure<?> closure) throws MalformedURLException {
    StudentString studentString = new StudentString();
    closure.setDelegate(studentString);
    closure.setResolveStrategy(Closure.DELEGATE_ONLY);
    closure.call();

    id = Integer.parseInt(studentString.getId());
    name = studentString.getName();
    repoURL = new URL(studentString.getRepoUrl());
  }

  /**
   * To String function.
   *
   * @return string value
   */
  @Override
  public String toString() {
    return "Student{" + "id=" + id
        + ", name='" + name + '\''
        + ", repoURL=" + repoURL + '}';
  }

  /**
   * Default equals function.
   *
   * @param o object need to compare with.
   * @return true if objects are equals, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return id == student.id && Objects.equals(name, student.name) && Objects.equals(repoURL, student.repoURL);
  }

  /**
   * Default hashcode function.
   *
   * @return hash code ot the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, name, repoURL);
  }
}
