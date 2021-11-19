package fang.leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2674 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final List<Character> left = new ArrayList<>();
        private final List<Character> right = new ArrayList<>();

        {
            left.add('(');
            left.add('[');
            left.add('{');
            right.add(')');
            right.add(']');
            right.add('}');
        }

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (left.contains(c)) {
                    stack.push(c);
                } else if (right.contains(c)) {
                    if (stack.empty()) {
                        return false;
                    }
                    char m = stack.pop();
                    if (!isMatch(m, c)) {
                        return false;
                    }

                } else {
                    return false;
                }
            }
            return stack.empty();
        }

        private boolean isMatch(char l, char r) {
            return (l == '(' && r == ')') || (l == '[' && r == ']') || (l == '{' && r == '}');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
