import java.util.Arrays;


//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        System.out.println("initial list :  " + list);
        System.out.println("initial size : " + list.size());

        for (int i = 0; i < 15; i++) {
            list.add(i * 2); // 测试自动扩容
        }
        System.out.println("afteradd list :  " + list);
        System.out.println("afteradd size : " + list.size());

        list.add(3,666);
        System.out.println("afterinsert list :  " + list);
        System.out.println("afterinsert size : " + list.size());

        System.out.println("search index 10 :  " + list.indexOf(10));

        int removed = list.remove(5);
        System.out.println("Removed element: " + removed);
        System.out.println("After removal: " + list);

        // 搜索元素
        int index = list.indexOf(20);
        System.out.println("Index of 20: " + index);

        // 边界测试
        try {
            list.add(100, 100); // 越界插入
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
