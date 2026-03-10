

public class InorderTraversal {
    public void morrisInorder(Node root){
        Node cur = root;
        Node ip = null;

        while(cur!=null){
            if(cur.left==null){
               System.out.println(cur.val);
               cur = cur.right;
            }
            else{
                ip = cur.left;
                while(ip.right!=null&&ip.right!=cur){
                    ip = ip.right;
                }

                if(ip.right==null){
                    ip.right = cur;//create thread
                    cur = cur.left;
                }
                else{
                    ip.right = null;//delete thread
                    System.out.println(cur.val);
                    cur = cur.right;
                }
            }
        }


    }









    public static void main(String[] args){
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTreesCreation.BinaryTree tree = new BinaryTreesCreation.BinaryTree();
        Node root = tree.buildTree(nodes);
        BinaryTreesCreation.preOrder(root);

    }
}
