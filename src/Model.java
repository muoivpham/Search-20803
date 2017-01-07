import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {
	ArrayList<String> arr = new ArrayList<>();
	ArrayList<String> keys = new ArrayList<>();
	Result result;
	Searcher searcher = new Searcher();

	public ArrayList<String> loadFile(File fileName) {
		Scanner scan;
		try {
			scan = new Scanner(fileName);
			while (scan.hasNext()) {
				String key = scan.nextLine();
				arr.add(key);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arr;
	}

	public ArrayList<String> loadKeys(File fileName) {
		Scanner scan;
		try {
			scan = new Scanner(fileName);
			while (scan.hasNext()) {
				String key = scan.nextLine();
				keys.add(key);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return keys;
	}

	public void SequentialSearch(int numSearch, int numSkipped) {
		IsearchingAlgorithm searchAlgorithm = new SequentialSearch();
//		result = searcher.Search(arr, keys, numSearch, numSkipped);
		result = searcher.search(searchAlgorithm, arr, keys, numSearch, numSkipped);
		System.out.println(result.toString());
	}

	public void interpolationSearch(int numSearch, int numSkipped) {
		IsearchingAlgorithm searchAlgorithm = new InterpolationSearch();
//		result = searcher.Search(arr, keys, numSearch, numSkipped);
		result = searcher.search(searchAlgorithm, arr, keys, numSearch, numSkipped);
	}
	
	public void binarySearch(int numSearch, int numSkipped) {
		IsearchingAlgorithm searchAlgorithm = new BinarySearch();
//		result = searcher.Search(arr, keys, numSearch, numSkipped);
		result = searcher.search(searchAlgorithm, arr, keys, numSearch, numSkipped);
	}
}
