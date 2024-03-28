import java.util.Scanner; 

public class IdenticalArrays {
   public static void main(String[] args) {
        /** prompts user for input of arrays */
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the elements of the first 3x3 array: ");
        int[][] m1 = readArray(input, 3, 3);

        System.out.println("Enter the elemetns of the second 3x3 array: ");
        int[][] m2 = readArray(input, 3, 3);
        
        if (equals(m1, m2)) {
            System.out.println("THe two arrays are identical.");
        } else {
            System.out.println("The two arrays are not identical.");
        }
        input.close();
   }
   
   public static int[][] readArray(Scanner input, int rows, int cols) {
    int[][] array = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            array[i][j] = input.nextInt();
        }
    }
    return array;
   }

   /** Checks if arrays are identical */
   public static boolean equals(int[][] m1, int[][] m2) {
    if (m1.length != m2.length || m1[0].length != m2[0].length) {
        return false;
    }
    for (int i = 0; i < m1.length; i++) {
        for (int j = 0; j < m1[0].length; j++) {
            if (m1[i][j] != m2[i][j]) {
                return false;
            }
        }
    }
    return true;
   }
}
