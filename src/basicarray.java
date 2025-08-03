//import java.util.Arrays;
//新建--插入--查询--二分查找--delete同理
//
//int[] arr =new int[10];
//String[] strArr ={"A","B","C"};
//
//        System.out.println(arr[0]);
//        System.out.println(strArr[1]);
//
//arr[1]=10;
//        System.out.println("arr[1]:"+arr[1]);
//
//        Arrays.sort(arr);
//int index= Arrays.binarySearch(arr,10);
//        System.out.println("index of 10 at"+index);
//
//int[] newArr=insertElement(arr,99,3);
//        System.out.println(Arrays.toString(newArr));
//        }
//
//public static int[] insertElement(int[] arr, int element, int index) {
//    int[] newArr=new int[arr.length+1];
//    System.arraycopy(arr,0,newArr,0, index);
//    newArr[index]=element;
//    System.arraycopy(arr, index, newArr, index + 1, arr.length - index);
//    return newArr;
//}
