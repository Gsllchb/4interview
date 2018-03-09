package util;

public class BinarySearchTree<T extends Comparable<T>> {

  private BinaryTreeNode<T> root = null;
  private int size = 0;

  public boolean insert(final T element) {
    if (root == null) {
      root = new BinaryTreeNode<>(null, element);
      ++size;
      return true;
    } else {
      return insert(root, element);
    }
  }

  private boolean insert(BinaryTreeNode<T> root, final T element) {
    for ( ; ; ) {
      int res = root.data.compareTo(element);
      if (res == 0) {
        return false;
      } else if (res < 0) {
        if (root.right == null) {
          root.right = new BinaryTreeNode<>(root, element);
          ++size;
          return true;
        } else {
          root = root.right;
        }
      } else {
        if (root.left == null) {
          root.left = new BinaryTreeNode<>(root, element);
          ++size;
          return true;
        } else {
          root = root.left;
        }
      }
    }
  }

  public boolean contains(final T element) {
    if (root == null) {
      return false;
    } else {
      return contains(root, element);
    }
  }

  private boolean contains(BinaryTreeNode<T> root, final T element) {
    for ( ; ; ) {
      int res = root.data.compareTo(element);
      if (res == 0) {
        return true;
      } else if (res < 0) {
        if (root.right == null) {
          return false;
        } else {
          root = root.right;
        }
      } else {
        if (root.left == null) {
          return false;
        } else {
          root = root.left;
        }
      }
    }
  }

  private boolean remove(BinaryTreeNode<T> root, final T element) {
    // TODO
    return false;
  }

  public BinaryTreeNode<T> getRoot() {
    return root;
  }

  public int size() {
    return size;
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    assert tree.size() == 0;
    assert tree.insert(1);
    assert tree.size() == 1;
    assert tree.contains(1);
    assert tree.insert(2);
    assert tree.contains(2);
    assert tree.size() == 2;
  }
}
