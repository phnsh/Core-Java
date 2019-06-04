import java.util.Arrays;

public class LargeSmall_W9A1_2 {
	public static void main(String args[]) {
		//first solution
		int[] arr = {2,34,12,29,5,6,67,45};
		int largest = arr[1];
		int smallest = arr[1];
		
		for(int index = 0; index < arr.length; index++) {
			if(arr[index] > largest) {
				largest = arr[index];
			}
			else if(arr[index] < smallest) {
				smallest = arr[0];
			}
		}
		System.out.println("Largest: " + largest + "\nSmallest: " + smallest);
		System.out.println();
		
		//Second and easiest solution
		Arrays.sort(arr);
		System.out.println("Largest: " + arr[arr.length - 1] + "\nSmallest: " + arr[0]);
		//other conditions can be added to check for array length, etc for efficiency
	}
}