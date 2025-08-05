package array;

import java.util.Arrays;

@SuppressWarnings("unused")
public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;//元素个数

    //构造器
    public MyArrayList(){
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int initialCapacity){
        if(initialCapacity>0){
            this.elementData = new Object[initialCapacity];
        }else{
            throw new IllegalArgumentException("Illegal Capacity" + initialCapacity);
        }
        this.size = 0;
    }

    //add
    public boolean add(E e){
        ensureCapacity(size +1);
        elementData[size++] = e;
        return true;
    }

    //insert
    public void add(int index,E element){
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        //移动index后
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index] = element;
        size++;
    }

    //search
    @SuppressWarnings("unchecked")
    public E get(int index){
        rangeCheck(index);
        return (E)elementData[index];
    }

    //delete
    @SuppressWarnings("unchecked")
    public E remove(int index){
        rangeCheck(index);
        E oldValue = (E)elementData[index];

        int numMoved = size - index -1;
        if(numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    //查找元素索引
    public int indexOf(Object o){
        if(o == null){
            for(int i=0;i<size;i++){
                if(elementData[i] == null){
                    return i;
                }
            }
        }else{
            for(int i=0;i<size;i++){
                if(o.equals(elementData[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    //count
    public int size() {
        return size;
    }

    //索引检查
    private void rangeCheck(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Index: "+index+" ,Size:" +size);
        }
    }
    private void rangeCheckForAdd(int index){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("Index: "+index+" ,Size:" +size);
        }
    }

    //扩容机制
    private void ensureCapacity(int minCapacity){
        if(minCapacity-this.elementData.length>0){
            int oldCapacity = this.elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);//1.5倍扩容
            if(newCapacity - minCapacity<0){
                newCapacity = minCapacity;
            }
            this.elementData = Arrays.copyOf(this.elementData, newCapacity);
        }
    }

    //打印
    @Override
    public String toString(){
        if(size == 0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i=0; i < size; i++){
            sb.append(elementData[i]);
            if(i == size-1){
                sb.append(']');
            }else{
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
//测试用例
//array.MyArrayList<Integer> list = new array.MyArrayList<>();
//        System.out.println("initial list :  " + list);
//        System.out.println("initial size : " + list.size());
//
//        for (int i = 0; i < 15; i++) {
//        list.add(i * 2); // 测试自动扩容
//        }
//                System.out.println("afteradd list :  " + list);
//        System.out.println("afteradd size : " + list.size());
//
//        list.add(3,666);
//        System.out.println("afterinsert list :  " + list);
//        System.out.println("afterinsert size : " + list.size());
//
//        System.out.println("search index 10 :  " + list.indexOf(10));
//
//int removed = list.remove(5);
//        System.out.println("Removed element: " + removed);
//        System.out.println("After removal: " + list);
//
//// 搜索元素
//int index = list.indexOf(20);
//        System.out.println("Index of 20: " + index);
//
//// 边界测试
//        try {
//                list.add(100, 100); // 越界插入
//        } catch (IndexOutOfBoundsException e) {
//        System.out.println("Caught: " + e.getMessage());
//        }
//是的，当您使用 System.out.println() 打印对象时，
// Java 会自动调用该对象的 toString() 方法。这就是为什么您重写 toString() 后，可以直接用 println 打印自定义列表的原因。