/*
 * Problem 10: Busiest Bus Row
 *
 * Approach: outer loop over rows, inner loop sums each row. Update the best
 * row only when the new total is strictly larger, so ties keep the smaller
 * index.
 *
 * Complexity:
 *   Time            : O(r * c)
 *   Additional space: O(1)
 */
public class BusiestBusRow {

    // returns {rowIndex, total}
    public static int[] busiestRow(int[][] grid) {
        int bestRow = 0, bestTotal = -1;
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
            }
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }
        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        int[] r = busiestRow(grid);
        System.out.println("Row " + r[0] + ", Total " + r[1]); // Row 1, Total 7
    }
}
