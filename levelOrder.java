package Interview_5;

import java.util.ArrayList;
import java.util.List;

public class levelOrder {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return result;
        }

        //与下标对应 层数从0开始
        helper(root,0);
        return result;
    }

    //辅助方法完成递归遍历的方法 先序遍历 根据层数将元素插入对应的数组
    private void helper(TreeNode root,int level){
        if(level == result.size()) {
            //达到的level层没有对应的数组 创建新数组加入result
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left,level + 1);
        }
        if(root.right != null) {
            helper(root.right, level + 1);
        }
    }
}
