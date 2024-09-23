package udemy.datastructures;

public class LinkedList {

    private Node head;
    private Node tail;
    int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;
    }


    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        length++;
    }

    public void removeLast() {

        Node currentNode = head;
        if (length < 2) {
            head = null;
            tail = null;
            return;
        }

        while (currentNode.next != tail) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        tail = currentNode;
        length--;
    }


    public void print() {
        if (length == 0)
            return;
        Node currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.value + "=>");
            currentNode = currentNode.next;
        }

        System.out.println("---");
    }

    //21=>22=>23
    public void reverse() {

        Node current = head;
        tail = head;
        Node temp;
        Node prev = null;

        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        head = prev;
        
    }


    public static void main(String... args) {

        //21=>
        LinkedList ll = new LinkedList(21);
        ll.append(22);
        ll.append(23);
        ll.append(24);
        ll.print();
        ll.removeLast();
        ll.print();
        ll.reverse();
        ll.print();

    }


}

