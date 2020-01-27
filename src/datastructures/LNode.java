package datastructures;

public class LNode<T> {

    public T value;
    public LNode<T> next;

    public LNode(T value) {
        this.value = value;
        this.next = null;
    }
}
