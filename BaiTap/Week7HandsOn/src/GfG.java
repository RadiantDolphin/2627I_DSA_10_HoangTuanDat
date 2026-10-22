import java.util.ArrayList;
import java.util.PriorityQueue;

public class GfG {

    // Function to traverse tree in preorder
    // manner and push the Huffman representation
    // of each character.
    static void preOrder(Node root, ArrayList<String> ans, String curr) {
        if (root == null) return;

        // Leaf node represents a character.
        if (root.left == null && root.right == null) {

            // single character case
            if (curr.equals("")) curr = "0";
            ans.add(curr);
            return;
        }

        preOrder(root.left, ans, curr + '0');
        preOrder(root.right, ans, curr + '1');
    }

    static ArrayList<String> huffmanCodes(String s, int[] freq) {

        int n = s.length();

        // Min heap for Node class.
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());
        for (int i = 0; i < n; i++) {

            // include index
            Node tmp = new Node(freq[i], i);
            pq.add(tmp);
        }

        // single character
        if (n == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add("0");
            return res;
        }

        // Construct Huffman tree.
        while (pq.size() >= 2) {

            // Left node
            Node l = pq.poll();

            // Right node
            Node r = pq.poll();

            // internal node with freq + index
            Node newNode = new Node(l, r);
            pq.add(newNode);
        }

        Node root = pq.peek();
//Driver Code Starts
        ArrayList<String> ans = new ArrayList<>();
        preOrder(root, ans, "");
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcde";
        int[] freq = {30,2,18,4,20};
        ArrayList<String> ans = huffmanCodes(s, freq);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        // Bit Count
        int bitCount = 0;
        for (int i = 0; i < ans.size(); i++) {
            bitCount += ans.get(i).length() * freq[i];
        }
        System.out.println("Total bits: " + bitCount);
    }
}