class Solution {
    public int snakesAndLadders(int[][] board) {
        Map<Integer, Integer> jumps = getJumps(board);
        int target = board.length * board.length;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(1);
        visited.add(1);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int currCellValue = q.poll();
                for (int move = 1; move <= 6; move++) {
                    int nextCellValue = currCellValue + move;
                    nextCellValue = jumps.get(nextCellValue) == null? nextCellValue : jumps.get(nextCellValue);
                    if (nextCellValue == target) {
                        return steps;
                    }
                    if (!visited.contains(nextCellValue)) {
                        q.offer(nextCellValue);
                        visited.add(nextCellValue);
                    }    
                }
            }
        }
        return -1;
    }

    private Map<Integer, Integer> getJumps(int[][] board) {
        int direction = 1;
        if (board.length % 2 == 1) {
            direction = -1;
        }
        int m = board.length, n = board.length;
        int val = m * n;
        Map<Integer, Integer> jumps = new HashMap<>();
        for (int i = 0; i < m; i++) {
            if (direction > 0) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != -1) {
                        jumps.put(val, board[i][j]);
                    }
                    val--;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    if (board[i][j] != -1) {
                        jumps.put(val, board[i][j]);
                    }
                    val--;
                }
            }
            direction *= -1;
        }
        return jumps;
    }
}