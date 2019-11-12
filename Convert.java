package Interview_5;

//二叉搜索树是一种特殊的二叉树 为了加快搜索 左子树小于根节点 右子树大于根节点
//二叉搜索树的中序遍历结果是有序的
public class Convert {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        //使用中序遍历得到有序序列
        //把相邻元素相互指向，left指向前一个元素，right指向后一个元素

        //1.特殊情况 空树or一个节点
        if(pRootOfTree == null){
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }

        //2.递归把左子树变成双向链表，返回链表的第一个节点
        TreeNode left = Convert(pRootOfTree.left);
        //3.左子树链表 + root

        TreeNode leftTail = left;
        while(leftTail != null && leftTail.right != null){
            leftTail = leftTail.right;
        }
        //////////////////////////////////////todo left为空
        if(left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        //4.递归把右子树变成双向链表，左子树链表 + root + 右子树链表
        TreeNode right = Convert(pRootOfTree.right);

        if(right != null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }

        //返回整个链表的头节点
        return left == null ? pRootOfTree : left;
    }
}
