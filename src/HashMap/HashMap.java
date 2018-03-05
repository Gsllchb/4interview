package HashMap;

import java.util.LinkedList;
import java.util.ListIterator;

public class HashMap<K, V> {
  private static final int CAPACITY = 1 << 10;
  private LinkedList<Entry>[] buckets;
  private int size;

  public HashMap() {
    buckets = new LinkedList[CAPACITY];
    for (LinkedList list: buckets) {
      list = new LinkedList();
    }
    size = 0;
  }

  public void put(final K key, final V value) {
    buckets[getIndex(key.hashCode())].addFirst(new Entry(key, value));
    ++size;
  }

  public V get(final K key) {
    LinkedList<Entry> list = buckets[getIndex(key.hashCode())];
    for (Entry entry: list) {
      if (entry.key.equals(key)) {
        return (V) entry.value;
      }
    }
    return null;
  }

  public V remove(final K key) {
    ListIterator<Entry> iterator = buckets[getIndex(key.hashCode())].listIterator();
    while (iterator.hasNext()) {
      Entry entry = iterator.next();
      if (entry.key.equals(key)) {
        iterator.remove();
        return (V) entry.value;
      }
    }
    return null;
  }

  public boolean containsKey(final K key) {
    LinkedList<Entry> list = buckets[getIndex(key.hashCode())];
    for (Entry entry: list) {
      if (entry.key.equals(key)) {
        return true;
      }
    }
    return false;
  }

  private int getIndex(int hashCode) {
    return hashCode & (CAPACITY - 1);
  }
}
