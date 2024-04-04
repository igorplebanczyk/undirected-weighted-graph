import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        // Create a new graph object
        Graph graph = new Graph();

        // Create 3 nodes
        for (int i = 0; i < 3; i++) {
            graph.addNode();
        }

        // Get the list of nodes
        ArrayList<Node> nodes = graph.getNodes();

        // Display the list of nodes
        System.out.println("Nodes:");
        for (Node node : nodes) {
            System.out.println("  - Node ID: " + node.id);
        }

        // Create 3 edges with weight 1
        Node node1 = nodes.get(0);
        Node node2 = nodes.get(1);
        Node node3 = nodes.get(2);

        graph.addEdge(node1, node2, 1);
        graph.addEdge(node1, node3, 1);
        graph.addEdge(node2, node3, 1);

        // Get the list of edges
        ArrayList<Edge> edges = graph.getEdges();

        // Display the list of edges
        System.out.println("\nEdges:");
        for (Edge edge : edges) {
            System.out.println("  - From Node: " + edge.v1.id + " To Node: " + edge.v2.id + " (Weight: " + edge.weight + ")");
        }

        // Remove the edge between node1 and node2
        graph.removeEdge(node1, node2, 1);

        // Get the updated list of edges
        edges = graph.getEdges();

        // Display the list of edges after removal
        System.out.println("\nEdges after removing an edge:");
        for (Edge edge : edges) {
            System.out.println("  - From Node: " + edge.v1.id + " To Node: " + edge.v2.id + " (Weight: " + edge.weight + ")");
        }

        // Remove the node with ID of the first node in the list
        graph.removeNode((int) nodes.get(0).id);

        // Get the updated list of nodes and edges
        nodes = graph.getNodes();
        edges = graph.getEdges();

        // Display the list of nodes and edges after removal
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