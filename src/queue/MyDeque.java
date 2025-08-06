package queue;

import java.util.NoSuchElementException;

/**
 * 双端队列实现 (基于双向链表)
 */
public class MyDeque<E> {
    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyDeque() {
        head = null;
        tail = null;
        size = 0;
    }

    // 队首入队 - O(1)
    public void addFirst(E item) {
        Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // 队尾入队 - O(1)
    public void addLast(E item) {
        Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // 队首出队 - O(1)
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return item;
    }

    // 队尾出队 - O(1)
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = tail.data;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return item;
    }

    // 查看队首元素 - O(1)
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    // 查看队尾元素 - O(1)
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.data;
    }

    // 判断队列是否为空 - O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // 获取队列大小 - O(1)
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}