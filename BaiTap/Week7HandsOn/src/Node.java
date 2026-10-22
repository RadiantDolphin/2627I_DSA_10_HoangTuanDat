// Class to represent Huffman tree node
class Node {

    // frequency
    int data;

    // smallest original index in subtree
    int index;

    // smallest original index in subtree
    Node left, right;

    // Leaf node
    Node(int d, int i) {
        data = d;
        index = i;
        left = right = null;
    }

    // Internal node
    Node(Node l, Node r) {
        data = l.data + r.data;

        // important for tie-break
        index = Math.min(l.index, r.index);
        left = l;
        right = r;
    }
}

//