/**
 * @description:
 * 给定一个表示分数加减运算的字符串 expression，你需要返回一个字符串形式的计算结果。
 *
 * 这个结果应该是不可约分的分数，即最简分数。如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 *
 * 示例 1:
 * 输入: expression = "-1/2+1/2"
 * 输出: "0/1"
 * 示例 2:
 * 输入: expression = "-1/2+1/2+1/3"
 * 输出: "1/3"
 * 示例 3:
 * 输入: expression = "1/3-1/2"
 * 输出: "-1/6"
 *
 * 提示:
 * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。
 * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
 * 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。如果分母是1，意味着这个分数实际上是一个整数。
 * 输入的分数个数范围是 [1,10]。
 * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
 */
class Solution10 {
    public String fractionAddition(String expression) {
        long x = 0, y = 1; // 初始分子和分母
        int index = 0, n = expression.length();

        while (index < n) {
            // 读取分子
            long x1 = 0, sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while (index < n && Character.isDigit(expression.charAt(index))) {
                x1 = x1 * 10 + (expression.charAt(index) - '0');
                index++;
            }
            x1 *= sign;

            // 检查是否有分母
            long y1 = 1;
            if (index < n && expression.charAt(index) == '/') {
                index++; // 跳过 '/'
                y1 = 0;
                while (index < n && Character.isDigit(expression.charAt(index))) {
                    y1 = y1 * 10 + (expression.charAt(index) - '0');
                    index++;
                }
            }

            // 通分并相加
            x = x * y1 + x1 * y;
            y = y * y1;

            // 化简分数
            long g = gcd(Math.abs(x), Math.abs(y));
            x /= g;
            y /= g;
        }

        // 如果分子为0，返回"0/1"
        if (x == 0) {
            return "0/1";
        }

        // 如果分母为负数，将负号移到分子上
        if (y < 0) {
            x = -x;
            y = -y;
        }

        return x + "/" + y;
    }


    public long gcd(long a, long b) {
        if (b == 0) {
            return a; // 如果b为0，a就是最大公约数
        }
        long remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b; // 当remainder为0时，b就是最大公约数
    }
}
