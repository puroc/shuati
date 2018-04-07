package jianzhioffer;

import org.junit.Assert;
import org.junit.Test;

public class T1 {


//    在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。


    private int[][] array={{1,2,3,4,5},{6,7,8,9,10}};

    private int target = 5;

    @Test
    public void test() {
        Assert.assertTrue(find(5,array));
    }

    public static boolean find(int target, int [][] array) {
        int rowLength = array.length;
        int columnLength = array[0].length;
        boolean result = false;
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<columnLength;j++){
                if(array[i][j]==target){
                    return true;
                }
            }
        }
        return result;
    }
}
