import java.util.Arrays;

public class Reverse_W2A1_4 {
    static int[] arr = {3,4,6,7,9};
    static int[] reversedArray = new int[arr.length];
    static int counter = 0;
    public static void main(String args[]) {
        System.out.println(recursion(arr.length));
    }

    static String recursion(int arrLength) {
        if(arrLength > 0) {
            reversedArray[counter] = arr[(arr.length - 1) - counter];
            counter++;
            recursion(arrLength - 1);
        }
        return Arrays.toString(reversedArray);
    }
}