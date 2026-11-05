public class GeneralTree {
    private String[] data;
    private int[] parent;
    private int[] firstChild;
    private int[] nextSibling;

    private int size;
    private int capacity;

    public GeneralTree(int capacity) {
        this.capacity = capacity;
        this.data = new String[capacity];
        this.parent = new int[capacity];
        this.firstChild = new int[capacity];
        this.nextSibling = new int[capacity];
        this.size = 0;

        for (int i = 0; i < capacity; i++) {
            parent[i] = -1;
            firstChild[i] = -1;
            nextSibling[i] = -1;
        }
    }

    public int addRoot(String nodeData) {
        if (size > 0) {
            throw new RuntimeException("Cây đã có gốc!");
        }
        data[0] = nodeData;
        size++;
        return 0;
    }

    public int addChild(int parentIndex, String nodeData) {
        if (parentIndex < 0 || parentIndex >= size) {
            throw new IllegalArgumentException("Khong co chi so nut cha");
        }
        if (size >= capacity) {
            throw new RuntimeException("Full cay");
        }

        int newNodeIndex = size;
        data[newNodeIndex] = nodeData;
        parent[newNodeIndex] = parentIndex;
        size++;

        if (firstChild[parentIndex] == -1) {
            firstChild[parentIndex] = newNodeIndex;
        } else {
            int current = firstChild[parentIndex];
            while (nextSibling[current] != -1) {
                current = nextSibling[current];
            }
            nextSibling[current] = newNodeIndex;
        }

        return newNodeIndex;
    }

    public int getParent(int u) {
        if (u < 0 || u >= size) return -1;
        return parent[u];
    }

    public int getFirstChild(int u) {
        if (u < 0 || u >= size) return -1;
        return firstChild[u];
    }

    public int getNextSibling(int u) {
        if (u < 0 || u >= size) return -1;
        return nextSibling[u];
    }
    public String getData(int index) {
        if (index == -1) return "null";
        return data[index];
    }


    public static void main(String[] args) {
        GeneralTree tree = new GeneralTree(10);

        int a = tree.addRoot("A");
        int b = tree.addChild(a, "B");
        int c = tree.addChild(a, "C");
        int d = tree.addChild(a, "D");
        int e = tree.addChild(b, "E");
        int f = tree.addChild(b, "F");
        int g = tree.addChild(d, "G");


        System.out.println("Bo cua F(5): " + tree.getData(tree.getParent(f))); // Output: B

        System.out.println("Con truong cua A(0): " + tree.getData(tree.getFirstChild(a))); // Output: B
        System.out.println("Con truong cua B(1): " + tree.getData(tree.getFirstChild(b))); // Output: E

        System.out.println("Em lien ke cua B(1): " + tree.getData(tree.getNextSibling(b))); // Output: C
        System.out.println("Em lien ke cua C(2): " + tree.getData(tree.getNextSibling(c))); // Output: D
        System.out.println("Em lien ke cua D(3): " + tree.getData(tree.getNextSibling(d))); // Output: NULL
    }
}