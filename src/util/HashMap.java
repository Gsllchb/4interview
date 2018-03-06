package util;

import java.util.LinkedList;
import java.util.ListIterator;

public class HashMap<K, V> {
  private static final int CAPACITY = 1 << 10;
  private LinkedList<MapEntry>[] buckets;
  private int size;

  public HashMap() {
    buckets = new LinkedList[CAPACITY];
    for (int i = 0; i < CAPACITY; ++i) {
      buckets[i] = new LinkedList();
    }
    size = 0;
  }

  public void put(final K key, final V value) {
    LinkedList<MapEntry> list = buckets[getIndex(key.hashCode())];
    for (MapEntry entry: list) {
      if (entry.key.equals(key)) {
        entry.value = value;
        return;
      }
    }
    list.addFirst(new MapEntry(key, value));
    ++size;
  }

  public V get(final K key) {
    LinkedList<MapEntry> list = buckets[getIndex(key.hashCode())];
    for (MapEntry entry: list) {
      if (entry.key.equals(key)) {
        return (V) entry.value;
      }
    }
    return null;
  }

  public V remove(final K key) {
    ListIterator<MapEntry> iterator = buckets[getIndex(key.hashCode())].listIterator();
    while (iterator.hasNext()) {
      MapEntry entry = iterator.next();
      if (entry.key.equals(key)) {
        iterator.remove();
        --size;
        return (V) entry.value;
      }
    }
    return null;
  }

  public boolean containsKey(final K key) {
    LinkedList<MapEntry> list = buckets[getIndex(key.hashCode())];
    for (MapEntry entry: list) {
      if (entry.key.equals(key)) {
        return true;
      }
    }
    return false;
  }

  public V getOrDefault(final K key, V defaultValue) {
    V res = get(key);
    return res == null ? defaultValue : res;
  }

  public int size(){
    return size;
  }

  private int getIndex(int hashCode) {
    return hashCode & (CAPACITY - 1);
  }

  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<String, String>();
    map.put("a", "A");
    assert map.get("a").equals("A");
    map.put("b", "B");
    assert map.size() == 2;
    map.put("a", "AA");
    assert map.size() == 2;
    assert map.get("a").equals("AA");
    assert map.containsKey("b");
    assert map.remove("b").equals("B");
    assert !map.containsKey("b");
    assert map.size() == 1;
    assert map.getOrDefault("b", "BB").equals("BB");
  }
}
