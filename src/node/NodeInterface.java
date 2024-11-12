package node;

public interface NodeInterface<K, V> {

    public V getValue();
    public K getKey();
    public Node<K,V> getNext();
    public void setValue(V value);
    public void setNext(Node<K,V> next);
    public void setKey(K key);
}
