package 牛客网.二零一九年校招;

import java.util.Scanner;

/**
 * 题目描述
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 * <p>
 * 但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 * <p>
 * 输入描述:
 * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 * 输出描述:
 * 对于每个测试用例, 输出一个正整数表示可能的数对数量。
 * <p>
 * 示例1
 * 输入
 * 5 2
 * 输出
 * 7
 * 说明
 * 满足条件的数对有(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
 */
public class 数对 {
    /*

    x可以在 [1, n] 上取，但是y只能在 [k, n]上取，因为k以下都不存在大于等于k的余数。
    所以遍历y，对于每一个y，统计符合的x的个数，加到count里。

    先假设x可以从 [0, n]中取值，那么这段区间至少可以分成(n/k)个完整的、长度为y的区间。
    x = 【0，1……y-2，y-1】【y，y+1，……，2y-2，2y-1】……【……】……【……，n】
    在每个小区间a上，第i个数a[i]%y的余数是i。这样每一小段上大于等于k的x有y-k个（显然当k=0时，y个数都满足题意）。
    【0，1，……，k，k+1，……，y-1】

    这样，已经遍历的总数是(n/y)*y，而其中满足条件的x的总数是（n/y）*（y-k）
    因为n = (n/y)*y + n%y
    所以还没遍历的数有 n+1-(n/y)*y = n+1 - (n - n%y) = 1+n%y 个，令它为t。
    因为n%y∈[0, y-1]， 则t∈[1, y]。

    也就是说我这种方法，至少剩了一个数，至多会把一个整区间（数量为y）都剩下来。
    但是无论如何，这个区间last的第i个数last[i]%y一定是i。则最后一个数（n）的余数就是n%y。
    如此一来，此区间内从 [k,n%y] 包含共计 n%y-k+1 个数。不过如果算出小于0的数，则不需要减回去，直接当没有就可以了。
    所以最后一个区间里包含了 max(n%y-k+1, 0) 个满足条件的x。

    最后注意，这里实际上枚举了x∈ [0, n]所有的数字，当k==0的时候，多统计了一个0，必须减掉。*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int result = 0;
        /*for (int x = 1; x <= n; x++) {      //双层循环算法超时    只有10%通过
            for (int y = 1; y <= n; y++) {
                if (x % y >= k) {
                    result++;
                }
            }
        }*/
/*        for (int x = 1; x <= n; x++) {
            for (int y = k; y <= n; y++){       //只有10%通过
                if (x % y >= k){
                    result++;
                }
            }
        }*/
        if (k == 0) {
            result = n * n;
        } else {
            for (int y = k + 1; y <= n; y++) {
                result += (n / y) * (y - k);
                if (n % y >= k) {
                    result += n % y - k + 1;
                }
            }
        }
        System.out.println(result);
    }

}
