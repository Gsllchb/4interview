package util;

public class ArrayList<T> {

  private final static int DEFAULT_CAPACITY = 64;

  private Object[] list;
  private int length;

  public ArrayList() {
    list = new Object[DEFAULT_CAPACITY];
    length = 0;
  }

  public ArrayList(int initialCapacity) {
    this.list = new Object[initialCapacity];
    this.length = 0;
  }

  public void add(final T value) {
    assert length <= list.length;
    if (length == list.length) {
      resize();
    }
    list[length++] = value;
  }

  public T removeLast() {
    T res = (T) list[--length];
    list[length] = null;  // 确保被移除的元素能够被垃圾收集器回收
    return res;
  }

  public void remove(final T value) {
    int i;
    for (i = 0; i < list.length; ++i) {
      if (value.equals(list[i])) {
        break;
      }
    }
    if (i == list.length) {
      return;
    }
    for (int j = i; j < list.length - 1; ++j) {
      list[j] = list[j + 1];
    }
    removeLast();
  }

  public boolean contains(final T value) {
    for (Object e: list) {
      if (value.equals(e)) {
        return true;
      }
    }
    return false;
  }

  public T get(int index) {
    if (index >= length || index < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return (T) list[index];
  }

  public void set(int index, final T value) {
    if (index >= length || index < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    list[index] = value;
  }

  public int length() {
    return length;
  }

  public void shrink() {
    Object[] res = new Object[length];
    System.arraycopy(list, 0, res, 0, length);
    list = res;
  }

  private void resize() {
    Object[] res = new Object[list.length * 2];
    System.arraycopy(list, 0, res, 0, list.length);
    list = res;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    assert list.length() == 1;
    assert list.get(0) == 1;
    list.add(2);
    assert list.length() == 2;
    list.set(1, 3);
    assert list.get(1) == 3;
    list.shrink();
    assert list.get(0) == 1;
    assert list.get(1) == 3;
    assert list.contains(3);
    list.remove(3);
    assert !list.contains(3);
  }
}