import java.util.ArrayList;
import java.util.Comparator;

public class Graph {
    ArrayList<Node> nodes = new ArrayList<>();
    ArrayList<Edge> edges = new ArrayList<>();

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

    public Node findNode(int id, ArrayList<Node> list) { // Now takes list as argument
        for (Node node : list) {
            if (node.id == id) {
                return node;
            }
        }
        return null;
    }


    public void addEdge(Node v1, Node v2, int weight) {
        Edge newEdge = new Edge(v1, v2, weight);
        edges.add(newEdge);
    }

    public void removeEdge(Node v1, Node v2, int weight) {
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

    public int dijkstraAlgorithm(int startID, int destinationID) {
        ArrayList<Node> unvisited = new ArrayList<>(nodes);
        for (Node node : unvisited) {
            node.distance = Integer.MAX_VALUE;
        }
        Node startNode = this.findNode(startID, nodes);
        startNode.distance = 0;

        while (!unvisited.isEmpty()) {
            Node current = unvisited.stream()
                    .min(Comparator.comparingInt(Node::getDistance))
                    .orElseThrow();
            unvisited.remove(current);

            if (current.id == destinationID) {
                return current.distance;
            }

            for (Edge edge : edges) {
                if (edge.v1 == current) {
                    Node neighbor = edge.v2;
                    int tentativeDistance = current.distance + edge.weight;
                    if (tentativeDistance < neighbor.distance) {
                        neighbor.distance = tentativeDistance;
                        neighbor.previousID = (int) current.id;
                    }
                }
            }
        }

        return -1;
    }


}