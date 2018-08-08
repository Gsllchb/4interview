public class HeapSort {
  public static <T extends Comparable<T>> void heapSort(T[] arr) {
    initHeap(arr);
    for (int i = arr.length - 1; i > 0; --i) {
      swap(arr, 0, i);
      maxHeap(arr, 0, i);
    }
  }

  private static <T extends Comparable<T>> void initHeap(T[] arr) {
    for (int i = (arr.length - 2) / 2; i >= 0; --i) {
      maxHeap(arr, i, arr.length);
    }
  }

  private static <T extends Comparable<T>> void maxHeap(T[] arr, int index, int size) {
    int max = index;
    int left = getLeftChildIndex(index);
    int right = getRightChildIndex(index);
    if (left < size && arr[max].compareTo(arr[left]) < 0) {
      max = left;
    }
    if (right < size && arr[max].compareTo(arr[right]) < 0) {
      max = right;
    }
    if (max == index) {
      return;
    }
    swap(arr, index, max);
    maxHeap(arr, max, size);
  }

  private static int getLeftChildIndex(int index) {
    return 2 * index + 1;
  }
  private static int getRightChildIndex(int index) {
    return 2 * index + 2;
  }

  private static void swap(Object[] arr, int a, int b) {
    Object temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  // test
  public static void main(String[] args) {
    Integer[] arr = {-1, 2, 9, 0, -2, 9, 1, -7, 22, 0};
    heapSort(arr);
    printArray(arr);
  }

  private static void printArray(Object[] arr) {
    for (Object i : arr) {
      System.out.print(i + ", ");
    }
  }
}