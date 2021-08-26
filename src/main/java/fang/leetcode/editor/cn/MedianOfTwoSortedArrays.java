package fang.leetcode.editor.cn;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4359 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 二分
         * 要找到第 k (k>1) 小的元素
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int length1 = nums1.length, length2 = nums2.length;
            int totalLength = length1 + length2;
            if (totalLength % 2 == 1) {
                int midIndex = totalLength / 2;
                return getKthElement(nums1, nums2, midIndex + 1);
            } else {
                int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
                return (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            }
        }

        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        private int getKthElement(int[] nums1, int[] nums2, int k) {
            int l1 = nums1.length;
            int l2 = nums2.length;

            int i1 = 0, i2 = 0;
            while(true) {
                if (i1 == l1) {
                    return nums2[i2 + k - 1];
                }
                if (i2 == l2) {
                    return nums1[i1 + k - 1];
                }
                if (k == 1) {
                    return Math.min(nums1[i1], nums2[i2]);
                }

                int h = k/2;
                int newI1 = Math.min(l1, i1 + h) - 1;
                int newI2 = Math.min(l2, i2 + h) - 1;
                if (nums1[newI1] > nums2[newI2]) {
                    k -= (newI2 - i2 + 1);
                    i2 = newI2 + 1;
                } else {
                    k -= (newI1 - i1 + 1);
                    i1 = newI1 + 1;
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 找出中位数位置
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int m1 = (n1+n2)/2;
        int m2 = m1;
        if ((n1+n2) % 2 == 0) {
            m1 = m2 - 1;
        }

        int l1 = 0;
        int l2 = 0;

        int pos = 0;

        Integer s1 = 0;
        Integer s2 = 0;

        while (l1 < n1 && l2 < n2) {
            Integer x1 = nums1[l1];
            Integer x2 = nums2[l2];

            int res;
            if (x1 > x2) {
                res = x2;
                l2++;
            } else {
                res = x1;
                l1++;
            }

            if (pos == m1){
                s1 = res;
            }


            if (pos == m2){
                s2 = res;
            }

            pos++;

        }
        while (l1 < n1) {
            if (pos == m1){
                s1 = nums1[l1];
            }

            if (pos == m2){
                s2 = nums1[l1];
            }
            pos ++;
            l1++;
        }

        while (l2 < n2) {
            if (pos == m1){
                s1 = nums2[l2];
            }

            if (pos == m2){
                s2 = nums2[l2];
            }
            pos ++;
            l2++;
        }

        return (s1 + s2) / 2.0;
    }

    /**
     * 合并
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int l1 = 0;
        int l2 = 0;

        List<Integer> list = new ArrayList<>();
        while (l1 < n1 && l2 < n2) {
            Integer x1 = nums1[l1];
            Integer x2 = nums2[l2];

            if (x1 > x2) {
                list.add(x2);
                l2++;
            } else {
                list.add(x1);
                l1++;
            }

        }
        while (l1 < n1) {
            list.add(nums1[l1]);
            l1++;
        }

        while (l2 < n2) {
            list.add(nums2[l2]);
            l2++;
        }

        int sum = n1 + n2;
        if (sum % 2 == 1) {
            return list.get(sum / 2);
        } else {
            return (list.get(sum / 2) + list.get(sum / 2 - 1)) / 2.0;
        }

    }

}