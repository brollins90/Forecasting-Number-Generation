package copsandrobbers.forecast;

import copsandrobbers.Coordinate;
import copsandrobbers.Forecaster;
import org.jgrapht.graph.*;

import java.util.Set;

public class GraphCountForecaster implements Forecaster {

    private int lastSeen;

    private DefaultDirectedWeightedGraph<Integer, DefaultWeightedEdge> graph;

    public GraphCountForecaster() {
        graph = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
    }

    public Coordinate getNextPrediction() {
        return getNextPrediction(lastSeen);
    }

    public Coordinate getNextPrediction(int seed) {

        int x = predictNextInt(seed);
        int y = predictNextInt(x);

        return new Coordinate(x, y);
    }

    private int predictNextInt(int seed) {

        int next = seed;
        double nextWeight = 0;

        if (graph.containsVertex(seed)) {
            Set<DefaultWeightedEdge> edges = graph.outgoingEdgesOf(seed);
//            System.out.println(edges);


            for (DefaultWeightedEdge e : edges) {
                if (graph.getEdgeWeight(e) > nextWeight) {
                    next = graph.getEdgeTarget(e);
                    nextWeight = graph.getEdgeWeight(e);
                }
            }
        }
        return next;
    }

    public void seePrevious(Coordinate coordinate) {

        int n1 = lastSeen;
        int n2 = coordinate.getX();
        addInformation(n1, n2);

        n1 = n2;
        n2 = coordinate.getY();
        addInformation(n1, n2);

        lastSeen = n2;
    }

    private void addInformation(int n1, int n2) {

        DefaultWeightedEdge edge;
        edge = graph.getEdge(n1, n2);
        if (edge == null) {
            if (!graph.containsVertex(n1)) {
                graph.addVertex(n1);
            }
            if (!graph.containsVertex(n2)) {
                graph.addVertex(n2);
            }
            edge = graph.addEdge(n1, n2);
            graph.setEdgeWeight(edge, 1);
        } else {
            graph.setEdgeWeight(edge, graph.getEdgeWeight(edge) + 1);
        }
    }

    public DefaultDirectedWeightedGraph<Integer, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    @Override
    public String toString() {
        return graph.toString();
    }
}
