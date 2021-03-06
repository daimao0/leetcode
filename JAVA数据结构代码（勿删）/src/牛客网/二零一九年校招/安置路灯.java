package 牛客网.二零一九年校招;

import java.util.Scanner;

/**
 * 题目描述
 * 小Q正在给一条长度为n的道路设计路灯安置方案。
 * <p>
 * 为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。
 * <p>
 * 小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。
 * <p>
 * 小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。
 * <p>
 * 输入描述:
 * 输入的第一行包含一个正整数t(1 <= t <= 1000), 表示测试用例数
 * 接下来每两行一个测试数据, 第一行一个正整数n(1 <= n <= 1000),表示道路的长度。
 * 第二行一个字符串s表示道路的构造,只包含'.'和'X'。
 * <p>
 * 输出描述:
 * 对于每个测试用例, 输出一个正整数表示最少需要多少盏路灯。
 * <p>
 * 示例1
 * 输入
 * 2
 * 3
 * .X.
 * 11
 * ...XX....XX
 * <p>
 * 输出
 * 1
 * 3
 */
public class 安置路灯 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();      //t 表示测试用例数
        int[] array = new int[t];       //array表示存储每条路的最小路灯数（结果集）
        for (int i=0;i<t;i++){
            int n = scanner.nextInt();      //n 表示道路长度
            String roads = scanner.next();      //输入道路
            for (int j=0;j<roads.length();j++){
                char item = roads.charAt(j);
                if (item=='.'){     //贪心算法：只要存在第一个需要照亮的区域，就表示其后面两个都要被照亮（无论需不需要）
                    array[i]++;
                    j+=2;
                }
            }
        }

        for (int i:array){
            System.out.println(i);
        }
    }
}
