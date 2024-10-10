public class DFS {

    // Preorder Traversal (Root -> Left -> Right)
    public void dfsPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        dfsPreorder(root.left);
        dfsPreorder(root.right);
    }

    // Inorder Traversal (Left -> Root -> Right)
    public void dfsInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        dfsInorder(root.left);
        System.out.print(root.value + " ");
        dfsInorder(root.right);
    }

    // Postorder Traversal (Left -> Right -> Root)
    public void dfsPostorder(TreeNode root) {
        if (root == null) {
            return;
        }
        dfsPostorder(root.left);
        dfsPostorder(root.right);
        System.out.print(root.value + " ");
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
