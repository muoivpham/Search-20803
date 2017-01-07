import java.util.ArrayList;

public class InterpolationSearch implements IsearchingAlgorithm {
	private int numComparation = 0;

	private int InterpolationSearch(ArrayList<Integer> t, int n, int k) {
		
		t = addElement(t);
		// assume numeric keys is range: 1 <= k <= N-1
		int left = 1;
		double p;
		int middle;

		int right = (n - 1) + 1;
		// repeat forever
		while (true) {
			if (right < left) {
				// then
				return -2;
			} else {
				p = (k - t.get(left - 1)) / (double) (t.get(right + 1) - t.get(left - 1));
//				System.out.println("P = " + p);
				middle = (int) (Math.floor(p * (right - left + 1)) + left);
				// System.out.println("middle = " + middle);
				numComparation++;
				if (k == (t.get(middle))) {
					// then return middle;
					break;
				} else if (k < t.get(middle)) {
					// then
					right = middle - 1;
				} else {
					left = middle + 1;
				}
			}
		}
		return middle;
	} // end
		// InterpolationSearch

	public int hornersRule(String str) {
		char[] chars = new char[4];
		for (int i = 0; i < 4; i++) {
			chars[i] = str.charAt(i);
		}
		return hornersRule(chars[0], chars[1], chars[2], chars[3]);
	}

	public ArrayList<Integer> convertArray(ArrayList<String> arr) {
		ArrayList<Integer> newArr = new ArrayList<Integer>();
		int n;

		for (String key : arr) {
			n = hornersRule(key);
			newArr.add(n);
		}

		return newArr;
	}

	public int hornersRule(char c1, char c2, char c3, char c4) {
		return (int) ((((((int) c1 << 8) + (int) c2) << 8) + (int) c3) << 8) + (int) c4;
	}

	public ArrayList<Integer> addElement(ArrayList<Integer> t) {
		ArrayList<Integer> newT = new ArrayList<Integer>();
		newT.add(-1);
		for (Integer integer : t) {
			newT.add(integer);
		}
		newT.add(Integer.MAX_VALUE - 10);

		return newT;
	}

	@Override
	public int search(ArrayList<String> arr, String key) {
		// TODO Auto-generated method stub
		numComparation = 0;
		return InterpolationSearch(convertArray(arr), arr.size(), hornersRule(key));
	}

	@Override
	public int getNumComparations() {
		// TODO Auto-generated method stub
		return numComparation;
	}

}
