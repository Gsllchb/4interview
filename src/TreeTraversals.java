import util.BinaryTreeNode;
public class TreeTraversals {

  public static void preOrder(final BinaryTreeNode<Integer> root) {
    System.out.println(root.data);
    if (root.left != null) {
      preOrder(root.left);
    }
    if (root.right != null) {
      preOrder(root.right);
    }
  }

  public static void inOrder(final BinaryTreeNode<Integer> root) {
    if (root.left != null) {
      inOrder(root.left);
    }
    System.out.println(root.data);
    if (root.right != null) {
      inOrder(root.right);
    }
  }

  public static void postOrder(BinaryTreeNode<Integer> root) {
    if (root.left != null) {
      postOrder(root.left);
    }
    if (root.right != null) {
      postOrder(root.right);
    }
    System.out.println(root.data);
  }

//================================================
// Test
//================================================

  public static void main(String[] args) {

  }
}
