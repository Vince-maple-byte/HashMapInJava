package linkedlist;

import node.Node;

import java.util.Iterator;

public interface LinkedListInterface<K,V> {
    public int size();
    public boolean isEmpty();
    public void add(Node<K,V> node);
    public V remove(K key);
    public V get(K key);
    public void replace(K key, V value);
    public void removeAll();

}
