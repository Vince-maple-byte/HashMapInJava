package hashmap;

import linkedlist.LinkedList;
import node.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * A Hash map that uses separate chaining to deal with hash collisions
 *
 * @param <K> K represents the Key
 * @param <V> V represents the Value
 * @author Vince-maple-byte
 * @see <a href="https://github.com/Vince-maple-byte/HashMapInJava/tree/master">Github Link</a>
 * @version 1.0
 */

public class HashMap<K, V> implements HashMapInterface<K, V> {


    /**
     * Default size
     */
    private final int DEFAULT_BUCKET_SIZE = 50;

    /**Where all the Linked lists that store the key value pairs will be stored.
     *
     */
    private List<LinkedList<K,V>> buckets;

    /**
     * The size of the array
     */
    private int size;

    /**
     * The default constructor.
     */
    public HashMap(){
        this.buckets = new ArrayList<>(DEFAULT_BUCKET_SIZE);
        for(int i = 0; i < DEFAULT_BUCKET_SIZE; i++){
            this.buckets.add(new LinkedList<>());
        }
        this.size = 0;
    }

    /**
     * The method to determine and retrieve what index in the array to store the key value pairs
     * @param key The key to hash.
     * @return The index where the Key value pair should be stored.
     */
    private int indexFromKey(K key) {
        return key.hashCode() % this.buckets.size();
    }

    /**
     * This is an insertion method that adds key value pair into the hash map.
     * By default, when a node that contains the same key value is added into the linked list it would just update the value instead of
     * creating a new key value pair with the same key.
     * @param key The Key to be accessed in the future
     * @param value The value that is stored and accessed with the K key.
     */
    @Override
    public void put(K key, V value) {
        Node<K,V> newNode = new Node<>(key, value);
        if(!this.containsKey(key))
            this.size++;
        buckets.get(indexFromKey(key)).add(newNode);

    }

    /**
     * This is method removes a key value pair in the hash map using the provided key
     * @param key The key value.
     * @throws NoSuchElementException If the key provided does not exist.
     */
    @Override
    public void remove(K key) throws NoSuchElementException {
        if(this.containsKey(key) ){
            buckets.get(indexFromKey(key)).remove(key);
            this.size--;

        }
        else throw new NoSuchElementException("Key is invalid");
    }

    /**
     * This method replaces the current value in the key value pair with the value given in the parameter.
     * The key is used to determine which key value pair we are working with.
     * @param key The key value.
     * @param value The new updated value.
     * @throws NoSuchElementException If the key provided does not exist.
     */
    @Override
    public void replace(K key, V value) throws NoSuchElementException{
        if(this.containsKey(key))
            this.buckets.get(indexFromKey(key)).replace(key, value);
        else
            throw new NoSuchElementException("Key is invalid");
    }

    /**
     * Removes all the key value pairs in the hash map.
     */
    @Override
    public void removeAll() {
        this.buckets = new ArrayList<>(DEFAULT_BUCKET_SIZE);
        for(int i = 0; i < DEFAULT_BUCKET_SIZE; i++){
            this.buckets.add(new LinkedList<>());
        }
        this.size = 0;
    }

    /**
     * Checks if the key in the parameter is in the hash map or not.
     * @param key The key being checked.
     * @return Returns true if the key is in the hash map, else returns false.
     */
    @Override
    public boolean containsKey(K key) {
        for (LinkedList<K, V> bucket : buckets) {
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(key) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Retrieves the value from the key value pair.
     * @param key The key value.
     * @return The value of the key value pair.
     * @throws NoSuchElementException If the key provided does not exist.
     */
    @Override
    public V get(K key) throws NoSuchElementException{
        if(this.containsKey(key))
            return buckets.get(indexFromKey(key)).get(key);
        else
            throw new NoSuchElementException("Key is invalid");
    }

    /**
     * Size of the hash map
     * @return The size of the hash map.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Not used
     */
    @Override
    public void resize() {
        return;
    }
}
