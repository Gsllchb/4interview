package util;

public class BinarySearchTree {

  private BinaryTreeNode root = null;


  //================ Insert ==================
  public void insert(final Comparable element) {
    root = insert(root, element);
  }

  private BinaryTreeNode insert(final BinaryTreeNode root, final Comparable element) {
    if (root == null) {
      return new BinaryTreeNode(element);
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
  public boolean search(final Comparable element) {
    return search(root, element);
  }

  private boolean search(final BinaryTreeNode root, final Comparable element) {
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
  public void delete(final Comparable element) {
    root = delete(root, element);
  }

  private BinaryTreeNode delete(final BinaryTreeNode root, final Comparable element) {
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
        root.left = delete(root.left, root.data);
      }
    } else if (res < 0) {
      root.right = delete(root.right, element);
    } else {
      root.left = delete(root.left, element);
    }
    return root;
  }

  private Comparable getRightmostData(BinaryTreeNode root) {
    while (root.right != null) {
      root = root.right;
    }
    return root.data;
  }

  // =============== MISC ====================
  public BinaryTreeNode getRoot() {
    return root;
  }


  // =============== Test ====================
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    assert !tree.search(1);
    tree.delete(2);
    tree.insert(0);
    assert tree.search(0);
    tree.delete(0);
    assert !tree.search(0);
  }
}
