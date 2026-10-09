import java.util.Scanner;
import java.util.Arrays;

public class Problem3_ThreeSum {

    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        int[][] result = new int[10][3];
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    if (count == result.length) {
                        result = Arrays.copyOf(result, result.length * 2);
                    }

                    result[count][0] = nums[i];
                    result[count][1] = nums[left];
                    result[count][2] = nums[right];
                    count++;

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return Arrays.copyOf(result, count);
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

        int[][] answer = threeSum(nums);
        System.out.print("Unique triplets: [");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(Arrays.toString(answer[i]));
            if (i < answer.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        sc.close();
    }
}
