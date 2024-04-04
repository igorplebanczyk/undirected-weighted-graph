import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        for (int i = 0; i < 3; i++) {
            graph.addNode();
        }

        ArrayList<Node> nodes = graph.getNodes();

        System.out.println("Nodes:");
        for (Node node : nodes) {
            System.out.println("  - Node ID: " + node.id);
        }

        Node node1 = nodes.get(0);
        Node node2 = nodes.get(1);
        Node node3 = nodes.get(2);

        graph.addEdge(node1, node2, 1);
        graph.addEdge(node1, node3, 1);
        graph.addEdge(node2, node3, 1);

        ArrayList<Edge> edges = graph.getEdges();

        System.out.println("\nEdges:");
        for (Edge edge : edges) {
            System.out.println("  - From Node: " + edge.v1.id + " To Node: " + edge.v2.id + " (Weight: " + edge.weight + ")");
        }

        graph.removeEdge(node1, node2, 1);
        edges = graph.getEdges();

        System.out.println("\nEdges after removing an edge:");
        for (Edge edge : edges) {
            System.out.println("  - From Node: " + edge.v1.id + " To Node: " + edge.v2.id + " (Weight: " + edge.weight + ")");
        }

        graph.removeNode((int) nodes.get(0).id);

        nodes = graph.getNodes();
        edges = graph.getEdges();

        System.out.println("\nNodes and Edges after removing a node:");
        System.out.println("Nodes:");
        for (Node node : nodes) {
            System.out.println("  - Node ID: " + node.id);
        }
        System.out.println("\nEdges:");
        for (Edge edge : edges) {
            System.out.println("  - From Node: " + edge.v1.id + " To Node: " + edge.v2.id + " (Weight: " + edge.weight + ")");
        }
    }
}
