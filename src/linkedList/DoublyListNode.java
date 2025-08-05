package linkedList;

@SuppressWarnings("unused")
public class DoublyListNode<T> {
    public T data;
    public DoublyListNode<T> prev;
    public DoublyListNode<T> next;

    public DoublyListNode(T data){
        this.data = data;
        prev = null;
        next = null;
    }
}
