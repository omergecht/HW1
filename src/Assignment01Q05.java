public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) { // if the start and end nodes are the same, the shortest path is 0
            return 0;
        }
        int res = findShortestPathHelper(m, i, j, new boolean[m.length]); // use recursion to find the shortest path from i to j, while keeping track of visited nodes to avoid cycles
        return res;
    }

    public static int findShortestPathHelper(int[][] m, int i, int j, boolean[] visited) {
        if (i == j) {
            return 0;
        }
        visited[i] = true;
        int min = -1; int L = m.length;
        for (int l = 0; l < L; l++) { // check all the nodes in the graph, if there is a path from i to l and l has not been visited, recursively find the shortest path from l to j through it
            if (m[i][l] == 1 && !visited[l]) {
                int pathLength = findShortestPathHelper(m, l, j, visited);
                if (pathLength != -1) {
                        if (min == -1 || pathLength + 1 < min) {
                            min = pathLength + 1;
                        }
                    }
                }
        }
        visited[i] = false;
        return min;
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