package util;

public class BinaryTreeNode<T extends Comparable<T>> {

  public BinaryTreeNode<T> parent;
  public T data;
  public BinaryTreeNode<T> left = null;
  public BinaryTreeNode<T> right = null;

  public BinaryTreeNode(final BinaryTreeNode<T> parent, final T data) {
    this.parent = parent;
    this.data = data;
  }
}
