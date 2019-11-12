package Interview_5;

import java.util.Scanner;

public class Solution {

    static class TreeNode{
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    //二叉树构建和遍历 ABC##DE#G##F###
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //line是一组先序遍历的结果（含有#
            String line = scanner.next();
            TreeNode root = buildTree(line);
            inorder(root);
            System.out.println();
        }
    }

    static int index = 0;
    public static TreeNode buildTree(String line) {
        index = 0; //记录递归过程中访问到第几个字符
        return createTreePreOrder(line);
    }

    //辅助函数完成递归
    public static TreeNode createTreePreOrder(String line){
        char c = line.charAt(index);//当前子树的根节点
        if(c == '#'){
            return null;
        }
        TreeNode root = new TreeNode(c);
        index++;
        root.left = createTreePreOrder(line);
        index++;
        root.right = createTreePreOrder(line);
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}
