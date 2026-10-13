/*
 * Problem 4: Exam Score Band Counter
 *
 * Approach: scores is sorted, so the count in [low, high] equals
 *   (first index with score > high) - (first index with score >= low).
 * Both are found with a modified binary search.
 *
 * Complexity:
 *   Linear scan          : O(n) time per query, O(1) space
 *   Binary search (final): O(log n) time per query, O(1) space
 *   (n = 10^6 -> up to 1,000,000 steps per scan vs ~20 for binary search)
 *
 * Duplicates at the band edges:
 *   A standard binary search stops at ANY matching element, which may be in
 *   the middle of a run of equal scores (e.g. one of three 58s) and give a
 *   wrong boundary. So the search must not stop on a match: when
 *   scores[mid] >= low (or > high) it keeps moving hi = mid to the left until
 *   the FIRST qualifying position is found. Using ">= low" includes every
 *   duplicate of low, and "> high" includes every duplicate of high.
 */
public class ExamScoreBandCounter {

    // first index whose value is >= target (scores.length if none)
    static int firstGreaterOrEqual(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    // first index whose value is > target (scores.length if none)
    static int firstGreater(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public static int countInBand(int[] scores, int low, int high) {
        return firstGreater(scores, high) - firstGreaterOrEqual(scores, low);
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));  // 6
        System.out.println(countInBand(scores, 90, 100)); // 0
    }
}
