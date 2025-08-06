package queue;

/**
 * 基于数组的循环队列实现--circular-queue
 */
public class ArrayQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int front;//队首指针
    private int rear;//队尾指针
    private int size;

    public ArrayQueue(){
        elements = new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }
    //入队操作
    public boolean offer(E item){
        if(isFull()){
            resize(2 * elements.length);
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = item;
        size++;
        return true;
    }

    //出队操作
    @SuppressWarnings("unchecked")
    public E poll(){
        if(isEmpty()){
            return null;
        }
        E item = (E) elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return item;
    }

    //查看队首元素
    @SuppressWarnings("unchecked")
    public E peek(){
        if(isEmpty()){
        return null;
        }
        return (E) elements[front];
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //判断队列是否已满
    public boolean isFull(){
        return size == elements.length;
    }

    //获取队列大小
    public int size(){
        return size;
    }

    //动态扩容
    private void resize(int newCapacity){
        Object[] newArray = new Object[newCapacity];
        for(int i = 0; i <elements.length; i++){
            newArray[i] = elements[(front + i) % elements.length] ;
        }
        elements = newArray;
        front = 0;
        rear = size - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % elements.length;
            sb.append(elements[index]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
