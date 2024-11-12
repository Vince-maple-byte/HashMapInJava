package node;

public class Node<K, V> implements NodeInterface<K,V>{

    private K key;
    private V value;
    private Node<K,V> next;

    public Node(){
        this.key = null;
        this.value = null;
        this.next = null;
    }

    public Node(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public Node(K key, V value, Node<K,V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }
    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public Node<K, V> getNext() {
        return this.next;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    @Override
    public void setKey(K key) {
        this.key = key;


    }


}
