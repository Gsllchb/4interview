package util;

public class DoublyLinkedList<T> {
  private DoublyLinkedListNode head;
  private DoublyLinkedListNode end;
  private int length;

  public DoublyLinkedList() {
    length = 0;
    head = new DoublyLinkedListNode(null, null, null);
    end = new DoublyLinkedListNode(head, null, null);
    head.next = end;
  }

  public int length() {
    return length;
  }

  public void insert(int index, T element) {
    DoublyLinkedListNode prev = getNode(index - 1);
    DoublyLinkedListNode node = new DoublyLinkedListNode(prev, element, prev.next);
    prev.next.prev = node;
    prev.next = node;
    ++length;
  }

  public T get(int index) {
    return (T) getNode(index).data;
  }

  public T set(int index, final T element) {
    DoublyLinkedListNode node = getNode(index);
    T res = (T) node.data;
    node.data = element;
    return res;
  }

  public T remove(int index) {
    DoublyLinkedListNode node = getNode(index);
    node.prev.next = node.next;
    node.next.prev = node.prev;
    --length;
    return (T) node.data;
  }

  private DoublyLinkedListNode getNode(int index) {
    DoublyLinkedListNode node = null;
    if (index >= length / 2) {
      node = end;
      for (int i = length; i > index; --i) {
        node = node.prev;
      }
    } else {
      node = head;
      for (int i = 0; i <= index; ++i) {
        node = node.next;
      }
    }
    return node;
  }

  public static void main(String[] args) {
    DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
    assert list.length() == 0;
    list.insert(0, 1);
    assert list.length() == 1;
    list.insert(0, 3);
    assert list.get(1) == 1;
    list.insert(1, 2);
    assert list.length() == 3;
    assert list.get(2) == 1;
    assert list.remove(0) == 3;
    assert list.length() == 2;
    assert list.set(0, 4) == 2;
    assert list.get(0) == 4;
    assert list.get(1) == 1;
    assert list.length() == 2;
  }
}
