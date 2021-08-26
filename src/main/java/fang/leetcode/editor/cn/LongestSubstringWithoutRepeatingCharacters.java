package fang.leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 5920 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /** 不断右移，记录字符的位置，找到最后一个相同字符的位置，新的区间必定在此之后+1
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int start = 0;
            int ans = 0;

            Map<Character, Integer> map = new HashMap<>();
            for (int end = 0; end < s.length(); end++) {
                char c = s.charAt(end);
                if (map.containsKey(c)) {
                    start = Math.max(map.get(c) + 1, start);
                }
                ans = Math.max(ans, end - start + 1);
                map.put(c, end);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 滑动窗口    维护一个区间，记录区间内字符
     * 下一个区间可以复用上个区间的数据
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int ans = 0;
        int cur = 0;

        Set<Character> set = new HashSet<>();

        while (r < s.length()) {
            if (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
                cur--;
            } else {
                cur++;
                ans = Math.max(ans, cur);
                set.add(s.charAt(r));
                r++;
            }
        }
        return ans;
    }
}