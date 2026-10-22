import java.util.Comparator;

// Custom min heap for Node class
class Compare implements Comparator<Node> {
    public int compare(Node a, Node b) {

        // smaller freq first
        if (a.data != b.data)
            return a.data - b.data;

        // when freq are equal
        return a.index - b.index;
    }
}