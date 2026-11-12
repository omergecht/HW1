public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        int current = i;
        boolean[] visited = new boolean[m.length]; // keep track of the visited nodes to avoid cycles
        visited[current] = true;
        int[] distances = new int[m.length]; // keep track of the distances from the start node to each node
        int[] queue = new int[m.length]; // queue of the neighbors we still need to visit
        int build = 0, use = 0;
        if (i == j) {
            return 0; // if the start and end are the same, the distance is 0
        }
        queue[build++] = current;
        while (use < build) { // while there are still nodes to visit
            current = queue[use++];  // get the next node to visit, move use forward in the queue
            for (int next = 0; next < m.length; next++) { // for each neighbor of the current node
                if (m[current][next] == 1 && !visited[next]) {
                    distances[next] = distances[current] + 1; // update the distance to the neighbor
                    if (next == j) { // if we reached the destination, return the distance
                        return distances[next];
                    }
                    visited[next] = true; // mark the neighbor as visited, there is no need to find the shortest path to it again
                    queue[build++] = next; // add the neighbor to the queue to check for its unvisited neighbors, update the total length od the queue
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