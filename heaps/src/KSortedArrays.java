import java.util.ArrayList;
import java.util.PriorityQueue;

public class KSortedArrays {
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));

		for (int i = 0; i < k; i++) {
			pq.offer(new Pair(kArrays.get(i).get(0),i, 0));
		}

		while (!pq.isEmpty()){
			Pair current = pq.poll();
			ans.add(current.value);
			current.valueIndex++;

			if (current.valueIndex < kArrays.get(current.arrayNumber).size()){
				pq.offer(new Pair(kArrays.get(current.arrayNumber).get(current.valueIndex), current.arrayNumber, current.valueIndex));
			}
		}
		return ans;
	}
	static class Pair {
		int value;
		int arrayNumber;
		int valueIndex;

		public Pair(int value, int arrayNumber, int valueIndex) {
			this.value = value;
			this.arrayNumber = arrayNumber;
			this.valueIndex = valueIndex;
		}
	}
}
