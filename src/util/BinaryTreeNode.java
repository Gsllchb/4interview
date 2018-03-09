package util;

public class BinaryTreeNode<T extends Comparable<T>> {

  public BinaryTreeNode left;
  public T data;
  public BinaryTreeNode right;

  public BinaryTreeNode(final BinaryTreeNode<T> left, final T data, final BinaryTreeNode<T> right) {
    this.left = left;
    this.data = data;
    this.right = right;
  }
}
