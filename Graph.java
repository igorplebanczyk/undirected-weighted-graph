import java.util.ArrayList;
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

    public void addEdge(Node v1, Node v2, int weight) {
        Edge newEdge = new Edge(v1, v2, weight);
        if (!edges.contains(newEdge)) {
            edges.add(newEdge);
        }
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

    public ArrayList<Edge> getEdges() {
        return edges;
    }
}