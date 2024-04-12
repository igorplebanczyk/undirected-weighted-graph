public class Node {
    private static long counter = 0;
    public final long id;

    public int previousID;
    public int distance;

    public Node() {
        synchronized (Node.class) {
            this.id = ++counter;
        }
    }
}