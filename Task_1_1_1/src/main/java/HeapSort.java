public class HeapSort {
    public static void swap(int arr[], int a, int b) {
        int buff = arr[a];
        arr[a] = arr[b];
        arr[b] = buff;
    }

    
    public static void heap(int arr[], int len, int i) {
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

    public static void heapsort(int arr[]) {

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

        int arr[] = {3, 5, 1, 10, 12};
        int len = arr.length;

        HeapSort sort = new HeapSort();
        sort.heapsort(arr);

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