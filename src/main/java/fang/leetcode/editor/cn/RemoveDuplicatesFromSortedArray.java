package fang.leetcode.editor.cn;

//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：2, nums = [1,2]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3 * 104 
// -104 <= nums[i] <= 104 
// nums 已按升序排列 
// 
//
// 
// Related Topics 数组 双指针 
// 👍 2318 👎 0

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         *
         * @param nums
         * @return
         */
        public int removeDuplicates(int[] nums) {
            int l = 0;
            for (int i = 1; i < nums.length; i++) {
                // 表示nums[i]非重复
                if (nums[i - 1] != nums[i]) {
                    l++;
                    nums[l] = nums[i];
                }
            }
            return l + 1;
        }

        /**
         * 麻烦的做法
         */
//        public int removeDuplicates(int[] nums) {
//            Set<Integer> set = new HashSet<>();
//
//            int l = 0, r = 0;
//            int cnt = 0;
//            while (r < nums.length) {
//                while (r < nums.length && nums[l] == nums[r]) {
//                    r++;
//                }
//                // 将l+1到r-1之间的元素移至最后
//                int value = nums[l];
//                if (set.contains(value)) {
//                    break;
//                }
//                set.add(value);
//                for (int i = l + 1; i + r - l - 1 < nums.length; i++) {
//                    nums[i] = nums[i + r - l - 1];
//                }
//                for (int i = nums.length - 1; i > nums.length - (r - l); i--) {
//                    nums[i] = value;
//                }
//                cnt += r - l - 1;
//                l++;
//                r = l;
//            }
//            return nums.length - cnt;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}