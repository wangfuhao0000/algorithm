package sort;

public class Util {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void print(int[] nums) {
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static int[] nums = new int[] {53,12,78,109,1,36,17,45,33};
    //public static int[] nums = new int[] {12,12,78,109,122,17,33,36,45};
}
