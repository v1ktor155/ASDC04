public class Main {
    public static void main(String[] args) {
        MyArray array = new MyArray(1000, 1000, 0, 999, 0, 999);

        long start = System.nanoTime();
        int x = array.get(500, 500);
        long end = System.nanoTime();
        System.out.println("Прямой доступ: " + (end - start) + " наносекунд");

        start = System.nanoTime();
        int[] rowVectors = array.getRowVectors();
        int[] colVectors = array.getColVectors();
        x = rowVectors[500] + colVectors[500];
        end = System.nanoTime();
        System.out.println("Определяющие векторы: " + (end - start) + " наносекунд");

        start = System.nanoTime();
        int[][] iliffeVectors = array.getIliffeVectors();
        x = iliffeVectors[500][500];
        end = System.nanoTime();
        System.out.println("Векторы Айлиффа: " + (end - start) + " наносекунд");
    }
}
