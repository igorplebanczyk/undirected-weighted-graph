import java.util.*;

public class Graph {
    ArrayList<Node> nodes = new ArrayList<>();
    ArrayList<Edge> edges = new ArrayList<>();

    public void addNode() {
        Node node = new Node();
        nodes.add(node);
    }

    public void removeNode(int id) {
        edges.removeIf(edge -> edge.v1.id == id || edge.v2.id == id);
        nodes.removeIf(node -> node.id == id);
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void addEdge(Node v1, Node v2, int weight) {
        Edge newEdge = new Edge(v1, v2, weight);
        edges.add(newEdge);
    }

    public void removeEdge(Node v1, Node v2, int weight) {
        edges.removeIf(edge -> edge.v1 == v1 && edge.v2 == v2 && edge.weight == weight);
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
        assert startNode != null;
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

    // Kruskal's Algorithm
    private Node findNode(int id, ArrayList<Node> list) {
        for (Node node : list) {
            if (node.id == id) {
                return node;
            }
        }
        return null;
    }

    private Node findParent(Node node, HashMap<Long, Node> parent) {
        if (parent.get(node.id) != node) {
            parent.put(node.id, findParent(parent.get(node.id), parent));
        }
        return parent.get(node.id);
    }

    private void union(Node node1, Node node2, HashMap<Long, Node> parent, HashMap<Long, Integer> rank) {
        Node root1 = findParent(node1, parent);
        Node root2 = findParent(node2, parent);

        if (root1 != root2) {
            if (rank.get(root1.id) < rank.get(root2.id)) {
                parent.put(root1.id, root2);
            } else if (rank.get(root1.id) > rank.get(root2.id)) {
                parent.put(root2.id, root1);
            } else {
                parent.put(root2.id, root1);
                rank.put(root1.id, rank.get(root1.id) + 1);
            }
        }
    }

    public ArrayList<Edge> kruskalMST() {
        ArrayList<Edge> mst = new ArrayList<>();

        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        HashMap<Long, Node> parent = new HashMap<>();
        HashMap<Long, Integer> rank = new HashMap<>();

        for (Node node : nodes) {
            parent.put(node.id, node);
            rank.put(node.id, 0);
        }

        for (Edge edge : edges) {
            Node root1 = findParent(edge.v1, parent);
            Node root2 = findParent(edge.v2, parent);

            if (root1 != root2) {
                mst.add(edge);
                union(edge.v1, edge.v2, parent, rank);
            }
        }

        return mst;
    }

    // Prim's Algorithm
    public ArrayList<Edge> primMST() {
        ArrayList<Edge> mst = new ArrayList<>();
        if (nodes.isEmpty()) return mst;

        HashMap<Node, Boolean> inMST = new HashMap<>();
        for (Node node : nodes) {
            inMST.put(node, false);
        }

        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        Node startNode = nodes.getFirst();

        addEdgesToQueue(startNode, edgeQueue, inMST);

        while (!edgeQueue.isEmpty()) {
            Edge minEdge = edgeQueue.poll();
            if (!inMST.get(minEdge.v2)) {
                mst.add(minEdge);
                addEdgesToQueue(minEdge.v2, edgeQueue, inMST);
            }
        }

        return mst;
    }

    private void addEdgesToQueue(Node node, PriorityQueue<Edge> edgeQueue, HashMap<Node, Boolean> inMST) {
        inMST.put(node, true);
        for (Edge edge : edges) {
            if (edge.v1 == node && !inMST.get(edge.v2)) {
                edgeQueue.add(edge);
            } else if (edge.v2 == node && !inMST.get(edge.v1)) {
                edgeQueue.add(new Edge(edge.v2, edge.v1, edge.weight));
            }
        }
    }

    // Minimal Chromatic Number
    public int minimalChromaticNumber() {
        if (nodes.isEmpty()) return 0;

        HashMap<Node, Integer> colorMap = new HashMap<>();
        colorMap.put(nodes.getFirst(), 0);

        for (int i = 1; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            Set<Integer> usedColors = new HashSet<>();
            for (Edge edge : edges) {
                if (edge.v1 == node) {
                    Node neighbor = edge.v2;
                    if (colorMap.containsKey(neighbor)) {
                        usedColors.add(colorMap.get(neighbor));
                    }
                } else if (edge.v2 == node) {
                    Node neighbor = edge.v1;
                    if (colorMap.containsKey(neighbor)) {
                        usedColors.add(colorMap.get(neighbor));
                    }
                }
            }

            int cr;
            for (cr = 0; cr < nodes.size(); cr++) {
                if (!usedColors.contains(cr)) {
                    break;
                }
            }

            colorMap.put(node, cr);
        }

        int maxColor = 0;
        for (int color : colorMap.values()) {
            if (color > maxColor) {
                maxColor = color;
            }
        }

        return maxColor + 1;
    }
}