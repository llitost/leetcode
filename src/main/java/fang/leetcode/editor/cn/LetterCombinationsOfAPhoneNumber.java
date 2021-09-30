package fang.leetcode.editor.cn;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1525 👎 0

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Integer, List<Character>> map = new HashMap<Integer, List<Character>>() {{
            put(2, Arrays.asList('a', 'b', 'c'));
            put(3, Arrays.asList('d', 'e', 'f'));
            put(4, Arrays.asList('g', 'h', 'i'));
            put(5, Arrays.asList('j', 'k', 'l'));
            put(6, Arrays.asList('m', 'n', 'o'));
            put(7, Arrays.asList('p', 'q', 'r', 's'));
            put(8, Arrays.asList('t', 'u', 'v'));
            put(9, Arrays.asList('w', 'x', 'y', 'z'));
        }};

        public List<String> letterCombinations(String digits) {
            if (digits.length() < 1) {
                return new ArrayList<>();
            }
            char[] digitChars = digits.toCharArray();
            List<String> result = new ArrayList<>();

            dfs(0, digitChars, result, new StringBuilder());

            return result;
        }

        public void dfs(int index, char[] digits, List<String> result, StringBuilder res) {
            if (index == digits.length) {
                result.add(res.toString());
                return;
            }
            int digit = digits[index] - '0';
            List<Character> mapping = map.get(digit);
            for (int i = 0; i < mapping.size(); i++) {
                res.append(mapping.get(i));
                dfs(index + 1, digits, result, res);
                res.deleteCharAt(index);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
