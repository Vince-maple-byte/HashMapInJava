package driver;

import node.Node;

public class NodeDriver {

    public static void main(String[] args){
        Node<Integer, String> firstNode = new Node<>(1, "Hellos");
        Node<Integer, String> secondNode = new Node<>(2, "Second");

        firstNode.setNext(secondNode);

        System.out.println(firstNode.getKey());
        System.out.println(firstNode.getValue());
        System.out.println(firstNode.getNext().getKey());
        System.out.println(firstNode.getNext().getValue());
    }
}
