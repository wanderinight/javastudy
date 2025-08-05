package stack;

import java.util.EmptyStackException;

public class ArrayStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int top;

    public ArrayStack() {
        elements = new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    //入栈--扩容
    public void push(Object o){
        if(top == elements.length - 1){
            resize(2 + elements.length)
        }
        elements[++top] = o;
    }

    //出栈
    @SuppressWarnings("unchecked")
    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E item = (E)elements[top];
        elements[top--] = null;
        return item;
    }

    //查看栈顶元素
    @SuppressWarnings("unchecked")
    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return (E)elements[top];
    }


    //判断栈是否为空
    public boolean isEmpty(){
        return top == -1;
    }

    //获取栈大小
    public int size(){
        return top + 1;
    }

    //动态扩容
    private void resize(int newCapacity){
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, top);
        elements = newArray;
    }

    //tostring
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i <= top; i++) {
            sb.append(elements[i]);
            if (i < top) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
