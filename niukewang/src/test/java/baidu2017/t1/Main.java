package baidu2017.t1;

//度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
//        输入描述:
//        首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）
//
//        输出描述:
//        如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1
//
//        输入例子1:
//        40
//        1 1 1 1 1 1 1 1000 1 1 1 1 1 2 1 1 1 999 1 1 1 1 1 1 1 2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//
//        输出例子1:
//        999


import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

   static  class MyComparator implements Comparator<Integer> {

        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new MyComparator());
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.next());
        for (int i = 0; i < num; i++) {
            treeSet.add(Integer.parseInt(scanner.next()));
        }

        if (treeSet.size() < 3) {
            System.out.println(-1);
        } else {
            Object[] array = treeSet.toArray();
            System.out.println(array[2]);
        }
    }
}