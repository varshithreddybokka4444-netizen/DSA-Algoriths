

public class kthLevel {
    public  static void printKthLevel(Node root, int k){
        if(root==null){
            return;
        }
        if(k==1){
            System.out.println(root.val);
        }

        printKthLevel(root.left,k-1);
        printKthLevel(root.right,k-1);
    }
    public static void main(String[] args){
      //  BinaryTreesCreation bct    = new BinaryTreesCreation();
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTreesCreation.BinaryTree tree = new BinaryTreesCreation.BinaryTree();

        Node root = tree.buildTree(nodes);

        printKthLevel(root,1);

    }
}
