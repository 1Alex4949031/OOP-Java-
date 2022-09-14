/**
 * Heapsort class.
 */
public class HeapSort {
    public static void swap(int[] arr, int a, int b) {
        /**
         * Making default swap function
         * a -> b, b -> a
         */
        int buff;
        buff = arr[a];
        arr[a] = arr[b];
        arr[b] = buff;
    }

    public static void heap(int[] arr, int len, int i) {
        /**
         * Finding max-heap.
         * Checking the sons of the current root,
         * trying to the biggest one.
         */
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

    public static void heapsort(int[] arr) {
        /**
         * 1. Getting the max-heap tree.
         * 2. Changing the root and the last element of the heap.
         * Then make the heap smaller by decreasing by 1. Getting
         * the max-heap with the new root.
         * 3. Start with the 1 sentence while size of heap > 1.
         */
        int len = arr.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heap(arr, len, i);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            heap(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        /**
         * Test example.
         */
        int[] arr = {3, 5, 1, 10, 12};
        int len = arr.length;

        heapsort(arr);

        System.out.print("{");
        for (int i = 0; i < len; i++) {
            if (i != len - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.print("}");
    }

}