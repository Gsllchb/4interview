// Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a
// method to rotate the image by 90 degrees. Can you do this in place?

package RotateImage;

public class RotateMatrix {

  static void rotateMatrix(int[][] matrix) {
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
