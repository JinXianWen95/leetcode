package other;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio_1792 {
    public static void main(String[] args) {
        new MaximumAveragePassRatio_1792().maxAverageRatio(new int[][] {
                {1,2},
                {3,5},
                {2,2}
        }, 2);
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap= new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int[] aClass : classes) {
            maxHeap.offer(new double[]{
                    (double) (aClass[0] + 1) / (aClass[1] + 1) - (double) aClass[0] / aClass[1],
                    aClass[0],
                    aClass[1]}
            );
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] max = maxHeap.poll();
            maxHeap.offer(new double[]{
                    (max[1] + 2) / (max[2] + 2) - (max[1]+1) / (max[2]+1),
                    max[1]+1,
                    max[2]+1});
        }

        return maxHeap.stream()
                .map(a -> a[1] /a[2])
                .reduce(Double::sum).get() / classes.length;
    }
}
