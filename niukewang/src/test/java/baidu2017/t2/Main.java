package baidu2017.t2;

//一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。现在他需要依次的从0号坐标走到N-1号坐标。
//        但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，问度度熊回家至少走多少距离？
//        输入描述:
//        输入一个正整数N, N <= 50。
//
//        接下来N个整数表示坐标，正数表示X轴的正方向，负数表示X轴的负方向。绝对值小于等于100
//
//
//        输出描述:
//        输出一个数表示度度熊整最少需要走的距离。
//
//        输入例子1:
//        10
//        1 2 3 4 5 6 7 8 9 10
//
//        输出例子1:
//        9

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //将输入的数据放到一个数组中
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }

        //找到应该删除的点，原理是遍历这个数组，用第3个点和第1个点之间的距离减去第1，2点和第2，3点之间的距离，当距离最大时，这个三个点的中间点就是需要删除的电
        int max =0;
        int targetIndex=0;
        for (int i = 0; i < array.length-2; i++) {
            int back = Math.abs(array[i + 2] - array[i + 1]);
            int front = Math.abs(array[i + 1] - array[i]);
            int among = Math.abs(array[i + 2] - array[i]);
            int distance = back + front - among;
            if(distance>= max){
                max=distance;
                targetIndex=i+1;
            }
        }

        //将数组中的这个点删除，其实就是将诸葛点前后的数组分别拷贝到另外一个数组中
        int sum=0;
        int[] targetArray = new int[num-1];
        int destPos=0;
        System.arraycopy(array,0,targetArray,destPos,targetIndex);
        destPos+=targetIndex;
        System.arraycopy(array,targetIndex+1,targetArray,destPos,num-1-targetIndex);


        //遍历已经删除点的数组，计算从第一个点走到最后一个点的距离
        for (int i = 0; i < targetArray.length-1; i++) {
            sum+= Math.abs(targetArray[i+1]-targetArray[i]);

        }
        System.out.println(sum);
    }

}

//    public static void main(String[] args){
//        Scanner scanner=new Scanner(System.in);
//        int length=scanner.nextInt();
//        int[]arrays=new int[length];
//        for(int i=0;i<length;i++){
//            arrays[i]=scanner.nextInt();
//        }
//        /**
//         * sum 总距离
//         * repetition  三个节点 中被重复计算的总距离
//         * select 优化距离最大的  三个节点两两相加的距离
//         * add 三个结尾距离为max 中 头尾节点的距离
//         * last最后三个节点中 尾距离没有被计算两次 需要加上
//         * optimizeDistance 优化距离
//         */
//
//        int sum=0,repetition=0,select=0,add=0,
//                last=0,optimizeDistance = 0;
//        for(int i=0;i<=arrays.length-3;i++){
//            int begin=arrays[i];
//            int mid=arrays[i+1];
//            int end=arrays[i+2];
//            //三个点之间的距离
//            int threePointDistance=Math.abs(mid-begin)
//                    +Math.abs(end-mid);
//            //两个点之间的距离  即被多次计算待会需要减掉的距离
//            int twoPointDistance=Math.abs(end-mid);
//            int contrast=threePointDistance - Math.abs(begin-end);
//
//            repetition+=twoPointDistance;
//            sum+=threePointDistance;
//            last=twoPointDistance;
//
//            if(contrast>optimizeDistance){
//                optimizeDistance = contrast;
//                select=threePointDistance;
//                add=Math.abs(end-begin);
//            }
//
//        }
//        System.out.println(sum-select+last-repetition+add);
//
//    }
