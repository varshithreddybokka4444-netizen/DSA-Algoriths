import java.util.*;


public class BinaryTreesCreation {

  static class BinaryTree{
      static int idx = -1;
      public static Node buildTree(int[] nodes){
          idx++;
    if (nodes[idx] == -1) {
              return null;
          }

      Node newNode = new Node(nodes[idx]);
      newNode.left = buildTree(nodes);
      newNode.right = buildTree(nodes);

      return newNode;
      }
  }
  public static void preOrder(Node root){
      if(root==null){
          System.out.print(-1 + " ");
          return;
      }
      System.out.print(root.val + " ");
      preOrder(root.left);
      preOrder(root.right);

  }
  public static void inOrder(Node root){
      if(root==null){
          System.out.print(-1+" ");
          return;
      }
      inOrder(root.left);
      System.out.print(root.val+" ");
      inOrder(root.right);
  }
  public static void postOrder(Node root){
      if(root==null){
          System.out.print(-1+" ");
          return;
      }
      postOrder(root.left);
      postOrder(root.right);
      System.out.print(root.val+" ");
  }
    public static void levelOrder(Node root){
      if(root==null){
          return;
      }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(q.size()>0) {
            Node cur = q.poll();
            if (cur==null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                }else {
                    q.add(null);
                }
            } else {
                System.out.print(cur.val+" ");
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
    }
    public static int countOfNodes(Node root){
       if(root==null){
           return 0;
       }
      int leftNodes = countOfNodes(root.left);
      int rightNodes = countOfNodes(root.right);

      return leftNodes+rightNodes+1;
    }
    public static int sumOfNodes(Node root){
      if(root==null){
          return 0;
      }
      int leftSum = sumOfNodes(root.left);
      int rightSum = sumOfNodes(root.right);

      return leftSum+rightSum+root.val;
    }
    public static int heightOfTree(Node root){
    if(root==null){
        return 0;
    }
    int leftHeight = heightOfTree(root.left);
    int rightHeight = heightOfTree(root.right);

    return Math.max(leftHeight,rightHeight)+1;
    }
    public static int diameter(Node root){
      if(root==null){
          return 0;
      }
      int diameter1 = diameter(root.left);
      int diameter2 = diameter(root.right);

      int diameter3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
      return Math.max(diameter3,Math.max(diameter1,diameter2));
    }
    static class TreeInfo {
    int height;
    int dia;
    TreeInfo(int height,int dia){
        this.height = height;
        this.dia = dia;
    }
    }
    public static TreeInfo diameter2(Node root){

      if(root==null){
          return new TreeInfo(0,0);
      }

      TreeInfo left = diameter2(root.left);
      TreeInfo right = diameter2(root.right);

      int myHeight = Math.max(left.height,right.height) + 1;

      int diameter1 = left.dia;
      int diameter2 = right.dia;
      int diameter3 = left.height + right.height + 1;

      int mydia = Math.max(diameter3,Math.max(diameter1,diameter2));

      TreeInfo myInfo = new TreeInfo(myHeight,mydia);

      return myInfo;
  }
public void topView(Node root){
      Queue<Node> q = new LinkedList<>();
}

    static int sumTree(Node root){
        if(root==null){
            return 0;
        }
        int left= sumTree(root.left);
        int right = sumTree(root.right);
        root.val = root.val+left+right;
        return root.val;
}


  public static void main(String[] args){
      int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
      BinaryTree tree = new BinaryTree();
      Node root = tree.buildTree(nodes);
      preOrder(root);
      System.out.println(sumTree(root));
        preOrder(root);
//      System.out.println();
//      inOrder(root);
//      System.out.println();
//      postOrder(root);
    //  System.out.println(diameter2(root).dia);
  }








}