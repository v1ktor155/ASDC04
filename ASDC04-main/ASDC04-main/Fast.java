public class Fast {
    private MyArray array;
    private int[][] rowVectors;
    private int[][] colVectors;

    public Fast(MyArray array) {
        this.array = array;
        rowVectors = new int[array.getNumRows() * 2 - 1][array.getNumCols()];
        colVectors = new int[array.getNumRows()][array.getNumCols() * 2 - 1];
        computeRowVectors();
        computeColVectors();
    }

    private void computeRowVectors() {
        for (int i = 0; i < array.getNumRows(); i++) {
            for (int j = 0; j < array.getNumCols(); j++) {
                rowVectors[i + j][j] = array.get(i, j);
            }
        }
        for (int i = array.getNumRows(); i < rowVectors.length; i++) {
            int startRow = i - array.getNumCols() + 1;
            for (int j = 0; j < array.getNumCols(); j++) {
                rowVectors[i][j] = array.get(startRow + j, j);
            }
        }
    }

    private void computeColVectors() {
        for (int i = 0; i < array.getNumRows(); i++) {
            for (int j = 0; j < array.getNumCols(); j++) {
                colVectors[i][j + i] = array.get(i, j);
            }
        }
        for (int i = 0; i < array.getNumCols(); i++) {
            for (int j = 0; j < array.getNumRows(); j++) {
                colVectors[i + array.getNumRows()][j + i] = array.get(j, i);
            }
        }
    }
}