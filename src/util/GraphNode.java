package util;

public class GraphNode<T> {

  public T data;
  public ArrayList<GraphNode<T>> children;

  public GraphNode(final T data) {
    this.data = data;
    this.children = new ArrayList<>();
  }

  public void addChild(final GraphNode<T> child) {
    children.add(child);
  }
}
