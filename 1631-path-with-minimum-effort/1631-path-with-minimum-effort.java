class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        boolean visited[][] = new boolean[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);

        int moves[][] = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        pq.offer(new int[] {0, 0, 0});

        while (!pq.isEmpty()) {
            int cur[] = pq.poll();

            int curRow = cur[0];
            int curCol = cur[1];
            int effort = cur[2];

            visited[curRow][curCol] = true;

            if (curRow == n - 1 && curCol == m - 1) {
                return effort;
            }

            for (int move[] : moves) {
                int nextRow = curRow + move[0];
                int nextCol = curCol + move[1];

                if (
                    nextRow < 0 || 
                    nextCol < 0 || 
                    nextRow >= n || 
                    nextCol >= m || 
                    visited[nextRow][nextCol]
                ) {
                    continue;
                }

                int nextEffort = Math.abs(heights[curRow][curCol] - heights[nextRow][nextCol]);
                pq.offer(new int[] {nextRow, nextCol, Math.max(effort, nextEffort)});
            }
        }

        return -1;
    }

}