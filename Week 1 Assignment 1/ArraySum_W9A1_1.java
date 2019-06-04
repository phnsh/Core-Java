public class ArraySum_W9A1_1 {
	public static void main(String arg[]) {
		int[] arr = {12,23,1,23,5,6,67};
		int sum = 0;
		for(int index = 0; index < arr.length; index++) {
			sum += arr[index];
		}
		System.out.println(sum);
	}
}