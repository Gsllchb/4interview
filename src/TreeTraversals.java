import util.BinaryTreeNode;
import util.Queue;

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

  public static void postOrder(final BinaryTreeNode<Integer> root) {
    if (root.left != null) {
      postOrder(root.left);
    }
    if (root.right != null) {
      postOrder(root.right);
    }
    System.out.println(root.data);
  }

  public static void levelOrder(final BinaryTreeNode<Integer> root) {
    Queue<BinaryTreeNode<Integer>> queue = new Queue<>();
    queue.push(root);
    while (!queue.isEmpty()) {
      BinaryTreeNode<Integer> current = queue.pop();
      System.out.println(current.data);
      if (current.left != null) {
        queue.push(current.left);
      }
      if (current.right != null) {
        queue.push(current.right);
      }
    }
  }

//================================================
// Test
//================================================

  public static void main(String[] args) {

  }
}
