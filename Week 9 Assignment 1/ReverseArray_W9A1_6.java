import java.util.Arrays;

public class ReverseArray_W9A1_6 {
	public static void main(String arg[]) {
		int[] arr = {4,23,1,12,67};
		int arrLength = arr.length;
		int[] newArr = new int[arrLength];
		 
		for(int index = 0; index < arrLength; index++) {
			newArr[index] = arr[arrLength - (index + 1)];
		}
		
		System.out.println(Arrays.toString(newArr));
	}
}