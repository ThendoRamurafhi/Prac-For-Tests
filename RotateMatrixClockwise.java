import java.util.*;

public class RotateMatrixClockwise {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int row = input.nextInt();
        int column = input.nextInt();

        int [][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        // transpose matrix
        int [][] transposedMatrix = new int[column][row];
        for (int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++){
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                System.out.print(transposedMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Clockwise rotation");
        // clockwise rotation
        int [][] rotatedMatrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                rotatedMatrix[i][j] = matrix[column - j - 1][i];
            }
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("AntiClockwise rotation");

        // Anticlockwise rotaion
        int [][] antiRotatedMatrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                antiRotatedMatrix[i][j] = rotatedMatrix[row - i - 1][j];
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                System.out.print(antiRotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
