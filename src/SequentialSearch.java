import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.print.attribute.standard.NumberUpSupported;
import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

public class SequentialSearch implements IsearchingAlgorithm {
	int numC = 0;

//	@Override
//	public void Search(ArrayList<String> arr, ArrayList<String> keys, int numSearch, int numSkipped) {
//		// TODO Auto-generated method stub
//
//		for (int i = numSkipped; i < (numSearch + numSkipped); i++) {
//			String key = keys.get(i);
//			int keyPosition = sequentialSearch(arr, key, arr.size());
//		}
//		numC = numC / numSearch;
//		numK = numK / numSearch;
//	}

	public int search(ArrayList<String> table, String k, int n) {
		// Algorithm sequentialSearch(Object[] table, Object k, int n);
		// { Search the n element array, table, for the location of the key k.}

		table.add("}}}}}}}}}}}}}}}"); // some value known to be larger than the largest key
		int i = 0;
		while (k.compareTo(table.get(i)) >= 0) {
			i++;
			numC++;
			// end while
		}
		numC++;
		if (k.compareTo(table.get(i)) == 0) {
			// then
			return i;
		} else {
			return -1;
		}
		// end sequentialSearch
	}

	@Override
	public int search(ArrayList<String> arr, String key) {
		// TODO Auto-generated method stub
		numC = 0;
		return search(arr, key, arr.size());
	}

	@Override
	public int getNumComparations() {
		// TODO Auto-generated method stub
		return numC;
	}

//	@Override
//	public Result getResults() {
//		// TODO Auto-generated method stub
//
//		return new Result(numC, numK);
//	}

}