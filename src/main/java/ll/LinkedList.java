package ll;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public void removeDuplicates() {

        Set<Integer> set = new HashSet<>();
        Node current = getHead();
        Node prev = null;

        while(current != null){


            if(set.contains(current.value)){

                prev.next = current.next;
                length--;

                Node temp = current.next;
                current.next = null;
                current = temp;
            }else{

                set.add(current.value);
                prev = current;

                current = current.next;
            }

        }
    }

    public int binaryToDecimal(){

        Node current = head;
        int sum = 0;
        int index = length -1;

        while(current != null){
            double value = Math.pow(2, index--) * current.value;
            sum += (double) value;
            current = current.next;
        }

        return sum;
    }

    /***
     * Trick
     * To convert from binary to decimal from right to left ,
     * double the current value of sum and then and the current node value
     */

    public int binaryToDecimalB(){

        Node current = head;
        int sum = 0;

        while(current != null){
            sum = (sum * 2) + current.value;
            current = current.next;
        }

        return sum;
    }


    public void reverseBetween(int m, int n) {
        // Your implementation here

    }

}
