import java.util.Scanner;


public class FastestRobotPath {

  private static final int MAX_PATH_LENGTH = 65535;


  public static void main(String[] args) {
    //输入
    Scanner scanner = new Scanner(System.in);

    int startX = scanner.nextInt();
    int startY = scanner.nextInt();
    Direction startDirection = Direction.valueOf(scanner.next());

    int endX = scanner.nextInt();
    int endY = scanner.nextInt();
    Direction endDirection = Direction.valueOf(scanner.next());

    int row = scanner.nextInt();
    int column = scanner.nextInt();
    int[][] map = new int[row][column];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        map[i][j] = scanner.nextInt();
      }
    }

    //实现此函数，或 完全按照自己想法进行函数编写
    int pathLength = cal(map, startDirection,startX, startY,  endDirection, endX, endY, row, column);
    //输出
    System.out.print(pathLength);
  }

  private static int cal(
      int[][] map,
      Direction startDirection, int startX, int startY,
      Direction endDirection, int endX, int endY,
      int row, int column
  ) {
    if (startX == endX && startY == endY) {
      return rotate(startDirection, endDirection);
    }
    int pathEast = Integer.MAX_VALUE;
    int pathWest = Integer.MAX_VALUE;
    int pathNorth = Integer.MAX_VALUE;
    int pathSouth = Integer.MAX_VALUE;

    if (startX + 1 < column) {
      pathEast = rotate(startDirection, Direction.EAST) + 1
          + cal(map, Direction.EAST, startX + 1, startY, endDirection, endX, endY, row, column);
    }
    if (startX - 1 >= 0) {
      pathWest = rotate(startDirection, Direction.WEST) + 1
          + cal(map, Direction.WEST, startX - 1, startY, endDirection, endX, endY, row, column);
    }
    if (startY - 1>= 0) {
      pathNorth = rotate(startDirection, Direction.NORTH) + 1
          + cal(map, Direction.NORTH, startX, startY - 1, endDirection, endX, endY, row, column);
    }
    if (startY + 1 < row) {
      pathSouth = rotate(startDirection, Direction.SOUTH) + 1
          + cal(map, Direction.SOUTH, startX, startY + 1, endDirection, endX, endY, row, column);
    }
    int min = Integer.MAX_VALUE;
    if (pathEast < min) {
      min = pathEast;
    }
    if (pathWest < min) {
      min = pathEast;
    }
    if (pathNorth < min) {
      min = pathEast;
    }
    if (pathSouth < min) {
      min = pathEast;
    }
    return min;
  }

  private static int rotate(Direction startDirection, Direction endDirection) {
    if (startDirection.equals(endDirection)) {
      return 0;
    }
    if ((startDirection.equals(Direction.EAST) || startDirection.equals(Direction.WEST))
        && (endDirection.equals(Direction.NORTH) || endDirection.equals(Direction.SOUTH))) {
      return 1;
    } else if ((startDirection.equals(Direction.NORTH) || startDirection.equals(Direction.SOUTH))
        && (endDirection.equals(Direction.EAST) || endDirection.equals(Direction.WEST))) {
      return 1;
    } else {
      return 2;
    }
  }

  public enum Direction {

    EAST(0),
    WEST(1),
    SOUTH(2),
    NORTH(3),
    UNKNOWN(4);

    int index;

    public int getIndex() {
      return index;
    }

    Direction(int index) {
      this.index = index;
    }

    static Direction getDirectionByIndex(int index){
      for (Direction direction : Direction.values()) {
        if(direction.index == index){
          return direction;
        }
      }
      return UNKNOWN;
    }

  }
}
