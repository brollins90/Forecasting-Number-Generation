package edu.neumont.coordinate.randomforecaster;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brollins on 10/26/2015.
 */
public class Node {

    private int number;
    private List<Edge> edgeList;

    public Node(int number) {
        this.number = number;
        edgeList = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public void addEdge(Node destNode){

        boolean added = false;
        for(Edge e : edgeList) {
            if (e.getSource().number == this.getNumber() &&
                    e.getDest().getNumber() == destNode.getNumber()) {
                e.IncrementCount();
                added = true;
                break;
            }
        }

        if (!added) {
            Edge e = new Edge(this, destNode);
            edgeList.add(e);
            added = true;
        }
    }

    public void addEdge(Edge newEdge){
        edgeList.add(newEdge);
    }

    @Override
    public String toString() {
        return "" + number;
    }

    public double getEdgeCount(int number) {

        int count = 0;

        for(Edge e : edgeList) {
            if (e.getDest().getNumber() == number) {
                count++;
            }
        }

        return count;

    }
}
