package util;

class DoublyLinkedListNode {

  DoublyLinkedListNode prev;
  Object data;
  DoublyLinkedListNode next;

  DoublyLinkedListNode(DoublyLinkedListNode prev, Object data, DoublyLinkedListNode next) {
    this.prev = prev;
    this.data = data;
    this.next = next;
  }
}
