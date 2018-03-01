package ArrayList;

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

}