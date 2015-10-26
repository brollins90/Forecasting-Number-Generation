package edu.neumont.coordinate.randomforecaster;

import edu.neumont.coordinate.Coordinate;
import edu.neumont.coordinate.Forecaster;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.Set;

public class BlakeForecaster implements Forecaster {

    private int lastSeen;

    private Graph<Node, DefaultEdge> graph;
    NodeRepository nodeRepository;


    public BlakeForecaster() {
        graph = new DefaultDirectedWeightedGraph<Node, DefaultEdge>(DefaultEdge.class);
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
            System.out.println("adding node (" + n1 + ")");
            n1Node = new Node(n1);
            nodeRepository.add(n1Node);
            graph.addVertex(n1Node);
        }

        Node n2Node = nodeRepository.getNode(n2);
        if (n2Node == null) {
            System.out.println("adding node (" + n2 + ")");
            n2Node = new Node(n2);
            nodeRepository.add(n2Node);
            graph.addVertex(n2Node);
        }

        n1Node.addEdge(n2Node);
        graph.addEdge(n1Node, n2Node);
    }

    public Graph<Node, DefaultEdge> getGraph() {
        return graph;
    }

    @Override
    public String toString() {
        return graph.toString();
    }
}
