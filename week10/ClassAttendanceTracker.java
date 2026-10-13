/*
 * Problem 6: Class Attendance Tracker
 *
 * Approach: one pass. Each 1 increments the present count and the running
 * streak (updating the longest if it is a new maximum); each 0 resets the
 * streak to 0.
 *
 * Complexity:
 *   Time : O(n)
 *   Space: O(1)
 *
 * Single pass? Yes. Both answers are updated in the same loop, so no second
 * traversal is needed.
 */
public class ClassAttendanceTracker {

    // returns {presentDays, longestStreak}
    public static int[] attendanceSummary(int[] days) {
        int present = 0, streak = 0, longest = 0;
        for (int d : days) {
            if (d == 1) {
                present++;
                streak++;
                if (streak > longest) longest = streak;
            } else {
                streak = 0;
            }
        }
        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        int[][] tests = {
            {1, 1, 0, 1, 1, 1, 0, 1},
            {0, 0, 0}
        };
        for (int[] days : tests) {
            int[] r = attendanceSummary(days);
            System.out.println("Present: " + r[0] + ", Longest streak: " + r[1]);
        }
    }
}
