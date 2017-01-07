import java.util.ArrayList;
import java.util.Collections;

public class Searcher {
	public Result search(IsearchingAlgorithm searchAlgorithm, ArrayList<String> arr, ArrayList<String> keys,
			int numSearch, int numSkipped) {
		int max = -1;
		int min = Integer.MAX_VALUE;
		int sum = 0;

		for (int i = numSkipped; i < (numSearch + numSkipped); i++) {

			int position = searchAlgorithm.search(arr, keys.get(i));

			int numC = searchAlgorithm.getNumComparations();
			sum = sum + numC;
			if (min > numC) {
				min = numC;
			}
			if (max < numC) {
				max = numC;
			}
		}

		int average = sum / numSearch;

		return new Result(average, max, min);
	}
}
