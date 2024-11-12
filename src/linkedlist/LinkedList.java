package linkedlist;

import node.Node;

import java.util.Iterator;

public class LinkedList<K, V> implements LinkedListInterface<K,V>{

    private Node<K,V> head;
    private Node<K,V> tail;
    private int size;

    public LinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public LinkedList(Node<K,V> head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    public LinkedList(Node<K,V> head, Node<K,V> tail) {
        this.head = head;
        this.tail = tail;
        this.size = 2;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void add(Node<K, V> node) {
        if(isEmpty()) {
            this.head = node;
            this.tail = node;
            this.size++;
        }
        else if(this.size == 1){
            this.tail = node;
            this.head.setNext(node);
            this.size++;
        }
        else if(this.get(node.getKey()) != null){
            replace(node.getKey(), node.getValue());
        }
        else {
            this.tail.setNext(node);
            this.tail = node;
            this.size++;
        }
    }

    @Override
    public V remove(K key) {
        if(this.isEmpty() ){
            throw new NullPointerException("The LinkedList is empty need to add elements before removing");
        }
        Node<K, V> curr = this.head;
        Node<K, V> prev = null;

        while(curr != null){
            if(curr.getKey().equals(key) && prev != null) {
                V removeValue = curr.getValue();
                prev.setNext(curr.getNext());
                curr.setNext(null);
                this.size--;
                return removeValue;
            }
            else if(curr.getKey().equals(key) && prev == null){
                V removeValue = curr.getValue();
                this.head = this.head.getNext();
                curr.setNext(null);
                this.size--;
                return removeValue;
            }
            prev = curr;
            curr = curr.getNext();
        }

        return null;

    }

    @Override
    public V get(K key) {
        if(getNode(key) == null){
            return null;
        }
        else {
            return getNode(key).getValue();
        }

    }

    @Override
    public void replace(K key, V value) {
        Node<K,V> replace = this.getNode(key);
        replace.setValue(value);
    }

    @Override
    public void removeAll() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    private Node<K,V> getNode(K key){
        Node<K,V> currPointer = this.head;
        while(currPointer != null){
            if(currPointer.getKey().equals(key)){
                break;
            }
            currPointer = currPointer.getNext();
        }
        return currPointer;
    }

    public Node<K,V> getHead(){
        return this.head;
    }
}
