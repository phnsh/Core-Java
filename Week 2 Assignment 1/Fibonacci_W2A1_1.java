public class Fibonacci_W2A1_1 {
	static int temp1 = 0, temp2 = 1, temp3 = 0;
	public static void main(String arg[]) {
		int num = 9;
		System.out.print(temp1 + " " + temp2 + " ");
		recursion(num);
	}
	
	static void recursion(int num) {
		if(num > 0) {
			temp3 = temp1 + temp2;
			temp1 = temp2;
			temp2 = temp3;
			System.out.print(temp3 + " ");
			recursion(num - 1);
		}
	}
}