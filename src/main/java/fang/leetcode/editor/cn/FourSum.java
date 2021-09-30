package fang.leetcode.editor.cn;

//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b
//], nums[c], nums[d]] ： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 965 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
//        System.out.println(solution.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
        System.out.println(solution.fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> results = new ArrayList<>();
            if (nums.length < 4) {
                return results;
            }
            Arrays.sort(nums);

            // 如何去重
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (j - 1 > i && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    int l = j + 1, r = nums.length - 1;
                    while (l < r) {
                        if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
                            results.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                            l++;
                            r--;
                            while (l < r && nums[l - 1] == nums[l]) l++;
                            while (l < r && nums[r + 1] == nums[r]) r--;
                        } else if (nums[i] + nums[j] + nums[l] + nums[r] > target) {
                            r--;
                        } else {
                            l++;
                        }
                    }
                }
            }

            return results;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
