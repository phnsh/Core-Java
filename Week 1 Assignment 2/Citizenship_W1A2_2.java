public class Citizenship_W1A2_2 {
	static boolean flag;
	public static void main(String args[]) {
		String citizenship = "INDIAN";
		int age = 22;
		boolean hasVoterId = true;		
		System.out.println(isEligibleForVoting(citizenship, age, hasVoterId));
	}
	 
	public static boolean isEligibleForVoting(String citizenship, int age, boolean hasVoterId) {
		if(citizenship.toUpperCase().equals("INDIAN") && age >= 18 && hasVoterId) {
			flag = true;
		}
		else {
			flag = false;
		}
		return flag;
	}
}