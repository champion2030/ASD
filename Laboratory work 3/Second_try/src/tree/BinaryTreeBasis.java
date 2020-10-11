package tree;

import shape.Circle;

public abstract class BinaryTreeBasis {

    public TreeNode root;

    public BinaryTreeBasis() {
        root = null;
    }


    public BinaryTreeBasis(Circle rootCircle) {
        root = new TreeNode(rootCircle, null, null);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public TreeNode getRoot() throws TreeException {
        if (root == null) {
            throw new TreeException("tree.TreeException: Empty Tree");
        }

        return root;
    }

    public abstract void setRootItem(Circle newCircle);

}