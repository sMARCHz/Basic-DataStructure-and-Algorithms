import model.TreeNode;

public class BinarySearchTree {

    // Each Node must have only 0,1,2 children
    // Completed Tree is a tree that every level except last level is completely filled (ancestor's level is full)
    // Left Node always has smaller value than parent
    // Right Node always has larger value than parent
    // Every Node on the left of root has smaller value than the root (same as the right)
    // O(logn) - Retrieval, Insertion, Deletion

    // If value is keep smaller than parent so, the tree's shape is like LinkedList then time complexity isn't O(logn) anymore.
    // There's auto-balance tree in the world. This kind of tree keeps watching the tree and shift Node if it isn't balanced

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subTreeRoot, int value) {
        if (subTreeRoot == null) {
            return null;
        }
        if (value < subTreeRoot.getData()) {
            // scope to left
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
        } else if (value > subTreeRoot.getData()) {
            // scope to right
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        } else {
            // Case 1 and 2: Node to delete has 0 or 1 child
            if (subTreeRoot.getLeftChild() == null) {
                // if left and right is null, this will return null (replace with null)
                // if left is null but right isn't, this will return right node to replace
                return subTreeRoot.getRightChild();
            } else if (subTreeRoot.getRightChild() == null) {
                return subTreeRoot.getLeftChild();
            }

            // Case 3: Node to delete has 2 children

            // Replace value in the subTreeRoot with the smallest value in the right subtree
            subTreeRoot.setData(subTreeRoot.getRightChild().min());
            // Delete the node that has the smallest value in the right subtree (the node which was chosen to replace subTreeRoot)
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
        }
        return subTreeRoot;
    }

    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            return root.max();
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }
}
