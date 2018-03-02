package HashMap;

import java.util.Random;
import javax.naming.SizeLimitExceededException;

public class HashMap<K, V> {

  private static final int DEFAULT_CAPACITY = 1 << 10;  // 1024
  private Entry[] entries;
  private int capacity;
  private Random random;

  public HashMap() {
    entries = new Entry[DEFAULT_CAPACITY];
    capacity = DEFAULT_CAPACITY;
    random = new Random();
  }

  public HashMap(int initialCapacity) {
    entries = new Entry[initialCapacity];
    capacity = initialCapacity;
    random = new Random();
  }

  public void put(final K key, final V value) throws SizeLimitExceededException {
    random.setSeed(key.hashCode());
    for (int i = 0; i < tolerant(capacity); ++i) {
      int index = random.nextInt(capacity);
      Entry entry = entries[index];
      if (entry == null) {
        entries[index] = new Entry(key, value);
        return;
      } else if (entry.key.equals(key)) {
        entry.value = value;
        return;
      }
    }
    throw new SizeLimitExceededException();
  }

  public V remove(final K key) {
    random.setSeed(key.hashCode());
    for (int i = 0; i < tolerant(capacity); ++i) {
      int index = random.nextInt(capacity);
      Entry entry = entries[index];
      if (entry == null) {
        return null;
      } else if (entry.key.equals(key)) {
        entries[index] = null;
        return (V) entry.value;
      }
    }
    return null;
  }

  public V get(final K key) {
    random.setSeed(key.hashCode());
    for (int i = 0; i < tolerant(capacity); ++i) {
      int index = random.nextInt(capacity);
      Entry entry = entries[index];
      if (entry == null) {
        return null;
      } else if (entry.key.equals(key)) {
        return (V) entry.value;
      }
    }
    return null;
  }

  public boolean containKey(final K key) {
    random.setSeed(key.hashCode());
    return entries[random.nextInt(capacity)] != null;
  }

  private static int tolerant(int capacity) {
    return capacity;
  }

}
