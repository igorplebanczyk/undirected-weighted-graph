import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Graph graph = getGraph();

        ArrayList<Edge> edges = graph.getEdges();

        System.out.println("\nEdges:");
        for (Edge edge : edges) {
            System.out.println("  - From Node: " + edge.v1.id + " To Node: " + edge.v2.id + " (Weight: " + edge.weight + ")");
        }

        System.out.println("\nDijkstra from Node of ID 2 and Node of ID 9:");
        System.out.println(graph.dijkstraAlgorithm(2, 9));

        System.out.println("\nMinimal Spanning Tree using Kruskal's Algorithm:");
        ArrayList<Edge> mstKruskal = graph.kruskalMST();
        for (Edge edge : mstKruskal) {
            System.out.println("  - From Node: " + edge.v1.id + " To Node: " + edge.v2.id + " (Weight: " + edge.weight + ")");
        }

        System.out.println("\nMinimal Spanning Tree using Prim's Algorithm:");
        ArrayList<Edge> mstPrim = graph.primMST();
        for (Edge edge : mstPrim) {
            System.out.println("  - From Node: " + edge.v1.id + " To Node: " + edge.v2.id + " (Weight: " + edge.weight + ")");
        }

        int chromaticNumber = graph.minimalChromaticNumber();
        System.out.println("\nThe minimal chromatic number is: " + chromaticNumber);
    }

    private static Graph getGraph() {
        Graph graph = new Graph();

        for (int i = 0; i < 11; i++) {
            graph.addNode();
        }

        ArrayList<Node> nodes = graph.getNodes();

        Node node1 = nodes.get(0);
        Node node2 = nodes.get(1);
        Node node3 = nodes.get(2);
        Node node4 = nodes.get(3);
        Node node5 = nodes.get(4);
        Node node6 = nodes.get(5);
        Node node7 = nodes.get(6);
        Node node8 = nodes.get(7);
        Node node9 = nodes.get(8);
        Node node10 = nodes.get(9);
        Node node11 = nodes.get(10);

        graph.addEdge(node1, node2, 1);
        graph.addEdge(node1, node3, 4);
        graph.addEdge(node1, node4, 2);
        graph.addEdge(node2, node4, 3);
        graph.addEdge(node2, node3, 1);
        graph.addEdge(node3, node4, 6);
        graph.addEdge(node3, node5, 2);
        graph.addEdge(node5, node7, 12);
        graph.addEdge(node5, node6, 4);
        graph.addEdge(node6, node7, 3);
        graph.addEdge(node7, node8, 1);
        graph.addEdge(node8, node9, 4);
        graph.addEdge(node9, node4, 5);
        graph.addEdge(node4, node1, 3);
        graph.addEdge(node4, node10, 2);
        graph.addEdge(node10, node11, 1);
        graph.addEdge(node11, node1, 6);

        return graph;
    }
}
