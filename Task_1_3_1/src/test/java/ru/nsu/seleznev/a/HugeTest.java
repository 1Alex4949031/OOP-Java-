package ru.nsu.seleznev.a;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The implementation of the huge file ~10gb. Made in 1m 44sec.
 * Use command:
 * fsutil file createnew C:\...\HugeFileTest.txt 10000000000
 */
public class HugeTest {
  @Test
  public void hugeTest() throws IOException {
    try (InputStream file = getClass().getClassLoader().getResourceAsStream("HugeTest.txt")) {
      assert file != null;
      Scanner scan = new Scanner(file, StandardCharsets.UTF_8);

      String inputFile = scan.nextLine();
      String subline = scan.nextLine();

      try (InputStream stream = getClass().getClassLoader().getResourceAsStream(inputFile)) {
        KnuthMorrisPrattAlgorithm alg = new KnuthMorrisPrattAlgorithm(stream);
        List<Integer> act = alg.algorithmKnuthMorrisPratt(subline);
        List<Integer> exp = new ArrayList<>();

        Assertions.assertEquals(exp, act);
        System.out.println("Test1: " + act);
      }
    }
  }
}
