### 解题思路
遍历数组，因为不能取两个相同元素，所以j=i+1，申请动态数组。
注意：returnSize是返回数组的长度。

### 代码

```c
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    for (int i = 0; i < numsSize; ++i) {                 // ++i比i++的性能更好
        for (int j = i + 1; j < numsSize; ++j) {
            if (nums[i] + nums[j] == target) {
                int *ret = malloc(sizeof(int) * 2);      //申请动态数组
                ret[0] = i, ret[1] = j;
                *returnSize = 2;
                return ret;
            }
        }
    }
    *returnSize = 0;
    return NULL;
}

```