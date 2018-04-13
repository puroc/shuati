package baidu2017.t5;

import java.util.Scanner;

//度度熊最近对全排列特别感兴趣,对于1到n的一个排列,
//度度熊发现可以在中间根据大小关系插入合适的大于和小于符号(即 '>' 和 '<' )使其成为一个合法的不等式数列。
//但是现在度度熊手中只有k个小于符号即('<'')和n-k-1个大于符号(即'>'),度度熊想知道对于1至n任意的排列中有多少个排列可以使用这些符号使其为合法的不等式数列。
//输入描述:
//
//        输入包括一行,包含两个整数n和k(k < n ≤ 1000)
//
//
//        输出描述:
//
//        输出满足条件的排列数,答案对2017取模。
//示例1
//        输入
//
//        5 2
//        输出
//
//        66
public class Main {//没解出来

/*
 *
 * 参考大神的解题思路：https://www.nowcoder.com/test/question/done?tid=14939450&qid=95828#summary
 * 使用动态规划，真的难想，话说只有动态规划才适合此题
 *
 * dp[i][j] 表示i个序列有j个'<',对于i+1个序列，可以进行如下分析
 * 1.直接添加到最开始，此时多添加一个>,种类数+dp[i-1][j];
 * 2.直接添加到最后面，此时多添加一个<,种类数+dp[i-1][j-1];
 * 3.添加到中间任意一个<,例如1<2，变成1<3>2,多添加了一个>，种类数+dp[i-1][j]*j;
 * 4.添加到中间任意一个>，例如2>1,变成2<3>1,多添加了一个<,种类数+dp[i-1][j-1]*(i-j-1)
 * 整理可得到：dp[i][j] = dp[i-1][j]*(j+1)+dp[i-1][j-1]*(i-j)
 *
 * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] dp = new int[n + 1][k + 1];
            for (int i = 1; i <= n; i++) {
                dp[i][0] = 1;
            }
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = (dp[i - 1][j] * (j + 1) + dp[i - 1][j - 1] * (i - j)) % 2017;
                }
            }
            System.out.println(dp[n][k]);
        }
    }
}
