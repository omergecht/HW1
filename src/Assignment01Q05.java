public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        int current = i;
        boolean[] visited = new boolean[m.length];
        int[] distances = new int[m.length];
        int[] queue = new int[m.length];
        int build = 0, use = 0;
        if (i == j) {
            return 0; // if the start and end are the same, the distance is 0
        }
        queue[build++] = current;
        while (use < build) {
            current = queue[use++];
            for (int next = 0; next < m.length; next++) {
                if (m[current][next] == 1 && !visited[next]) {
                    distances[next] = distances[current] + 1;
                    if (next == j) {
                        return distances[next];
                    }
                    visited[next] = true;
                    queue[build++] = next;
                }
            }
            
        }
        return -1; // if we reach here, it means we didn't find a path from i to j
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}