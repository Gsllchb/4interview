// Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a
// method to rotate the image by 90 degrees. Can you do this in place?


public class RotateImage {

  public static void rotateMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }
    assert matrix.length == matrix[0].length;
    int n = matrix.length;
    int max = n - 1;
    for (int y = 0; y < n / 2; ++y) {
      for (int x = y; x < n - y - 1; ++x) {
        int temp = matrix[y][x];
        matrix[y][x] = matrix[max - x][y];
        matrix[max - x][y] = matrix[max - y][max - x];
        matrix[max - y][max - x] = matrix[x][max - y];
        matrix[x][max - y] = temp;
      }
    }
  }

  public class Image {

    private int[][] matrix;
    private boolean hasRotated;
    private int n;

    public Image(int[][] source) {
      assert source != null && source.length > 0;
      assert source.length == source[0].length;
      matrix = source;
      n = matrix.length;
      hasRotated = false;
    }

    public int get(int x, int y) {
      if (hasRotated) {
        return matrix[n - 1 - x][y];
      } else {
        return matrix[y][x];
      }
    }

    public void set(int x, int y, int pixel) {
      if (hasRotated) {
        matrix[n - 1 - x][y] = pixel;
      } else {
        matrix[y][x] = pixel;
      }
    }

    public void rotate() {
      hasRotated = true;
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3, 4},
        {6, 7, 8, 9},
        {11, 12, 13, 14},
        {16, 17, 18, 19},
    };
    rotateMatrix(matrix);
    for (int[] line : matrix) {
      for (int pixel : line) {
        System.out.print(" " + pixel);
      }
      System.out.println();
    }

    matrix = null;
    rotateMatrix(matrix);
    assert matrix == null;

    matrix = new int[0][0];
    rotateMatrix(matrix);
    assert matrix.length == 0;
  }

}
