public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        System.out.println("Height of the tree = " + tree.height());
        tree.addNodeToLeft(tree.root());
        tree.addNodeToRight(tree.root());
        System.out.println("Height of the tree = " + tree.height());
        tree.addNodeToLeft(tree.root().left());
        tree.addNodeToRight(tree.root().right());
        System.out.println("Height of the tree = " + tree.height());
        tree.addNodeToRight(tree.root().left());
        tree.addNodeToLeft(tree.root().right());
        System.out.println("Height of the tree = " + tree.height());
        tree.addNodeToRight(tree.root().right().right());
        System.out.println("Height of the tree = " + tree.height());
    }
}