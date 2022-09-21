package ru.nsu.a.seleznev;

/**
 * HeapSort class.
 *
 * @author Алексей Селезнев
 */
public class HeapSort {
  /**
   * Making default swap function.
   *
   * @param arr array
   * @param a   value need to swap
   * @param b   value need to swap
   */

  public static void swap(int[] arr, int a, int b) {
    int buff;
    buff = arr[a];
    arr[a] = arr[b];
    arr[b] = buff;
  }

  /**
   * Finding max-heap,
   * Checking the sons of the current root,
   * trying to the biggest one.
   *
   * @param arr array
   * @param len the length of array
   * @param i   index
   */

  public static void heap(int[] arr, int len, int i) {
    int largest = i;
    int r = i * 2 + 2;
    int l = i * 2 + 1;

    if (l < len && arr[l] > arr[largest]) {
      largest = l;
    }
    if (r < len && arr[r] > arr[largest]) {
      largest = r;
    }
    if (i != largest) {
      swap(arr, i, largest);
      heap(arr, len, largest);
    }
  }

  /**
   * 1. Getting the max-heap tree.
   * 2. Changing the root and the last element of the heap.
   * Then make the heap smaller by decreasing by 1. Getting
   * the max-heap with the new root.
   * 3. Start with the 1 sentence while size of heap more than 1.
   *
   * @param arr array
   */

  public static int[] heapsort(int[] arr) {
    int len = arr.length;

    for (int i = len / 2 - 1; i >= 0; i--) {
      heap(arr, len, i);
    }
    for (int i = len - 1; i > 0; i--) {
      swap(arr, 0, i);
      heap(arr, i, 0);
    }
    return arr;
  }

  /**
   * Test for java compiler.
   *
   * @param args for command line
   */
  public static void main(String[] args) {
    System.out.println("Successfully!!!");
  }
}