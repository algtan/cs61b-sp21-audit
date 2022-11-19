package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        int initialN = 1000;
        int finalN = 128000;
        int growthFactor = 2;

        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();

        int n = initialN;
        while (n <= finalN) {
            AList<Integer> testAList = new AList<Integer>();
            int opCount = 0;

            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < n; i++) {
                testAList.addLast(i);
                opCount += 1;
            }
            double elapsedTime = sw.elapsedTime();

            Ns.addLast(n);
            times.addLast(elapsedTime);
            opCounts.addLast(opCount);

            n *= growthFactor;
        }

        printTimingTable(Ns, times, opCounts);
    }
}
