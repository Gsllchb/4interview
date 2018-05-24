package util;

public class SinglyLinkedList<T> {

  private SinglyLinkedListNode head;
  private int length;

  public SinglyLinkedList() {
    head = new SinglyLinkedListNode(null, null);
    length = 0;
  }

  public int length() {
    return length;
  }

  public void addFirst(final T data) {
    SinglyLinkedListNode node = new SinglyLinkedListNode(data, head.next);
    head.next = node;
    ++length;
  }

  public void insert(int index, final T data) {
    SinglyLinkedListNode prev = getNode(index - 1);
    SinglyLinkedListNode node = new SinglyLinkedListNode(data, prev.next);
    prev.next = node;
    ++length;
  }

  public T remove(int index) {
    SinglyLinkedListNode prev = getNode(index - 1);
    T data = (T) prev.next.data;
    prev.next = prev.next.next;
    --length;
    return data;
  }

  public T get(int index) {
    return (T) getNode(index).data;
  }

  public T set(int index, final T data) {
    SinglyLinkedListNode node = getNode(index);
    T res = (T) node.data;
    node.data = data;
    return res;
  }


  private SinglyLinkedListNode getNode(int index) {
    SinglyLinkedListNode node = head;
    for (int i = 0; i <= index; ++i) {
      node = node.next;
    }
    return node;
  }

  public static void main(String[] args) {
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.addFirst(3);
    list.addFirst(2);
    list.addFirst(1);
    assert list.length() == 3;
    assert list.remove(1) == 2;
    assert list.length() == 2;
    list.insert(1, 5);
    assert list.get(1) == 5;
    assert list.get(2) == 3;
    assert list.set(0, 9) == 1;

    assert list.length() == 3;
    assert list.get(0) == 9;
    assert list.get(1) == 5;
    assert list.get(2) == 3;
  }
}
