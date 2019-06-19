public class Factorial_W2A1_3 {
    static int product = 1;
    public static void main(String args[]) {
        int num = 4;
        System.out.println(recursion(num));
    }

    static int recursion(int num) {
        if(num > 0) {
            product = product * num;
            recursion(num - 1);
        }
        return product;
    }
}