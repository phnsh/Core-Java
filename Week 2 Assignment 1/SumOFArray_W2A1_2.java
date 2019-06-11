public class SumOFArray_W2A1_2 {
    static int sum = 0, i = 0;
    static int[] arr = {3,4,2,7,9};
    public static void main(String args[]) {
        System.out.println(recursion(arr.length));
    }
    static int recursion(int arrLength) {
        if(arrLength > 0) {
            sum += arr[i];
            i++;
            recursion(arrLength - 1);
        }
        return sum;
    }
}