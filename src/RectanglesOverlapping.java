public class RectanglesOverlapping {
  private static class Rectangle {
    double up;
    double down;
    double left;
    double right;
    Rectangle(double x, double y, double width, double height) {
      up = y;
      down = y + height;
      left = x;
      right = x + width;
    }
  }

  public static boolean AreOverlapping(Rectangle r1, Rectangle r2) {
    if (r1 == null || r2 == null) {
      return false;
    }
    if (r1.up >= r2.down || r1.down <= r2.up || r1.left >= r2.right || r1.right <= r2.left) {
      return false;
    }
    return true;
  }

  //================ test =================
  public static void main(String[] args) {
    Rectangle r1 = new Rectangle(0, 0, 1, 1);
    Rectangle r2 = new Rectangle(2, 2, 1, 1);
    assert !AreOverlapping(r1, r2);
    assert !AreOverlapping(r2, r1);

    r1 = new Rectangle(0, 0, 1, 1);
    r2 = new Rectangle(1, 0, 1, 1);
    assert !AreOverlapping(r1, r2);
    assert !AreOverlapping(r2, r1);

    r1 = new Rectangle(-2, -2, 4, 4);
    r2 = new Rectangle(-1, -1, 2, 2);
    assert AreOverlapping(r1, r2);
    assert AreOverlapping(r2, r1);

    r1 = new Rectangle(0, 0, 2, 2);
    r2 = new Rectangle(1, 1, 2, 2);
    assert AreOverlapping(r1, r2);
    assert AreOverlapping(r2, r1);

    r1 = new Rectangle(0, 0, 2, 1);
    r2 = new Rectangle(1, 0, 2, 1);
    assert AreOverlapping(r1, r2);
    assert AreOverlapping(r2, r1);

    r1 = new Rectangle(-2, -1, 4, 2);
    r2 = new Rectangle(-1, -2, 2, 4);
    assert AreOverlapping(r1, r2);
    assert AreOverlapping(r2, r1);

    r1 = new Rectangle(-2, -1, 4, 2);
    r2 = new Rectangle(-1, -1, 2, 4);
    assert AreOverlapping(r1, r2);
    assert AreOverlapping(r2, r1);

    r1 = new Rectangle(-2, -1, 4, 2);
    r2 = new Rectangle(-1, 0, 2, 4);
    assert AreOverlapping(r1, r2);
    assert AreOverlapping(r2, r1);

    r1 = new Rectangle(0, 0, 2, 2);
    r2 = new Rectangle(1, 1, 0, 0);
    assert AreOverlapping(r1, r2);
    assert AreOverlapping(r2, r1);

    r1 = new Rectangle(0, 0, 0, 0);
    r2 = new Rectangle(1, 1, 0, 0);
    assert !AreOverlapping(r1, r2);
    assert !AreOverlapping(r2, r1);

    r1 = null;
    r2 = new Rectangle(2, 2, 1, 1);
    assert !AreOverlapping(r1, r2);
    assert !AreOverlapping(r2, r1);
  }
}
