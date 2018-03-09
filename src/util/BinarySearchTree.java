package util;

public class BinarySearchTree<T extends Comparable<T>> {
  private BinaryTreeNode<T> root = null;
  private int size = 0;

  public boolean insert(final T element) {
    if (root == null) {
      root = new BinaryTreeNode<>(element);
      ++size;
      return true;
    }
    if (root.data.compareTo(element) == 0) {
      return false;
    }
    for ( ; ; ) {
      if (root.data.compareTo(element) < 0) {
        if (root.right == null) {
          root.right = new BinaryTreeNode<>(element);
          ++size;
          return true;
        } else {
          root = root.right;
        }
      } else {
        if (root.left == null) {
          root.left = new BinaryTreeNode<>(element);
          ++size;
          return true;
        } else {
          root = root.left;
        }
      }
    }
  }

  public BinaryTreeNode<T> getRoot() {
    return root;
  }

  public int getSize() {
    return size;
  }
}
