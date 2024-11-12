package hashmap;

public interface HashMapInterface<K,V> {

    /**
     * Adds new key-value pair
     * @param key The key to be added
     * @param value The value
     */
    public void put(K key, V value);

    /**
     * Removes a key-value pair with the provided key
     * @param key The key value
     */
    public void remove(K key);

    /**
     * The value that is going to be updated in the key-value pair
     * @param key The key value
     * @param value The updated value.
     */
    public void replace (K key, V value);

    /**
     * Remove all key-value pairs
     */
    public void removeAll();

    /**
     * Checks if the key is in the hash map
     * @param key The key to check
     * @return Returns true if the key is valid.
     */
    public boolean containsKey(K key);

    /**
     * Retrieves the value in the key-value pair
     * @param key The key to access the value
     * @return The value for the corresponding key.
     */
    public V get(K key);

    /**
     * The size of the hash map
     * @return Returns the hash map size.
     */
    public int size();

    /**
     * Resizes the array when the hash map size is larger that the load factor.
     * Explain in more detail in each of the different implementations.
     */
    public void resize();

}
