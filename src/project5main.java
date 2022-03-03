import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class project5main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner typeScanner = new Scanner(new File(args[0]));
		Scanner aDurationScanner = new Scanner(new File(args[0]));
		aDurationScanner.nextLine();
		Scanner bDurationScanner = new Scanner(new File(args[0]));
		bDurationScanner.nextLine();
		bDurationScanner.nextLine();
		Scanner profitScanner = new Scanner(new File(args[0]));
		profitScanner.nextLine();
		profitScanner.nextLine();
		profitScanner.nextLine();
		Scanner receivingTimeScanner = new Scanner(new File(args[0]));
		receivingTimeScanner.nextLine();
		receivingTimeScanner.nextLine();
		receivingTimeScanner.nextLine();
		receivingTimeScanner.nextLine();
		
		PriorityQueue<Offer> offersPQ = new PriorityQueue<Offer>();
		while(receivingTimeScanner.hasNextInt()) {
			String type = typeScanner.next();
			int aDuration = aDurationScanner.nextInt();
			int bDuration = bDurationScanner.nextInt();
			int profit = profitScanner.nextInt();
			int receivingTime = receivingTimeScanner.nextInt();
			
			offersPQ.add(new Offer(receivingTime, type.equals("s") ? aDuration : bDuration, profit));
		}
		
		Offer[] offers = new Offer[offersPQ.size()];
		for(int i = 0; i < offers.length; i++)
			offers[i] = offersPQ.remove();
		
		// Algorithm
		int[] maxProfit = new int[offers.length];
		maxProfit[0] = offers[0].profit;
		for(int i = 1; i < offers.length; i++) {
			
			int j = i - 1;
			
			while(j >= 0 && offers[j].endTime > offers[i].startTime) {
				j--;
			}
			
			maxProfit[i] = Math.max(maxProfit[i - 1], (j >= 0) ? maxProfit[j] + offers[i].profit : offers[i].profit);
		}
		
		PrintStream output = new PrintStream(new File(args[1]));
		output.println(maxProfit[maxProfit.length - 1]);
		
	}

}
