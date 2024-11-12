package hashmap;

import node.Node;

/*
 * TODO: for the separate class
 *  ADD A LOAD Factor
 *  Resize the hash map method
 *  test
 *  make a separate class for linear and quadratic probing/double hashing
 * */

public class HashMapLinear<K,V> implements HashMapInterface<K,V>{

    private Node<K,V>[] buckets;
    private int size;
    private final int DEFAULT_BUCKET_SIZE=50;
    private double loadFactor;

    @SuppressWarnings("unchecked")
    public HashMapLinear(){
        this.buckets = (Node<K, V>[]) new Node[DEFAULT_BUCKET_SIZE];
        this.size = 0;
        this.loadFactor = 0.75;
    }
    @Override
    public void put(K key, V value) {

    }

    @Override
    public void remove(K key) {

    }

    @Override
    public void replace(K key, V value) {

    }

    @Override
    public void removeAll() {

    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void resize() {

    }

    private int indexFromKey(K key) {
        return key.hashCode() % this.buckets.length;
    }
}
