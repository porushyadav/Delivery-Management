package DeliveryManagement.model;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    public int numVertices;
    public Map<Integer, Map<Integer, Double>> adjacencyMap;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMap = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyMap.put(i, new HashMap<>());
        }
    }

    public void addEdge(int source, int destination, double weight) {
        adjacencyMap.get(source).put(destination, weight);
        adjacencyMap.get(destination).put(source, weight); // Assuming undirected graph
    }

    public double getWeight(int source, int destination) {
        return adjacencyMap.get(source).get(destination);
    }
}
