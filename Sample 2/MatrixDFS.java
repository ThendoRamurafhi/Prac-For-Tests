public class MatrixDFS {
    // Directions for moving up, down, left, right
    private final int[] rowDirections = {-1, 1, 0, 0}; // Up, Down
    private final int[] colDirections = {0, 0, -1, 1}; // Left, Right

    public void dfs(int[][] matrix, int row, int col, boolean[][] visited) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        visited[row][col] = true;
        System.out.println("Visited node: (" + row + ", " + col + ") with value " + matrix[row][col]);

        // Explore all four possible directions
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowDirections[i];
            int newCol = col + colDirections[i];

            if (isValid(newRow, newCol, rows, cols) && !visited[newRow][newCol] && matrix[newRow][newCol] == 1) {
                dfs(matrix, newRow, newCol, visited);
            }
        }
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 0, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 0}
        };

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        MatrixDFS dfs = new MatrixDFS();

        System.out.println("DFS starting from (0, 0):");
        dfs.dfs(matrix, 0, 0, visited);
    }
}
