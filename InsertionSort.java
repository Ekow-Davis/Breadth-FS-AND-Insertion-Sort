import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] array, boolean ascending) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            if (ascending) {
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
            } else {
                while (j >= 0 && array[j] < key) {
                    array[j + 1] = array[j];
                    j = j - 1;
                }
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter sorting order (1 for Ascending, 2 for Descending):");
        int order = scanner.nextInt();
        boolean ascending = (order == 1);

        insertionSort(array, ascending);

        System.out.println("Sorted array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        scanner.close();
    }
}
