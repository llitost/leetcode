package fang.leetcode.editor.cn;

//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 排序 
// 👍 896 👎 0

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int ans = 0;
            int sum = 30000;

            for (int i = 0; i < nums.length; i++) {
                int a = nums[i];
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int tmp = a + nums[l] + nums[r] - target;
                    int distance = Math.abs(tmp);
                    if (distance < sum) {
                        sum = distance;
                        ans = a + nums[l] + nums[r];
                    }

                    if (tmp == 0) {
                        return ans;
                    } else if (tmp > 0) {
                        r--;
                    } else {
                        l++;
                    }

                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
