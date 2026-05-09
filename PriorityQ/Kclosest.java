import java.util.PriorityQueue;

public class Kclosest {

	public static class Point implements Comparable<Point> {
		int idx;
		int val;

		Point(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}

		@Override
		public int compareTo(Point p) {
			return this.val - p.val;
		}
	}

	public void addPointsSquaresInPQ(PriorityQueue<Point> pq, int[][] points) {
		int n = points.length;

		for (int i = 0; i < n; i++) {
			int sqSum = points[i][0] * points[i][0] + points[i][1] * points[i][1];
			Point p = new Point(i, sqSum);
			pq.add(p);
		}
	}

	public int[][] getKClosest(PriorityQueue<Point> pq, int[][] points, int k) {
		int n = points.length;
		int[][] res = new int[k][2];

		for (int i = 0; i < k; i++) {
			res[i] = points[pq.remove().idx];
		}

		return res;
	}

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Point> pq = new PriorityQueue<>();

		addPointsSquaresInPQ(pq, points);

		int[][] res = getKClosest(pq, points, k);

		return res;
	}

	public static void main(String[] args) {
		Kclosest obj = new Kclosest();
		int[][] points = {{1, 3}, {-2, 2}, {5, 8}};
		int k = 2;

		int[][] res = obj.kClosest(points, k);

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i][0] + " " + res[i][1]);
		}
	}
}
