// Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a
// method to rotate the image by 90 degrees. Can you do this in place?


package RotateImage;

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
