import util.GraphNode;
import java.util.HashSet;
import util.Queue;
import util.Stack;

class GraphTraversals {
  static void dfs(final GraphNode<Integer> start, final int target) {
    HashSet<GraphNode<Integer>> hasVisited = new HashSet<>();
    Stack<GraphNode<Integer>> stack = new Stack<>();
    stack.push(start);
    while (!stack.isEmpty()) {
      GraphNode<Integer> node = stack.pop();
      if (contain(hasVisited, node)) {
        continue;
      }
      System.out.println(node.data);
      if (node.data.equals(target)) {
        System.out.println("Find the target!");
        return;
      }
      for (int i = 0; i < node.children.length(); ++i) {
        GraphNode<Integer> n = node.children.get(i);
        if (!contain(hasVisited, n)) {
          stack.push(n);
        }
      }
      hasVisited.add(node);
    }
  }

  static void bfs(final GraphNode<Integer> start, final int target) {
    HashSet<GraphNode<Integer>> hasVisited = new HashSet<>();
    Queue<GraphNode<Integer>> queue = new Queue<>();
    queue.push(start);
    while (!queue.isEmpty()) {
      GraphNode<Integer> node = queue.pop();
      if (contain(hasVisited, node)) {
        continue;
      }
      System.out.println(node.data);
      if (node.data.equals(target)) {
        System.out.println("Find the target!");
        return;
      }
      for (int i = 0; i < node.children.length(); ++i) {
        GraphNode<Integer> n = node.children.get(i);
        if (!contain(hasVisited, n)) {
          queue.push(n);
        }
      }
      hasVisited.add(node);
    }
  }

  static boolean contain(final HashSet<GraphNode<Integer>> set, final GraphNode<Integer> node) {
    for (GraphNode<Integer> n: set) {
      if (n == node) {  // Note that, there isn't equals().
        return true;
      }
    }
    return false;
  }


  //===================== Test =======================
  public static void main(String[] args) {
    GraphNode<Integer> n0 = new GraphNode<>(0);
    GraphNode<Integer> n11 = new GraphNode<>(1);
    GraphNode<Integer> n12 = new GraphNode<>(1);
    GraphNode<Integer> n21 = new GraphNode<>(2);
    GraphNode<Integer> n22 = new GraphNode<>(2);
    GraphNode<Integer> n23 = new GraphNode<>(2);
    GraphNode<Integer> n3 = new GraphNode<>(3);
    GraphNode<Integer> n4 = new GraphNode<>(4);
    n11.addChild(n21);
    n11.addChild(n22);
    n21.addChild(n3);
    n3.addChild(n11);
    n3.addChild(n4);
    n22.addChild(n4);
    n4.addChild(n12);
    n12.addChild(n23);
    n12.addChild(n0);
    n23.addChild(n0);
    n23.addChild(n4);

    System.out.println("=========== BFS ===========");
    bfs(n11, 0);
    System.out.println("=========== DFS ===========");
    dfs(n11, 0);
  }
}