package fang.leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1750 👎 0

public class LongestCommonPrefix{
    public static void main(String[] args) {
         Solution solution = new LongestCommonPrefix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        int s = 0;
        for (int i=0;i<strs[0].length();i++) {
            boolean f = true;
            char c = strs[0].charAt(i);
            for (int j=1;j<strs.length;j++) {
                if (i>= strs[j].length() || strs[j].charAt(i) != c){
                    f = false;
                    break;
                }
            }
            if (f) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}