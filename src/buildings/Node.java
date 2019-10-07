package buildings;

public class Node<E> {
    Node<E> next;
    Node<E> previous;
    E value;
    Boolean head;

    Node(){}

    Node(Node<E> next, Node<E> previous, E e, Boolean head){
        this.next = next;
        this.previous = previous;
        this. value = e;
        this.head = head;
    }
}
