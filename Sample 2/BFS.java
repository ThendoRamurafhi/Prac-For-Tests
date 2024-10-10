import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public void bfs(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.value + " ");

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // BFS Traversal
        System.out.println("BFS Traversal:");
        BFS bfsTraversal = new BFS();
        bfsTraversal.bfs(root);
        System.out.println();

        // DFS Traversal (Preorder)
        System.out.println("DFS Preorder Traversal:");
        DFS dfsTraversal = new DFS();
        dfsTraversal.dfsPreorder(root);
        System.out.println();

        // DFS Traversal (Inorder)
        System.out.println("DFS Inorder Traversal:");
        dfsTraversal.dfsInorder(root);
        System.out.println();

        // DFS Traversal (Postorder)
        System.out.println("DFS Postorder Traversal:");
        dfsTraversal.dfsPostorder(root);
        System.out.println();
    }
}
