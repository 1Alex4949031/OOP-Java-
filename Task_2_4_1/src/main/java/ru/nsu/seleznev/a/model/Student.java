package ru.nsu.seleznev.a.model;

import groovy.lang.Closure;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Objects;
import ru.nsu.seleznev.a.strings.StudentString;

public class Student {
  private int id;
  private String name;
  private URL repoURL;

  public Student(int id, String name, URL repoURL) {
    this.id = id;
    this.name = name;
    this.repoURL = repoURL;
  }

  public Student() {
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public URL getRepoURL() {
    return repoURL;
  }

  public void student(Closure<?> closure) throws MalformedURLException {
    StudentString studentString = new StudentString();
    closure.setDelegate(studentString);
    closure.setResolveStrategy(Closure.DELEGATE_ONLY);
    closure.call();

    id = Integer.parseInt(studentString.getId());
    name = studentString.getName();
    repoURL = new URL(studentString.getRepoURL());
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", repoURL=" + repoURL +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return id == student.id && Objects.equals(name, student.name) && Objects.equals(repoURL, student.repoURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, repoURL);
  }
}
