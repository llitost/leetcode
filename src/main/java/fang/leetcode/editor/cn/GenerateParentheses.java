package fang.leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 2155 👎 0

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
//            generate(new char[2 * n], 0, result);
            generateValid(new char[2 * n], 0, 0, 0, result);
            return result;
        }

        private void generateValid(char[] chars, int pos, int open, int close, List<String> result) {
            if (pos == chars.length) {
                if (isValid(chars)) {
                    result.add(new String(chars));
                }
                return;
            }
            if (open < chars.length) {
                chars[pos] = '(';
                generateValid(chars, pos + 1, open + 1, close, result);
            }
            if (close < open) {
                chars[pos] = ')';
                generateValid(chars, pos + 1, open, close + 1, result);
            }
        }

        /**
         * 暴力
         *
         * @param chars
         * @param i
         * @param result
         */
        private void generate(char[] chars, int i, List<String> result) {
            if (i == chars.length) {
                if (isValid(chars)) {
                    result.add(new String(chars));
                }
                return;
            }
            chars[i] = '(';
            generate(chars, i + 1, result);
            chars[i] = ')';
            generate(chars, i + 1, result);
        }

        private boolean isValid(char[] chars) {
            int cnt = 0;
            for (char c : chars) {
                if (c == '(') {
                    cnt++;
                } else {
                    cnt--;
                }
                if (cnt < 0) {
                    return false;
                }
            }
            return cnt == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
