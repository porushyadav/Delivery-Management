package DeliveryManagement.service;

import DeliveryManagement.model.Graph;

public class TSPSolver {
    private Graph graph;
    private boolean[] visited;
    private int[] path;
    private double minCost;
    private int[] minPath;

    public TSPSolver(Graph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.numVertices];
        this.path = new int[graph.numVertices + 1]; // Include start vertex at the end for a closed loop
        this.minCost = Double.MAX_VALUE;
        this.minPath = new int[graph.numVertices + 1];
    }

    public void solveTSP(int start) {
        visited[start] = true;
        path[0] = start;
        tsp(start, 0, 1);
    }

    private void tsp(int vertex, double cost, int level) {
        if (level == graph.numVertices) { // Reached the last vertex
            if (graph.getWeight(vertex, path[0]) != 0) { // Check if there's a path back to the start
                cost += graph.getWeight(vertex, path[0]);
                if (cost < minCost) { // Found a better path
                    minCost = cost;
                    System.arraycopy(path, 0, minPath, 0, graph.numVertices);
                }
            }
            return;
        }

        for (int next = 0; next < graph.numVertices; next++) {
            if (!visited[next] && graph.getWeight(vertex, next) != 0) {
                visited[next] = true;
                path[level] = next;
                tsp(next, cost + graph.getWeight(vertex, next), level + 1);
                visited[next] = false;
            }
        }
    }

    public double getMinCost() {
        return minCost;
    }

    public int[] getMinPath() {
        return minPath;
    }
}