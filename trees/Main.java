public class Main {

    // Trees isn't sure to be either abstract data type or data structure (tree can dictate how to organize data)
    // Trees is hierarchy data structure
    // Each circle of tree is called Node
    // Each Node can only have one data and one parent, but you can have many children
    // Node which is at the top of the tree is Root
    // Node which has no children is Leaf
    // Path(arrow) between Node is called Edge
    // Subtree of node A is descendants of Node A
    // Height of node A is number of Edges, counted from the longest path from Node A to Leaf
    // Dept of node A is number of Edges, counted from Node A to Root

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(25);
        binarySearchTree.insert(20);
        binarySearchTree.insert(15);
        binarySearchTree.insert(27);
        binarySearchTree.insert(30);
        binarySearchTree.insert(29);
        binarySearchTree.insert(26);
        binarySearchTree.insert(22);
        binarySearchTree.insert(32);
        binarySearchTree.traverseInOrder();
        System.out.println();
        System.out.println("Retrieve: " + binarySearchTree.get(27));
        System.out.println("Retrieve: " + binarySearchTree.get(8888));
        System.out.println("Minimum value of this tree: " + binarySearchTree.min());
        System.out.println("Maximum value of this tree: " + binarySearchTree.max());
        binarySearchTree.delete(15);
        binarySearchTree.traverseInOrder();
        System.out.println();
        binarySearchTree.delete(27);
        binarySearchTree.traverseInOrder();
        System.out.println();
        binarySearchTree.delete(25);
        binarySearchTree.traverseInOrder();
        System.out.println();
    }
}
