import util.BinarySearchTree;
import util.BinaryTreeNode;
import util.Queue;

class TreeTraversals {

  static void preOrder(final BinaryTreeNode root) {
    System.out.println(root.data);
    if (root.left != null) {
      preOrder(root.left);
    }
    if (root.right != null) {
      preOrder(root.right);
    }
  }

  static void inOrder(final BinaryTreeNode root) {
    if (root.left != null) {
      inOrder(root.left);
    }
    System.out.println(root.data);
    if (root.right != null) {
      inOrder(root.right);
    }
  }

  static void postOrder(final BinaryTreeNode root) {
    if (root.left != null) {
      postOrder(root.left);
    }
    if (root.right != null) {
      postOrder(root.right);
    }
    System.out.println(root.data);
  }

  static void levelOrder(final BinaryTreeNode root) {
    Queue<BinaryTreeNode> queue = new Queue<>();
    queue.push(root);
    while (!queue.isEmpty()) {
      BinaryTreeNode current = queue.pop();
      System.out.println(current.data);
      if (current.left != null) {
        queue.push(current.left);
      }
      if (current.right != null) {
        queue.push(current.right);
      }
    }
  }


  //================== Test ==============================
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(5);
    tree.insert(6);
    tree.insert(7);
    tree.insert(2);
    tree.insert(1);
    tree.insert(4);
    tree.insert(3);
    System.out.println("=============== pre-order ===============");
    preOrder(tree.getRoot());
    System.out.println("=============== in-order ===============");
    inOrder(tree.getRoot());
    System.out.println("=============== post-order ===============");
    postOrder(tree.getRoot());
    System.out.println("=============== level-order ===============");
    levelOrder(tree.getRoot());
  }
}
