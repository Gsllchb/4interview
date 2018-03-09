package util;

public class BinarySearchTree<T extends Comparable<T>> {

  private BinaryTreeNode<T> root = null;


  //================ Insert ==================
  public void insert(final T element) {
    root = insert(root, element);
  }

  private BinaryTreeNode<T> insert(final BinaryTreeNode<T> root, final T element) {
    if (root == null) {
      return new BinaryTreeNode<>(element);
    }
    int res = root.data.compareTo(element);
    if (res < 0) {
      root.right = insert(root.right, element);
    } else if (res > 0) {
      root.left = insert(root.left, element);
    }
    return root;
  }


  // ============== Search ===================
  public boolean search(final T element) {
    return search(root, element);
  }

  private boolean search(final BinaryTreeNode<T> root, final T element) {
    if (root == null) {
      return false;
    }
    int res = root.data.compareTo(element);
    if (res == 0) {
      return true;
    } else if (res < 0) {
      return search(root.right, element);
    } else {
      return search(root.left, element);
    }
  }


  // =============== Delete ==================
  public void delete(final T element) {
    root = delete(root, element);
  }

  private BinaryTreeNode<T> delete(final BinaryTreeNode<T> root, final T element) {
    if (root == null) {
      return null;
    }
    int res = root.data.compareTo(element);
    if (res == 0) {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        root.data = getRightmostData(root.left);
        root.left = delete(root.left, element);
      }
    } else if (res < 0) {
      root.right = delete(root.right, element);
    } else {
      root.left = delete(root.left, element);
    }
    return root;
  }

  private T getRightmostData(BinaryTreeNode<T> root) {
    while (root != null) {
      root = root.right;
    }
    return root.data;
  }

  // =============== MISC ====================
  public BinaryTreeNode<T> getRoot() {
    return root;
  }


  // =============== Test ====================
  public static void main(String[] args) {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    assert !tree.search(1);
    tree.delete(2);
    tree.insert(0);
    assert tree.search(0);
    tree.delete(0);
    assert !tree.search(0);
  }
}
