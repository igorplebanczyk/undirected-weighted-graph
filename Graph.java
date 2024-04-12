import java.util.ArrayList;
import java.util.HashMap;
public class Graph {
    ArrayList<Node> nodes = new ArrayList<Node>();
    ArrayList<Edge> edges = new ArrayList<Edge>();

    public void addNode() {
        Node node = new Node();
        nodes.add(node);
    }

    public void removeNode(int id) {
        try {
            edges.removeIf(edge -> edge.v1.id == id || edge.v2.id == id);
            nodes.removeIf(node -> node.id == id);
        } catch (Exception e) {
            System.out.println("Error during node removal: " + e.getMessage());
        }
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public Node findNode(int id) {
        for (Node node: nodes) {
            if (node.id == id) {
              return node;
            }
        }
    }

    public void addEdge(Node v1, Node v2, int weight) {
        Edge newEdge = new Edge(v1, v2, weight);
        edges.add(newEdge);
    }

    public void removeEdge(Node v1, Node v2, int    weight) {
        Edge newEdge = new Edge(v1, v2, weight);

        try {
            edges.remove(newEdge);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public int dijkstra(Node v1, Node v2) {
        String shortest_path = "";

        HashMap<Node, Integer> distances = new HashMap<>();
        HashMap<Node, ArrayList<Edge>> neighbours = new HashMap<>();

        for (Node node : nodes) {
            ArrayList<Edge> neighboursLoop = new ArrayList<>();

            for (Edge edge : edges) {
                if (edge.v1.equals(node)) {
                    neighboursLoop.add(edge);
                } else if (edge.v2.equals(node)) {
                    neighboursLoop.add(edge);
                }
            }

            neighbours.put(node, neighboursLoop);
        }

        for (Node node: nodes) {

        }

        return shortest_path;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public Graph (Graph graph){
        this.nodes = new ArrayList<>(graph.nodes);
        this.edges = new ArrayList<>(graph.edges);
    }

    public int dijkstraAlgorithm(int startID, int destinationID){
        Graph graphCopy = new Graph(this);

        for (Node node: nodes) {
            node.distance = Integer.MAX_VALUE;
        }
    }

}