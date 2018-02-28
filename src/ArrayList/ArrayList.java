package ArrayList;

public class ArrayList<T> {
  private final static int DEFAULT_SIZE = 64;

  private Object[] list;
  private int length;

  public ArrayList() {
    this.list = new Object[DEFAULT_SIZE];
    this.length = 0;
  }

  public ArrayList(final int size) {
    this.list = new Object[size];
    this.length = 0;
  }

  public void add(final T value) {
    assert length <= list.length;
    if (length == list.length) {
      resize();
    }
    list[length++] = value;
  }

  public T get(final int index) {
    if (index >= length || index < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return (T) list[index];
  }

  public void set(final int index, T value) {
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
