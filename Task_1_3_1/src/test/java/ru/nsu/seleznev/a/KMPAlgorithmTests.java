package ru.nsu.seleznev.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The implementation of tests for the correctness of the KMP algorithm.
 * There are some books for tests:
 * 1) Jorj Oruyell - 1984
 * 2) Mihail Bulgakov - Master and Margarita
 */
public class KMPAlgorithmTests {

  @Test
  public void correctPrefixTest() throws IOException {
    try (InputStream file =
             getClass().getClassLoader().getResourceAsStream("CorrectPrefixTest.txt")) {
      assert file != null;
      Scanner scan = new Scanner(file, StandardCharsets.UTF_8);

      String inputFile = scan.nextLine();
      String subline = scan.nextLine();

      try (InputStream stream =
               getClass().getClassLoader().getResourceAsStream(inputFile)) {
        KMPAlgorithm alg = new KMPAlgorithm(stream);
        List<Integer> act = alg.algorithmKnuthMorrisPratt(subline);
        List<Integer> exp = Arrays.asList(0, 5, 7);

        Assertions.assertEquals(exp, act);
        System.out.println("Test1: " + act);
      }
    }
  }

  @Test
  public void exampleTest() throws IOException {
    try (InputStream file =
             getClass().getClassLoader().getResourceAsStream("ExampleTest.txt")) {
      assert file != null;
      Scanner scan = new Scanner(file, StandardCharsets.UTF_8);

      String inputFile = scan.nextLine();
      String subline = scan.nextLine();

      try (InputStream stream =
               getClass().getClassLoader().getResourceAsStream(inputFile)) {
        KMPAlgorithm alg = new KMPAlgorithm(stream);
        List<Integer> act = alg.algorithmKnuthMorrisPratt(subline);
        List<Integer> exp = List.of(7);

        Assertions.assertEquals(exp, act);
        System.out.println("Test2: " + act);
      }
    }
  }

  @Test
  public void queenMasterAndMargaritBulgakovTestBig() throws IOException {
    try (InputStream file =
             getClass().getClassLoader().getResourceAsStream("BulgakovMandMTest.txt")) {
      assert file != null;
      Scanner scan = new Scanner(file, StandardCharsets.UTF_8);

      String inputFile = scan.nextLine();
      String subline = scan.nextLine();

      try (InputStream stream =
               getClass().getClassLoader().getResourceAsStream(inputFile)) {
        KMPAlgorithm alg = new KMPAlgorithm(stream);
        List<Integer> act = alg.algorithmKnuthMorrisPratt(subline);
        List<Integer> exp = Arrays.asList(
            454912, 460804, 462765, 474058, 478030,
            492084, 492182, 492416, 497692, 498007,
            498305, 499211, 500465, 501676, 502705,
            502930, 505151, 505330, 505539, 506459,
            507248, 509250, 510499, 519837, 519859,
            521367, 524925, 525678, 527121, 528261, 535972);

        Assertions.assertEquals(exp, act);
        System.out.println("Test3: " + act);
      }
    }
  }

  @Test
  public void bookMasterAndMargaritBulgakovTestSmall() throws IOException {
    try (InputStream file =
             getClass().getClassLoader().getResourceAsStream("BulgakovMandMTest2.txt")) {
      assert file != null;
      Scanner scan = new Scanner(file, StandardCharsets.UTF_8);

      String inputFile = scan.nextLine();
      String subline = scan.nextLine();

      try (InputStream stream = getClass().getClassLoader().getResourceAsStream(inputFile)) {
        KMPAlgorithm alg = new KMPAlgorithm(stream);
        List<Integer> act = alg.algorithmKnuthMorrisPratt(subline);
        List<Integer> exp = Arrays.asList(221810, 233286, 280963, 717464, 719785, 720064);

        Assertions.assertEquals(exp, act);
        System.out.println("Test4: " + act);
      }
    }
  }

  @Test
  public void book1984JorjOruellTest() throws IOException {
    try (InputStream file =
             getClass().getClassLoader().getResourceAsStream("OruyellTest1984.txt")) {
      assert file != null;
      Scanner scan = new Scanner(file, StandardCharsets.UTF_8);

      String inputFile = scan.nextLine();
      String subline = scan.nextLine();

      try (InputStream stream =
               getClass().getClassLoader().getResourceAsStream(inputFile)) {
        KMPAlgorithm alg = new KMPAlgorithm(stream);
        List<Integer> act = alg.algorithmKnuthMorrisPratt(subline);
        List<Integer> exp = Arrays.asList(88271, 295686, 295734, 296223, 303146);

        Assertions.assertEquals(exp, act);
        System.out.println("Test5: " + act);
      }
    }
  }
}
