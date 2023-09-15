class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDistances = new int[n];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        minDistances[0] = 0; // Start with the first point.
        int totalDistance = 0;

        for (int i = 0; i < n; i++) {
            int minIndex = -1;
            int minDistance = Integer.MAX_VALUE;

            // Find the unvisited point with the minimum distance to any visited point.
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minDistances[j] < minDistance) {
                    minDistance = minDistances[j];
                    minIndex = j;
                }
            }

            visited[minIndex] = true;
            totalDistance += minDistance;

            // Update the minimum distances for unvisited points.
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int distance = Math.abs(points[minIndex][0] - points[j][0]) +
                                   Math.abs(points[minIndex][1] - points[j][1]);
                    minDistances[j] = Math.min(minDistances[j], distance);
                }
            }
        }

        return totalDistance;
    }
}