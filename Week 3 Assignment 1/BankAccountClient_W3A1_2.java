// a. A BankAccount will contain the account holders name, account number,
//		the account creation date (string as of now), branch name and balance and Address

// b. A BankAccount can be either SavingsAccount or CurrentAccount or Salaried Account (a special type of savings account)
// c. Current account holders do not have withdrawal limit on their account balance whereas Savings account holders
// 		can only withdraw 25000 per day. 
// d. CurrentAccount holders should have a minimum account balance of Rs 25000. Regular savings account holders should
//		maintain 10000 rupees whereas Salaried account holders can maintain 0 balance. 
// e. There should be a provision to update Nominee details but they cannot update account number and name.
// f. The address should contain FlatNo, Street, City, State and pin code.
import java.util.Arrays;

abstract class BankAccount {
	private String acHolderName;
	private int acNumber;
	private String acCreationDate;
	public String branchName;
	private static double balance;
	public String[] address;

	public BankAccount(String acHolderName, int acNumber, String acCreationDate, String branchName, double bal, String[] address) {
		this.acHolderName = acHolderName;
		this.acNumber = acNumber;
		this.acCreationDate = acCreationDate;
		this.branchName = branchName;
		balance = bal;
		this.address = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double bal) {
		balance = bal;
	}

	abstract void updateNomineeDetails(String branchName, String[] address);

	public String getAcHolderName() {
		return acHolderName;
	}
	public int getAcNumber() {
		return acNumber;
	}
	public String getAcCreationDate() {
		return acCreationDate;
	}
	public String getBranchName() {
		return branchName;
	}
	public String getAddress() {
		return Arrays.toString(address);
	}
	abstract void getAccDetails();
}

interface accountRules {
	void withdrawFunc(double amount);
	boolean minAcBalanceMaintained();
}

class SavingsAccount extends BankAccount implements accountRules {
	
	public static double withdrawLimit = 25_000; // per day
	private static double minAcBalAmount = 10_000;

	public SavingsAccount(String acHolderName, int acNumber, String acCreationDate, String branchName, double balance,
			String[] address) {
		super(acHolderName, acNumber, acCreationDate, branchName, balance, address);
	}

	@Override
	public void withdrawFunc(double amount) {
		if(amount < withdrawLimit && getBalance() > minAcBalAmount) {
			setBalance(getBalance() - amount);
		}
	}

	@Override
	public boolean minAcBalanceMaintained() {
		if(getBalance() < minAcBalAmount) {
			return false;
		}
		else return true;
	}

	@Override
	void updateNomineeDetails(String branchName, String[] address) {
		this.branchName = branchName;
		this.address = address;
	}

	public void getAccDetails() {
		System.out.println(
			"\nAccount holder name: " + getAcHolderName() +
			"\nAccount number: " + getAcNumber() +
			"\nAccount creation date: " + getAcCreationDate() +
			"\nBranch name: " + getBranchName() +
			"\nAddress: " + getAddress()
		);
	}
}

class CurrentAccount extends BankAccount implements accountRules {

	private static double minAcBalAmount = 25_000;

	public CurrentAccount(String acHolderName, int acNumber, String acCreationDate, String branchName, double bal,
			String[] address) {
		super(acHolderName, acNumber, acCreationDate, branchName, bal, address);
	}

	@Override
	public void withdrawFunc(double amount) {
		if(getBalance() > minAcBalAmount) {
			setBalance(getBalance() - amount);
		}
	}

	@Override
	public boolean minAcBalanceMaintained() {
		if(getBalance() < minAcBalAmount) {
			return false;
		}
		else return true;
	}

	@Override
	void updateNomineeDetails(String branchName, String[] address) {
		this.branchName = branchName;
		this.address = address;
	}

	@Override
	public void getAccDetails() {
		System.out.println(
			"\nAccount holder name: " + getAcHolderName() +
			"\nAccount number: " + getAcNumber() +
			"\nAccount creation date: " + getAcCreationDate() +
			"\nBranch name: " + getBranchName() +
			"\nAddress: " + getAddress()
		);
	}
}

class SalariedAccount extends SavingsAccount implements accountRules {

	private static double minAcBalAmount = 0;

	public SalariedAccount(String acHolderName, int acNumber, String acCreationDate, String branchName, double balance,
			String[] address) {
		super(acHolderName, acNumber, acCreationDate, branchName, balance, address);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void withdrawFunc(double amount) {
		if(getBalance() > minAcBalAmount) {
			setBalance(getBalance() - amount);
		}
	}

	@Override
	public boolean minAcBalanceMaintained() {
		if(getBalance() < minAcBalAmount) {
			return false;
		}
		else return true;
	}

	@Override
	void updateNomineeDetails(String branchName, String[] address) {
		this.branchName = branchName;
		this.address = address;
	}

	@Override
	public void getAccDetails() {
		System.out.println(
			"\nAccount holder name: " + getAcHolderName() +
			"\nAccount number: " + getAcNumber() +
			"\nAccount creation date: " + getAcCreationDate() +
			"\nBranch name: " + getBranchName() +
			"\nAddress: " + getAddress()
		);
	}
}

public class BankAccountClient_W3A1_2 {
	public static void main(String args[]) {
		String[] address1 = {"Flat No 56", "Street 71", "City31", "State18", "577902"};
		//adding a new savings account
		SavingsAccount acc1 = new SavingsAccount("anon1", 12, "today", "bdvt", 13000, address1);
		acc1.withdrawFunc(2000); //withdrawing money as per the withdrawal and minimum balance rules
		//System.out.println(acc1.getBalance());
		//System.out.println(acc1.minAcBalanceMaintained());
		acc1.getAccDetails();
		SavingsAccount acc2 = new SavingsAccount("anon2", 12, "today", "bdvt", 13000, address1);
		//acc2.getAccDetails();
		String[] address2 = {"Flat No 3", "Street 7", "City1", "State10", "577291"};
		acc1.updateNomineeDetails("smg", address2);
		acc1.getAccDetails();

		String[] address3 = {"dummydata"};
		CurrentAccount currentAccount1 = new CurrentAccount("anon3", 56171, "18jun19", "bnglr", 70000, address3);
		currentAccount1.getAccDetails();
	}
}