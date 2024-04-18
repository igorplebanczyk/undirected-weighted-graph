import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        for (int i = 0; i < 7; i++) {
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
        Node node4 = nodes.get(3);
        Node node5 = nodes.get(4);
        Node node6 = nodes.get(5);
        Node node7 = nodes.get(6);

        graph.addEdge(node1, node2, 1);
        graph.addEdge(node1, node3, 1);
        graph.addEdge(node2, node3, 1);
        graph.addEdge(node3, node4, 6);
        graph.addEdge(node3, node5, 2);
        graph.addEdge(node5, node7, 12);
        graph.addEdge(node5, node6, 4);
        graph.addEdge(node6, node7, 3);

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

        System.out.println("Dijkstra from Node of ID 2 and Node of ID 7:\n");
        System.out.println(graph.dijkstraAlgorithm(2, 7));
    }
}
