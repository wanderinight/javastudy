package queue;

/**
 * 基于链表的队列实现
 */
public class LinkedQueue<E> {
    //node
    private static class Node<E>{
        E data;
        Node<E> next;

        public Node(E data){
            this.data = data;
        }
    }

    private Node<E> head;//队首指针
    private Node<E> tail;//队尾指针
    private int size;
    public LinkedQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    //入队操作
    public boolean offer(E item){
        Node<E> newNode = new Node<>(item);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }


    //出队操作
    public E poll(){
        if(isEmpty()){
            return null;
        }
        E item = head.data;
        head = head.next;
        if(head ==null){
            tail = null;
        }
        size--;
        return item;
    }

    //查看队首元素
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return head.data;
    }

    //判断是否为空
    public boolean isEmpty(){
        return head == null;
    }

    //获取队列大小
    public int size(){
        return size;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while(current != null){
            sb.append(current.data);
            if(current.next != null){
                sb.append(",");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
