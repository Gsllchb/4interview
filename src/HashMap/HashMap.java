package HashMap;

import HashMap.Entry;
import java.util.NoSuchElementException;
import javax.naming.SizeLimitExceededException;

public class HashMap<K, V> {

  private static final int DEFAULT_CAPACITY = 1 << 10;  // 1024
  private Entry[] entries;
  private int capacity;

  public HashMap() {
    entries = new Entry[DEFAULT_CAPACITY];
    capacity = DEFAULT_CAPACITY;
  }

  public HashMap(int initialCapacity) {
    entries = new Entry[initialCapacity];
    capacity = initialCapacity;
  }

  public void put(final K key, final V value) throws SizeLimitExceededException {
    for (int i = 0; i < tolerant(capacity); ++i) {
      Entry entry = entries[(getIndex(key.hashCode()) + step(i)) % capacity];
      if (entry.key == null || entry.key.equals(key)) {
        entry.key = key;
        entry.value = value;
        return;
      }
    }
    throw new SizeLimitExceededException();
  }

  public V get(final K key) throws NoSuchElementException {
    for (int i = 0; i < tolerant(capacity); ++i) {
      Entry entry = entries[(getIndex(key.hashCode()) + step(i)) % capacity];
      if (entry.key.equals(key)) {
        return (V) entry.value;
      } else if (entry.key == null) {
        return null;
      }
    }
    throw new NoSuchElementException();
  }

  public boolean containKey(final K key) {
    return entries[getIndex(key.hashCode())].key != null;
  }

  private int getIndex(int hashCode) {
    return hashCode & (capacity - 1);
  }

  private static int step(int i) {
    return i * i;
  }

  private static int tolerant(int capacity) {
    // TODO
    return capacity;
  }

  public static void main(String[] args) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
  }

}
