package util;

public class BinaryTreeNode<T extends Comparable<T>> {

  public BinaryTreeNode<T> left = null;
  public T data;
  public BinaryTreeNode<T> right = null;

  public BinaryTreeNode(final T data) {
    this.data = data;
  }
}
