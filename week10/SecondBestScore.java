/*
 * Problem 7: Second-Best Score
 *
 * Approach: keep two variables, highest and second (both start at -1, below
 * any valid score). For each score: if it beats highest, the old highest
 * becomes second; otherwise, if it differs from highest and beats second, it
 * becomes second. Scores equal to highest are skipped, so duplicates never
 * become second.
 *
 * Complexity:
 *   Two-variable scan (final)        : O(n) time, O(1) space
 *   Sort first, then find 2nd distinct: O(n log n) time
 *   The scan visits each element once and avoids the extra work of ordering
 *   everything. The task also forbids sorting.
 */
public class SecondBestScore {

    public static int secondHighest(int[] scores) {
        int highest = -1, second = -1;
        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s != highest && s > second) {
                second = s;
            }
        }
        return second; // stays -1 if no distinct second score exists
    }

    public static void main(String[] args) {
        System.out.println(secondHighest(new int[]{45, 78, 92, 78, 60})); // 78
        System.out.println(secondHighest(new int[]{50, 50, 50}));         // -1
    }
}
