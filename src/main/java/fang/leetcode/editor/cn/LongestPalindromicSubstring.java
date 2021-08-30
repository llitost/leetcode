package fang.leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3958 👎 0

import com.sun.deploy.util.StringUtils;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("aacabdkacaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 枚举所有的「回文中心」并尝试「扩展」
         */
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
                return "";
            }
            int len = s.length();

            int maxLen = 0;
            int start = 0;
            // 枚举中心点
            for (int i = 0; i < len; i++) {
                int len1 = expend(s, i, i);
                int len2 = expend(s, i, i + 1);
                if (Math.max(len1, len2) > maxLen) {
                    maxLen = Math.max(len1, len2);
                    start = i - ((maxLen - 1) / 2);
                }
            }
            return s.substring(start, start + maxLen);
        }

        private int expend(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    /**
     * f[i][j]表示第i个到第j个是否为回文串
     * f[i][i] = 1;
     * f[i][j] = f[i+1][j-1] && s[i]==s[j]
     * <p>
     * 从长度较短的字符串向长度较长的字符串进行转移
     * 注意边界
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        // 枚举长度
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len; i++) {
                int j = i + l - 1;
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (l < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && l > maxLen) {
                        maxLen = l;
                        start = i;
                    }
                }

            }
        }
        return s.substring(start, start + maxLen);
    }

}