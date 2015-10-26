package edu.neumont.coordinate.randomforecaster;

import edu.neumont.coordinate.Coordinate;
import edu.neumont.coordinate.Forecaster;
import org.jgrapht.Graph;
import org.jgrapht.graph.*;

import java.util.Set;

public class BlakeForecaster implements Forecaster {

    private int lastSeen;

    private DefaultDirectedWeightedGraph<Node, DefaultWeightedEdge> graph;
    NodeRepository nodeRepository;

    public BlakeForecaster() {
        graph = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
        nodeRepository = new NodeRepository();
    }

    public Coordinate getNextPrediction() {
        return new Coordinate(lastSeen + 1, lastSeen + 1);
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

        Node n1Node = nodeRepository.getNode(n1);
        if (n1Node == null) {
            n1Node = new Node(n1);
            nodeRepository.add(n1Node);
            graph.addVertex(n1Node);
        }

        Node n2Node = nodeRepository.getNode(n2);
        if (n2Node == null) {
//            System.out.println("adding node (" + n2 + ")");
            n2Node = new Node(n2);
            nodeRepository.add(n2Node);
            graph.addVertex(n2Node);
        }

        n1Node.addEdge(n2Node);
        DefaultWeightedEdge e = graph.addEdge(n1Node, n2Node);
        if (e != null) {
            graph.setEdgeWeight(e,n1Node.getEdgeCount(n2Node.getNumber()));

        } else {
            e = graph.getEdge(n1Node, n2Node);
            graph.setEdgeWeight(e, graph.getEdgeWeight(e) + 1);
        }
    }

    public DefaultDirectedWeightedGraph<Node, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    @Override
    public String toString() {
        return graph.toString();
    }
}
