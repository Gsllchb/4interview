public class SortAlgorithm<T extends Comparable<T>> {

  // quick sort
  public void quickSort(T[] arr, int lo, int hi) {
    if (hi - lo <= 1) {
      return;
    }
    int mi = findPartition(arr, lo, hi);
    quickSort(arr, lo, mi);
    quickSort(arr, mi + 1, hi);
  }

  private int findPartition(T[] arr, int lo, int hi) {
    T pivot = arr[lo];
    while (hi - lo > 1) {
      while (hi - lo > 1 && arr[hi - 1].compareTo(pivot) >= 0) {
        --hi;
      }
      arr[lo] = arr[hi - 1];
      while (hi - lo > 1 && arr[lo].compareTo(pivot) <= 0) {
        ++lo;
      }
      arr[hi - 1] = arr[lo];
    }
    arr[lo] = pivot;
    return lo;
  }



  // test
  public static void main(String[] args) {
    SortAlgorithm<Integer> sa = new SortAlgorithm<>();
    Integer[] arr = {-1, 2, 9, 0, -2, 9, 1, -7, 22, 0};
    sa.quickSort(arr, 0, arr.length);
    sa.printArray(arr);
  }

  private void printArray(T[] arr) {
    for (T i : arr) {
      System.out.print(i + ", ");
    }
  }
}
