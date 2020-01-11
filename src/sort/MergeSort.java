package sort;

public class MergeSort {
    public static void merge(int[] nums, int low, int mid, int high) {
        int l = low, m = mid+1;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i)
            temp[i] = nums[i];
        for (int k = low; k <= high; ++k) {  //肯定是要执行这么多次复制操作
            if (l > mid) nums[k] = temp[m++];
            else if (m > high) nums[k] = temp[l++];
            else if (temp[l] > temp[m]) nums[k] = temp[m++];
            else nums[k] = temp[l++];
        }
    }

    //自顶向下的归并排序
    public static void sort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        sort(nums, left, mid);  //先对左边排序
        sort(nums, mid+1, right);  //再对右边排序
        merge(nums, left, mid, right);  //综合左右的排序结果
    }

    //自底向上的归并排序
    public static void sort(int[] nums) {
        int N = nums.length;
        for (int sz = 1; sz < N; sz *= 2) {  //每次子数组的大小翻倍
            for (int low = 0; low < N-sz; low += sz+sz) { //low每次跳过两个sz的长度
                merge(nums, low, low+sz-1, Math.min(low+sz+sz-1, N-1));
            }
        }
    }

    public static void main(String[] args) {
        int mid = (Util.nums.length - 1) / 2;
        //sort(Util.nums, 0, Util.nums.length-1);
        sort(Util.nums);
        Util.print(Util.nums);
    }
}
