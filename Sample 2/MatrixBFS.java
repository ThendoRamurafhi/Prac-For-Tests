import java.util.LinkedList;
import java.util.Queue;

public class MatrixBFS {
    // Directions for moving up, down, left, right
    private final int[] rowDirections = {-1, 1, 0, 0};
    private final int[] colDirections = {0, 0, -1, 1};

    public void bfs(int[][] matrix, int startRow, int startCol) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            System.out.println("Visited node: (" + row + ", " + col + ") with value " + matrix[row][col]);

            // Explore all four possible directions
            for (int i = 0; i < 4; i++) {
                int newRow = row + rowDirections[i];
                int newCol = col + colDirections[i];

                if (isValid(newRow, newCol, rows, cols) && !visited[newRow][newCol] && matrix[newRow][newCol] == 1) {
                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 0, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 0}
        };

        MatrixBFS bfs = new MatrixBFS();
        System.out.println("BFS starting from (0, 0):");
        bfs.bfs(matrix, 0, 0);
    }
}
