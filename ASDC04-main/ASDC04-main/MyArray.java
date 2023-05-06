import java.util.Random;

public class MyArray {
    private int[][] array;
    private int[] iliffe;
    private int numRows;
    private int numCols;

    public MyArray(int numRows, int numCols, int minRow, int maxRow, int minCol, int maxCol) {
        this.numRows = numRows;
        this.numCols = numCols;
        array = new int[numRows][numCols];
        iliffe = new int[numRows * numCols];

        Random rand = new Random();
        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                int val = rand.nextInt(100);
                array[i][j] = val;
                iliffe[getIndex(i, j)] = val;
            }
        }
    }
    public int[] getRowVectors() {
        int[] rowVectors = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            int rowSum = 0;
            for (int j = 0; j < numCols; j++) {
                rowSum += array[i][j];
            }
            rowVectors[i] = rowSum;
        }
        return rowVectors;
    }
    public int[] getColVectors() {
        int[] colVectors = new int[numCols];
        for (int i = 0; i < numCols; i++) {
            int sum = 0;
            for (int j = 0; j < numRows; j++) {
                sum += array[j][i];
            }
            colVectors[i] = sum;
        }
        return colVectors;
    }

    public int[][] getIliffeVectors() {
        int[][] iliffeVectors = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                iliffeVectors[i][j] = iliffe[getIndex(i, j)];
            }
        }
        return iliffeVectors;
    }


    public int get(int i, int j) {
        return array[i][j];
    }

    public int getIliffe(int i, int j) {
        return iliffe[getIndex(i, j)];
    }

    private int getIndex(int i, int j) {
        return i * numCols + j;
    }
    public int getNumRows() {
        return numRows;
    }
    public int getNumCols() {
        return numCols;
    }

}
