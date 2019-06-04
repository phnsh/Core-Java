public class FirstRepeating_W1A2_3 {
	public static void main(String args[]) {
		int[] arr = {3,4,56,2,56,6,78,2};
		int counter = 0;
		for(int index = 0; index < arr.length; index++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[index] == arr[j]) {
					counter++;
				}
			}
			if(counter > 1) {
				System.out.println(arr[index]);
				break;
			}
			counter = 0;
		}
	}
}