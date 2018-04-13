package baidu2017.t4;

//度度熊有一个N个数的数组，他想将数组从小到大 排好序，但是萌萌的度度熊只会下面这个操作：
//        任取数组中的一个数然后将它放置在数组的最后一个位置。
//        问最少操到作多少次可以使得数组从小大有序？
//输出描述:
//
//        输出一个整数表示最少的操作次数。
//        示例1
//        输入
//
//        9
//        2 1 3 4 5 6 7 8 9
//        输出
//
//        8

import java.util.Scanner;


public class Main {//测试用例没有全通过

    public static void main(String[] args) {
        //将输入的数字放入到数组中
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }

        boolean flag =false;
        int sum = 0;
        int length = array.length;

        //遍历数组，如果第一个元素比第二个元素大，则将这个元素放到数组尾部，并增加一次计数
        while (!flag) {
            for (int i = 0; i < length - 1; i++) {
                boolean isChange= false;
                //如果这个元素大于下一个元素
                if (array[i] > array[i + 1]) {
                    //计数增加1
                    sum++;
                    isChange=true;
                    //将这个元素放到数组尾部，数组其余元素依次向前移动一位
                    int tmp = array[i];
                    for (int j = i; j < array.length - 1; j++) {
                        array[j] = array[j + 1];
                    }
                    array[length - 1] = tmp;
                }
                if(!isChange){
                    flag=true;
                }
                break;
            }
        }
        System.out.println(sum);

    }
}
