package stack;

import java.util.EmptyStackException;

public class LinklistStack<E> {
    //基于单链表实现
    private static class Node<E>{
        E data;
        Node<E> next;

        Node(E data){
            this.data = data;
        }
    }

    private Node<E> top;
    private int size;
    public LinklistStack(){
        top = null;
        size = 0;
    }
    //入栈
    public void push(E item){
        Node<E> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    //出栈
    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E item = top.data;
        top = top.next;
        size--;
        return item;
    }

    //查看栈顶元素
    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }
    //判断是否为空
    public boolean isEmpty(){
        return top == null;
    }
    //获取大小
    public int size(){
        return size;
    }
    //输出
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = top;
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
