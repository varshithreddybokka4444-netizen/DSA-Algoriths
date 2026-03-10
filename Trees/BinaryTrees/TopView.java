import java.util.*;

//class Node {
//    int data;
//    Node left, right;
//
//    Node(int data) {
//        this.data = data;
//        left = right = null;
//    }
//}

class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopView {

    public static List<Integer> topView(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair p = q.poll();
            Node cur = p.node;
            int hd = p.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, cur.val);
            }

            if (cur.left != null) {
                q.add(new Pair(cur.left, hd - 1));
            }

            if (cur.right != null) {
                q.add(new Pair(cur.right, hd + 1));
            }
        }

        for (int val : map.values()) {
            result.add(val);
        }

        return result;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        System.out.println(topView(root));
    }
}