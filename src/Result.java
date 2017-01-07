
public class Result {
	private int numComparations;
	private int maxComparation;
	private int minComparation;
	public int getNumComparations() {
		return numComparations;
	}
	public void setNumComparations(int numComparations) {
		this.numComparations = numComparations;
	}
	public int getMaxComparation() {
		return maxComparation;
	}
	public void setMaxComparation(int maxComparation) {
		this.maxComparation = maxComparation;
	}
	public int getMinComparation() {
		return minComparation;
	}
	public void setMinComparation(int minComparation) {
		this.minComparation = minComparation;
	}
	@Override
	public String toString() {
		return "Result [average=" + numComparations + ", max=" + maxComparation + ", min="
				+ minComparation + "]";
	}
	public Result(int numComparations, int maxComparation, int minComparation) {
		this.numComparations = numComparations;
		this.maxComparation = maxComparation;
		this.minComparation = minComparation;
	}
	public Result() {
		// TODO Auto-generated constructor stub
	}
	
	

}
