package util;

public class Queue<T> extends DoublyLinkedList<T> {
  public T pop() {
    return remove(length() - 1);
  }

  public T peep() {
    return get(length() - 1);
  }

  public void push(T element) {
    insert(0, element);
  }

  public boolean isEmpty() {
    return length() == 0;
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new Queue<>();
    assert queue.isEmpty();
    queue.push(1);
    queue.push(2);
    queue.push(3);
    assert !queue.isEmpty();
    assert queue.pop() == 1;
    assert queue.peep() == 2;
    assert queue.pop() == 2;
    assert queue.pop() == 3;
    assert queue.isEmpty();
  }
}
