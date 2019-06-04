import java.util.Scanner;

public class StockCode_W1A2_4 {
	public static void main(String args[]) {
		Scanner scans = new Scanner(System.in);
		String stockCode = scans.nextLine();
		
		switch(stockCode.toUpperCase()) {
			case "INF":
				System.out.println("Infosys");
				break;
			case "TCS":
				System.out.println("Tata Consultancy Services");
				break;
			case "RIL":
				System.out.println("Reliance Industries");
				break;
			default:
				System.out.println("Not mapped");
		}
	}
}