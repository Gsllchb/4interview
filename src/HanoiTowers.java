import util.Stack;

public class HanoiTowers {
  private static final int NUM_OF_PLATES = 7;
  public static void move(Stack<Integer>[] stacks, int start, int dest, int num) {
    if (num == 1) {
      int plate = stacks[start].pop();
      assert stacks[dest].isEmpty() || plate < stacks[dest].peep();
      stacks[dest].push(plate);
      return;
    }
    int temp = 0 + 1 + 2 - start - dest;
    move(stacks, start, temp, num - 1);
    move(stacks, start, dest, 1);
    move(stacks, temp, dest, num - 1);
  }

  public static void main(String[] args) {
    Stack<Integer>[] stacks = new Stack[3];
    for (int i = 0; i < stacks.length; ++i) {
      stacks[i] = new Stack<>();
    }
    for (int i = NUM_OF_PLATES; i > 0; --i) {
      stacks[0].push(i);
    }
    display(stacks);
    move(stacks, 0, 2, NUM_OF_PLATES);
    display(stacks);
  }

  static void display(Stack<Integer>[] stacks) {
    for (int i = NUM_OF_PLATES - 1; i >= 0; --i) {
      for (int j = 0; j < 3; ++j) {
        System.out.print("\t" + (stacks[j].length() > i ? stacks[j].get(i) : "#"));
      }
      System.out.println();
    }
    System.out.println("------------");
  }
}
