import java.util.ArrayList;

public interface IsearchingAlgorithm {
	// public Result Search(ArrayList<String> arr, ArrayList<String> keys ,int
	// numSearch, int numSkipped);
	// public Result getResults();

	public int search(ArrayList<String> arr, String key);
	public int getNumComparations();

}