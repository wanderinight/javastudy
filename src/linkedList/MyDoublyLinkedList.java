package linkedList;

import java.util.NoSuchElementException;

@SuppressWarnings({"unused","FieldCanBeLocal"})
public class MyDoublyLinkedList <T>{
    private DoublyListNode<T> head;
    private DoublyListNode<T> tail;
    private int size;

    public MyDoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    //头部插入
    public void addFirst(T data){
        DoublyListNode<T> newNode = new DoublyListNode<>(data);
        if(head == null){
            head = tail = newNode;
        } else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    //尾部tail插入
    public void addlast(T data){
        if(head == null){
            addFirst(data);
            return;
        }
        DoublyListNode<T> newNode = new DoublyListNode<>(data);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    //在指定位置插入
    public void add(int index,T data){
        rangeCheck(index);
        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size){
            addlast(data);
            return;
        }

        DoublyListNode<T> current = getNode(index);
        DoublyListNode<T> newNode = new DoublyListNode<>(data);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    //删除头部
    public T removeFirst(){
        if(head == null){
            throw new NoSuchElementException();
        }
        T removeData = head.data;
        if(head == tail){
            head = tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
        }
        size--;
        return removeData;
    }

    //删除尾部
    public T removeLast(){
        if(head == null){
            throw new NoSuchElementException();
        }
        if(head == tail){
            return removeFirst();
        }
        T removeData = tail.data;
        tail= tail.prev;
        tail.next = null;
        size--;
        return removeData;
    }

    //删除指定位置
    public T remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: "+index+" ,Size:" +size);
        }
        if(index == 0){
            return removeFirst();
        }
        if(index == size - 1){
            return removeLast();
        }
        DoublyListNode<T> current = getNode(index);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return current.data;
    }

    //搜索
    public boolean contains(T data){
        DoublyListNode<T> current = head;
        while(current != null){
            if(current.data.equals(data)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //反转链表--交换指针指向
    public void reverse(){
        DoublyListNode<T> current = head;
        DoublyListNode<T> tmp = null;
        while(current != null){
            tmp = current.prev;
            current.prev = current.next;
            current.next = tmp;
            current = current.prev;
        }
        if(tmp != null){
            head = tmp.prev;
        }
    }

    //获取指定位置的节点
    private DoublyListNode<T> getNode(int index){
        rangeCheck(index);
        DoublyListNode<T> current;
        if(index < size / 2){
            current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
        }else{
            current = tail;
            for(int i = size - 1; i > index; i--){
                current = current.prev;
            }
        }
        return current;
    }

    //获取大小
    public int size(){
        return size;
    }

    //索引检查
    private void rangeCheck(int index){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("Index: "+index+" ,Size:" +size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        DoublyListNode<T> current = head;
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
//测试用例：：
//MyDoublyLinkedList<Integer> linkedList = new MyDoublyLinkedList<>();
//        linkedList.addFirst(1);
//        linkedList.addlast(4);
//        linkedList.add(1,2);
//        linkedList.add(2,3);
//        System.out.println("initial doublelinkedlist : " + linkedList);
//
//        linkedList.removeFirst();
//        System.out.println("remove first : " + linkedList);
//
//        linkedList.addlast(5);
//        linkedList.reverse();
//        System.out.println("反转后: " + linkedList);
//
//// 搜索
//        System.out.println("包含4? " + linkedList.contains(4)); // true
//        System.out.println("包含9? " + linkedList.contains(9)); // false
////        initial doublelinkedlist : [1, 2, 3, 4]
////        remove first : [2, 3, 4]
////        反转后: [5, 4, 3, 2]
////        包含4? true
////        包含9? false