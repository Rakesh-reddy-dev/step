import java.util.Scanner;
import java.util.HashMap;

public class Problem4_SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {
            prefixSum += num;
            count += prefixCounts.getOrDefault(prefixSum - k, 0);
            prefixCounts.put(prefixSum,
                    prefixCounts.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Number of subarrays: " + subarraySum(nums, k));
        sc.close();
    }
}
