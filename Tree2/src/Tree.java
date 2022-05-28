public class Tree {
    public static class Node {
        private Object item;
        private Node down = null;
        private Node right = null;

        public Node(Object item) {
            this.item = item;
        }

        public Node(Object item, Node down, Node right) {
            this.item = item;
            this.down = down;
            this.right = right;
        }

        public Node down() {
            return this.down;
        }

        public Node right() {
            return this.right;
        }
    }

    private Node root = null;

    public Tree() {
        this.root = new Node("root");

    }

    public Node root() {
        return this.root;
    }

    public void addNodeToDown(Node sourceNode) {
        sourceNode.down = new Node("down");
    }

    public void addNodeToRight(Node sourceNode) {
        sourceNode.right = new Node("right");
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            return height(node.down) + 1;
        }
    }


}