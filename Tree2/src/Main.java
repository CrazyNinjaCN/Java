public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        System.out.println("Height of the tree = " + tree.height());
        tree.addNodeToDown(tree.root());
        tree.addNodeToRight(tree.root().down());
        tree.addNodeToRight(tree.root().down().right());
        tree.addNodeToRight(tree.root().down().right().right());
        tree.addNodeToRight(tree.root().down().right().right().right());
        tree.addNodeToDown(tree.root().down());
        tree.addNodeToRight(tree.root().down().right());
        tree.addNodeToRight(tree.root().down().right().right());
        tree.addNodeToRight(tree.root().down().down());
        tree.addNodeToRight(tree.root().down().down().right());
        System.out.println("Height of the tree = " + tree.height());
    }
}