import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassInfo> pq = new PriorityQueue<>((a, b) -> Double.compare(b.gain(), a.gain()));

        for (int[] c : classes) {
            pq.offer(new ClassInfo(c[0], c[1]));
        }

        while (extraStudents-- > 0) {
            ClassInfo top = pq.poll();
            top.addStudent();
            pq.offer(top);
        }

        double total = 0.0;
        for (ClassInfo ci : pq) {
            total += ci.ratio();
        }
        return total / classes.length;
    }

    static class ClassInfo {
        int pass, total;
        
        ClassInfo(int p, int t) {
            pass = p;
            total = t;
        }

        double ratio() {
            return (double) pass / total;
        }

        double gain() {
            return (double)(pass + 1) / (total + 1) - (double) pass / total;
        }

        void addStudent() {
            pass++;
            total++;
        }
    }
}
