package ru.nsu.seleznev.a;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.Channels;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The implementation of the huge file ~10gb. Made in 1m 44sec.
 * Use command:
 * fsutil file createnew C:\...\HugeFileTest.txt 10000000000
 * echo text>>HugeFileTest.txt
 */
public class HugeTest {
  @Test
  public void hugeTest() throws IOException {
    try (RandomAccessFile f =
             new RandomAccessFile("./src/test/resources/HugeFileTest.txt", "rw")) {
      f.setLength(20000000L);
      f.seek(2341);
      f.writeBytes("test");
      f.seek(12312);
      f.writeBytes("test");
      f.seek(1558188);
      f.writeBytes("test");
      f.seek(0);

      KnuthMorrisPrattAlgorithm alg = new KnuthMorrisPrattAlgorithm(
          Channels.newInputStream(f.getChannel()));
      String subline = "test";

      List<Integer> act = alg.algorithmKnuthMorrisPratt(subline);
      List<Integer> exp = Arrays.asList(2341, 12312, 1558188);

      Assertions.assertEquals(exp, act);
      System.out.println("Test1: " + act);
    }
  }
}
