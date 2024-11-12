package hashmap;

public interface HashMapInterface<K,V> {

    public void put(K key, V value);
    public void remove(K key);
    public void replace (K key, V value);
    public void removeAll();
    public boolean containsKey(K key);
    public V get(K key);
    public int size();

}
