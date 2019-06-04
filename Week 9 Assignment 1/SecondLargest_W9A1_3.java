import java.util.Arrays;

public class SecondLargest_W9A1_3 {
	public static void main(String args[]) {
		int[] arr = {4,56,12,34,24,46,77,89};
		int largest = arr[1];
		int secondLargest = 0;
		
		for(int index = 0; index < arr.length; index++) {
			if(arr[index] > largest) {
				secondLargest = largest;
				largest = arr[index];
			}
		}
		System.out.println("Second largest: " + secondLargest);
	}
}