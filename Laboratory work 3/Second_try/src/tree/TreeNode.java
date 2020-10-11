package tree;

import shape.Circle;

public class TreeNode {

    public Circle rootCircle;
    public TreeNode leftCircle;
    public TreeNode rightCircle;
    public boolean highlightFlag;


    public TreeNode(Circle rootCircle, TreeNode leftCircle, TreeNode rightCircle) {
        this.rootCircle = rootCircle;
        this.leftCircle = null;
        this.rightCircle = null;
    }

}