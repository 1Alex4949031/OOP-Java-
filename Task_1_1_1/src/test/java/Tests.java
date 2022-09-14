import java.util.Arrays;

/**
 * Class with Tests examples.
 */
public class Tests {
    public static void main(String[] args) {
        /**
         * Using Heapsort class for checking
         * the correctness of realization
         */
        HeapSort test = new HeapSort();

        int correct[] = {1, 2, 3, 4, 5};

        int test_arr_1[] = {1, 2, 3, 4, 5};
        int test_arr_2[] = {5, 4, 3, 2, 1};
        int test_arr_3[] = {0, 0, 0, 0, 0};
        int test_arr_4[] = {};
        int test_arr_5[] = {51, 43, 11, 1, 14, 5};
        int test_arr_6[] = {3, 4, 5, 6, 1};
        int test_arr_7[] = {1, 2, 1, 1, 2};
        int test_arr_8[] = {1};

        test.heapsort(test_arr_1);
        test.heapsort(test_arr_2);
        test.heapsort(test_arr_3);
        test.heapsort(test_arr_4);
        test.heapsort(test_arr_5);
        test.heapsort(test_arr_6);
        test.heapsort(test_arr_7);
        test.heapsort(test_arr_8);

        assert (Arrays.equals(test_arr_1, correct));
        assert (Arrays.equals(test_arr_2, correct));
        assert (Arrays.equals(test_arr_3, correct));
        assert (Arrays.equals(test_arr_4, correct));
        assert (Arrays.equals(test_arr_5, correct));
        assert (Arrays.equals(test_arr_6, correct));
        assert (Arrays.equals(test_arr_7, correct));
        assert (Arrays.equals(test_arr_8, correct));

    }
}