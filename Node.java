public class Node {
    private static long counter = 0;
    public final long id;

    public Node() {
        synchronized (Node.class) {
            this.id = ++counter;
        }
    }
}