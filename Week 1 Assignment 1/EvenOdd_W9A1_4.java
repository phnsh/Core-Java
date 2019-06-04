import java.util.Arrays;

public class EvenOdd_W9A1_4 {
	public static void main(String arg[]) {
		int[] arr = {4,5,12,34,24,53,77,89};
		int[] even;
		int[] odd;
		int counter = 0;
		int evenIndex = 0, oddIndex = 0;
		
		//counting array length to be assigned for even and odd arrays
		for(int index = 0; index < arr.length; index++) {
			if(arr[index] % 2 == 0) {
				counter++;
			}
		}
		//assigning array length
		even = new int[counter];
		odd = new int[arr.length - counter];
		//parsing for even and odd numbers and adding them to respective arrays
		for(int index = 0; index < arr.length; index++) {
			if(arr[index] % 2 == 0) {
				even[evenIndex] = arr[index];
				evenIndex++;
			}
			else {
				odd[oddIndex] = arr[index];
				oddIndex++;
			}
		}
		System.out.println("Even: " + Arrays.toString(even) + "\nOdd: " + Arrays.toString(odd));
	}
}