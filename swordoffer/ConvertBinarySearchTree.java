class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return pRootOfTree;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        //递归左子树
        TreeNode left = Convert(pRootOfTree.left);
        //定位到左子树最后一个结点
        TreeNode p = left;
        while(p != null && p.right != null) {
            p = p.right;
        }
        //若有左子树，将根连到末尾
        if(left != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        //递归右子树
        TreeNode right = Convert(pRootOfTree.right);
        //若右子树不为空，添加到根后面
        if(right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return (left != null ? left : pRootOfTree);
    }
}
