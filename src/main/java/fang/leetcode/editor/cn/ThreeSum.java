package fang.leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3822 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    /**
     * 当我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 排序
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (nums[0] > 0) {
                    continue;
                }
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                int target = nums[i];
                int l = i + 1, r = nums.length - 1;

                while (l < r) {
                    if (nums[l] + nums[r] + target == 0) {
                        result.add(new ArrayList<>(Arrays.asList(target, nums[l], nums[r])));

                        l++;
                        r--;
                        // 去重
                        while (l<r && nums[l-1]==nums[l]) l++;
                        while (l<r && nums[r+1]==nums[l]) r--;
                    } else if (nums[l] + nums[r] + target > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
