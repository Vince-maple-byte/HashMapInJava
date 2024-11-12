package hashmap;

import linkedlist.LinkedList;
import node.Node;

import java.util.ArrayList;
import java.util.List;

/*
* TODO: for the separate class
*  ADD A LOAD Factor
*  Resize the hash map method
*  test
*  make a separate class for linear and quadratic probing/double hashing
* */

public class HashMap<K, V> implements HashMapInterface<K, V> {

    private final int DEFAULT_BUCKET_SIZE = 50;
    private List<LinkedList<K,V>> buckets;
    private int size;

    public HashMap(){
        this.buckets = new ArrayList<>(DEFAULT_BUCKET_SIZE);
        for(int i = 0; i < DEFAULT_BUCKET_SIZE; i++){
            this.buckets.add(new LinkedList<>());
        }
        this.size = 0;
    }

    private int indexFromKey(K key) {
        return key.hashCode() % this.buckets.size();
    }

    @Override
    public void put(K key, V value) {
        Node<K,V> newNode = new Node<>(key, value);
        if(!this.containsKey(key))
            this.size++;
        buckets.get(indexFromKey(key)).add(newNode);

    }

    @Override
    public void remove(K key) {
        buckets.get(indexFromKey(key)).remove(key);
        this.size--;
    }

    @Override
    public void replace(K key, V value) {
        this.buckets.get(indexFromKey(key)).replace(key, value);
    }

    @Override
    public void removeAll() {
        this.buckets = new ArrayList<>(DEFAULT_BUCKET_SIZE);
        for(int i = 0; i < DEFAULT_BUCKET_SIZE; i++){
            this.buckets.add(new LinkedList<>());
        }
        this.size = 0;
    }

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

    @Override
    public V get(K key) {
        return buckets.get(indexFromKey(key)).get(key);
    }

    @Override
    public int size() {
        return this.size;
    }
}
