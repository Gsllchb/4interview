package ArrayList;

class ArrayList<T> {

  private final static int DEFAULT_SIZE = 64;

  private Object[] list;
  private int length;

  ArrayList() {
    list = new Object[DEFAULT_SIZE];
    length = 0;
  }

  ArrayList(final int size) {
    this.list = new Object[size];
    this.length = 0;
  }

  void add(final T value) {
    assert length <= list.length;
    if (length == list.length) {
      resize();
    }
    list[length++] = value;
  }

  T get(final int index) {
    if (index >= length || index < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return (T) list[index];
  }

  void set(final int index, final T value) {
    if (index >= length || index < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    list[index] = value;
  }

  int length() {
    return length;
  }

  void shrink() {
    Object[] res = new Object[length];
    System.arraycopy(list, 0, res, 0, length);
    list = res;
  }

  private void resize() {
    Object[] res = new Object[list.length * 2];
    System.arraycopy(list, 0, res, 0, list.length);
    list = res;
  }

}