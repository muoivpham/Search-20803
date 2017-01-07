import java.util.ArrayList;

public class BinarySearch implements IsearchingAlgorithm {
	private int numComparations = 0;

	public int BinarySearch(ArrayList<String> A, String value) {
		int low = 0;
		// high = N - 1
		int high = A.size();
		while (low <= high) {
			int mid = (low + high) / 2;
			
			numComparations++;
			if (A.get(mid).compareTo(value) > 0) {
				high = mid - 1;
//				numComparations++;
			} else if (A.get(mid).compareTo(value) < 0) {
				low = mid + 1;
//				numComparations = numComparations + 2;
			} else {
//				numComparations = numComparations + 2;
				return mid;
			}
		}
		// return not_found // value would be inserted at index "low"
		return -1;
	}

	@Override
	public int search(ArrayList<String> arr, String key) {
		// TODO Auto-generated method stub
		numComparations = 0;
		return BinarySearch(arr, key);
	}

	@Override
	public int getNumComparations() {
		// TODO Auto-generated method stub
		return numComparations;
	}

	

}
