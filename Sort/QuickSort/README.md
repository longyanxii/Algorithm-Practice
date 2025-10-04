快速排序常见方法
Lomuto      pivot固定为最右边元素
Hoare       pivot固定为最左边元素       分区边界：返回j作为分区点，递归区间为[left, j]和[j+1, right]
双指针      pivot固定为最左边元素        分区边界：返回j作为分区点，递归区间为[left, j-1]和[j+1, right]
随机pivot
三数取中
三路