package sort;

public class QuickSort {
    public static void sort(int[] nums, int left, int right) {
        if (left > right)
            return;
        int cur = nums[left], l = left+1, r = right;  //l和r是两个边界
        while (l <= r) {
            while (l <= r && nums[l] <= cur) ++l;
            while (r >= l && nums[r] > cur) --r;
            if (l <= r) {
                Util.swap(nums, l, r);
                l++; r--;
            }
        }
        Util.swap(nums, left, l-1);
        sort(nums, left, l-2);
        sort(nums, l, right);
    }

    public static void main(String[] args) {
        sort(Util.nums, 0, Util.nums.length-1);
        Util.print(Util.nums);
    }
}
