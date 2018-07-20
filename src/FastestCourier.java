// 2019 阿里巴巴 JAVA研发工程师 编程测验题：
// 快递员从（0，0）出发要将快递送到n个位于正方形网络顶点上的用户手中，并回到（0，0）。计算最短路径长度。
// 示例输入：
// 3
// 1,1
// 3,2
// 0,4
// 示例输出：
// 14

import java.util.*;
import java.io.*;

public class FastestCourier {

  static class Position {
    int x;
    int y;
    Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  final static Position ORIGIN = new Position(0, 0);

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int n = in.nextInt();
    Position[] positions = new Position[n];
    for (int i = 0; i < n; ++i) {
      String[] strs = in.next().split(",");
      assert strs.length == 2;
      positions[i] = new Position(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
    }
    int minLength = Integer.MAX_VALUE;
    for (Position p: positions) {
      ArrayList<Position> list = new ArrayList<>();
      list.add(p);
      int length = distance(ORIGIN, p) + findMinLength(positions, list, p);
      if (length < minLength) {
        minLength = length;
      }
    }
    System.out.println(minLength);
  }

  static int findMinLength(Position[] positions, ArrayList<Position> hasVisited, Position start) {
    if (positions.length == hasVisited.size()) {
      return distance(ORIGIN, start);
    }
    int minLength = Integer.MAX_VALUE;
    for (Position p: positions) {
      if (hasVisited.contains(p)) {
        continue;
      }
      ArrayList<Position> clone = (ArrayList<Position>) hasVisited.clone();
      clone.add(p);
      int length = distance(start, p) + findMinLength(positions, clone, p);
      if (length < minLength) {
        minLength = length;
      }
    }
    return minLength;
  }

  static int distance(Position p1, Position p2) {
    return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
  }
}