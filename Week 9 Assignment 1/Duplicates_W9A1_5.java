import java.util.Arrays;
import java.util.ArrayList;

 public class Duplicates_W9A1_5 {
	
	public static void main(String arg[]) {
		ArrayList<Integer> arrList= new ArrayList<Integer>();
		int counter = 0;
		int[] arr = {4,56,2,34,56,4,78,99,56};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					counter++;
				}
			}
			if(counter > 1 && !arrList.contains(arr[i])) {
				arrList.add(arr[i]);
				System.out.println(arr[i] + " is repeated " + counter + " times");
			}
			counter = 0;
		}
		System.out.println("Duplicates: " + arrList);
	}
}