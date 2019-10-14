package buildings;

public class Node<Office> {
    Node next;
    Office value;

    Node(){}

    Node(Node<Office> next, Office e){
        this.next = next;
        this. value = e;
    }
}
