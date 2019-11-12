package Interview_5;

//从最近公共祖先开始去找两个节点 节点可以找到但是不在同一棵子树
public class lowestCommonAncestor {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1.辅助方法 在root 中递归查找p和q 找到返回为1（一个两个都算 没有找到返回0
        //2.递归在左子树查找 + 递归在右子树查找 + 对比根节点
        //3.三个位置中，有两个地方找到了 当前节点就是最近公共祖先

        if(root == null){
            return null;
        }
        //辅助方法
        findNode(root,p,q);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = findNode(root.left,p,q) ? 1 : 0;
        int right = findNode(root.right,p,q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if(left + right + mid >= 2) {
            //找到lca就是当前的root
            lca = root;
        }
        return (left + right + mid) > 0;//这个点找到了
    }
}
