package edu.neumont.coordinate.randomforecaster;

/**
 * Created by brollins on 10/26/2015.
 */
public class Edge {
    private Node source;
    private Node dest;
    int count;

    public Edge(Node source, Node dest) {
        this.source = source;
        this.dest = dest;
        count = 1;
    }

    public Node getSource() {
        return source;
    }

    public Node getDest() {
        return dest;
    }

    public void IncrementCount() {
        count++;
    }
}
