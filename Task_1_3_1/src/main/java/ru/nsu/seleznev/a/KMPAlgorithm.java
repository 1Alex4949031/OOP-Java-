package ru.nsu.seleznev.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * -----------------------------------------------------------------------------------
 * Knuth–Morris–Pratt string-searching algorithm(or just KMP algorithm).
 * -----------------------------------------------------------------------------------
 * The time complexity of KMP algorithm is O(n) in the worst case.
 * -----------------------------------------------------------------------------------
 * KMP algorithm is used to find a "Pattern" in a "Text".
 * This algorithm compares character by character from left to right.
 * But whenever a mismatch occurs, it uses a preprocessed table called "Prefix Table"
 * to skip characters comparison while matching.
 * -----------------------------------------------------------------------------------
 * The prefix function of S is the function 𝜋 that maps indices i of S to the length
 * of the longest border of S[1 .. i]. For example if we consider the string "baobaba"
 * then 𝜋(1) = 𝜋(2) = 𝜋(3) = 0, 𝜋(4) = 1, 𝜋(5) = 2, 𝜋(6) = 1 and 𝜋(7) = 2.
 * -----------------------------------------------------------------------------------
 *
 * @author Алексей Селезнев
 * -----------------------------------------------------------------------------------
 */
public class KMPAlgorithm {
  private final InputStream stream;

  /**
   * Constructor for KMP algorithm object.
   *
   * @param stream current input stream
   */
  public KMPAlgorithm(InputStream stream) {
    this.stream = stream;
  }

  /**
   * Prefix Function for algorithm.
   *
   * @param subline current subline
   * @return array type of int with values for each letter.
   */
  public int[] prefixFunction(String subline) {
    int len = subline.length();
    int[] values = new int[len];
    for (int i = 1; i < len; i++) {
      int j = 0;
      while (i + j < len && subline.charAt(i + j) == subline.charAt(j)) {
        values[i + j] = Math.max(values[i + j], j + 1);
        j++;
      }
    }
    return values;
  }

  /**
   * The implementation of Knuth–Morris–Pratt algorithm.
   *
   * @param subline current subline
   * @return array of indexes(type of int) of occurrences
   * of a current substring in the text
   * @throws IOException if there are some troubles with the stream.
   */
  public ArrayList<Integer> algorithmKnuthMorrisPratt(String subline)
      throws IOException {

    Reader reader = new BufferedReader(
        new InputStreamReader(stream, StandardCharsets.UTF_8)
    );

    ArrayList<Integer> result = new ArrayList<>();
    int[] prefixFunction = prefixFunction(subline);
    int sublineLen = subline.length();
    int i = 0;
    int j = 0;

    int newChar = reader.read();
    while (newChar != -1) {
      if ((char) newChar == subline.charAt(j)) {
        newChar = reader.read();
        i++;
        j++;
      }
      if (j == sublineLen) {
        result.add(i - j);
        j = prefixFunction[j - 1];
      } else if (newChar != -1 && subline.charAt(j) != (char) newChar) {
        if (j == 0) {
          newChar = reader.read();
          i++;
        } else {
          j = prefixFunction[j - 1];
        }
      }
    }
    return result;
  }
}
