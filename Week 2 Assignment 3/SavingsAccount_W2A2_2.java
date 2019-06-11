public class SavingsAccount_W2A2_2 {
    private double balance;
    private String customerName;
    private int customerAge;
    private String nomineeName;
    private long panNumber;
	private boolean withdraw = false;
	private boolean deposit = false;

    public SavingsAccount_W2A2_2(String custName, int custAge, long panNo) {
        customerName = custName;
        customerAge = custAge;
        panNumber = panNo;
    }

    public void updateNomineeDetails(String name) {
        nomineeName = name;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(String withdrawUsing) {
		if(withdrawUsing.equals("withdrawSlip") || withdrawUsing.equals("atm")) {
			withdraw = true;
		}
		if(withdraw) {
			//withdraw money code here
		}
    }

    public void deposit(String depositUsing) {
		if(depositUsing.equals("challan") || depositUsing.equals("atm")) {
			deposit = true;
		}
		if(deposit) {
			//deposit money code here
		}
    }
    public static void main(String args[]) {

    }
}