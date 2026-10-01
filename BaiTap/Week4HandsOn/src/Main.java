import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // First input = 1 number
        int n = sc.nextInt();
        sc.nextLine(); // consume the leftover newline

        int[] arr = new int[n];

        // Second input = numbers separated by whitespace
        String input = sc.nextLine(); // "1 2 3 10 5"
        String[] parts = input.split(" ");

        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        // SORT
        for (int i = 0; i < arr.length - 1; i++) {
            int current = arr[i];
            int currentLowest = arr[i];
            int currentLowestIndex = i;
            for  (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < currentLowest) {
                    currentLowest = arr[j];
                    currentLowestIndex = j;
                }
            }
            if (currentLowest < current) {
                // Swap;
                int temp = arr[i];
                arr[i] = currentLowest;
                arr[currentLowestIndex] = temp;
            }
        }
        //
        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            //System.out.print(arr[i] + " "); for testing
        }

        int h = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[arr.length - 1 - i] >= i + 1) {
                h = i + 1;
            }
        }
        System.out.println();
        System.out.println(h);
    }
}

