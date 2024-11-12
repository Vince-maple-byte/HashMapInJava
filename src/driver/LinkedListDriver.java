package driver;

import linkedlist.LinkedList;
import node.Node;

public class LinkedListDriver {



    public static void main(String[] args){
        Node<String, String> firstNode = new Node<>("1", "Hellos");
        Node<String, String> secondNode = new Node<>("2", "Second");
        Node<String, String> thirdNode = new Node<>("3", "Thh");
        LinkedList<String, String> linkedList = new LinkedList<>(firstNode);

        System.out.println(linkedList.remove("1"));
        System.out.println(linkedList.get("1"));

        linkedList.add(firstNode);
        linkedList.add(secondNode);
        linkedList.add(thirdNode);
//        System.out.println(linkedList.get(2));
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.remove(1));
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.get(1));
        System.out.println(linkedList.size());

        Node<String, String> curr = linkedList.getHead();
        while(curr != null){
            System.out.println(curr.getValue());
            curr = curr.getNext();
        }
    }
}
