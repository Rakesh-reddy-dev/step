import java.util.Arrays;

/*
 * Problem 8: Duty Roster Rotation
 *
 * Approach: reduce k with k % n (full turns change nothing), then place the
 * name at index i into index (i + k) % n of a new array.
 *
 * Complexity:
 *   Time : O(n)
 *   Space: O(n) for the result array
 *
 * Why rotating one place at a time is slow:
 *   Each single-step rotation costs O(n), so k steps cost O(n * k). With k up
 *   to 10^9 that is ~10^11 operations. Most of it is wasted because the roster
 *   returns to its original order every n steps. Using k % n keeps the shift
 *   below n and the whole job O(n).
 */
public class DutyRosterRotation {

    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[(i + shift) % n] = names[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names, 2))); // [D, E, A, B, C]
        System.out.println(Arrays.toString(rotateRoster(names, 7))); // [D, E, A, B, C]
    }
}
