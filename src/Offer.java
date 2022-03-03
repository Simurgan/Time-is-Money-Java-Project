
public class Offer implements Comparable<Offer>{
	int startTime;
	int endTime;
	int profit;
	
	Offer(int startTime, int processDuration, int profit){
		this.startTime = startTime;
		this.endTime = startTime + processDuration;
		this.profit = profit;
	}

	@Override
	public int compareTo(Offer o) {
		// TODO Auto-generated method stub

		return this.endTime - o.endTime;
		
	}
}
