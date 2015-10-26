package edu.neumont.coordinate.randomforecaster;

import java.util.HashSet;

public class NodeRepository extends HashSet<Node> {

    public Node getNode(int lastSeen) {

        for (Node n : this) {
            if (n.getNumber() == lastSeen) {
//                System.out.println("returning existing node (" + lastSeen + ")");
                return n;
            }
        }

        return null;
//        Node n = new Node(lastSeen);
//        this.add(n);
//        System.out.println("returning new node (" + lastSeen + ")");
//        return n;
    }
}
