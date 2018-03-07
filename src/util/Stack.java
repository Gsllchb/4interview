package util;

public class Stack<T> extends ArrayList<T> {
  public void push(T element) {
    add(element);
  }

  public T pop() {
    return removeLast();
  }

  public T peep() {
    return get(length() - 1);
  }

  public boolean isEmpty() {
    return length() == 0;
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    assert stack.isEmpty();
    stack.push(1);
    assert !stack.isEmpty();
    assert stack.peep() == 1;
    stack.push(2);
    assert stack.pop() == 2;
    assert stack.pop() == 1;
    assert stack.isEmpty();
  }
}
