package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        int initialN = 1000;
        int finalN = 128000;
        int growthFactor = 2;
        int numOfOps = 10000;

        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();

        for (int i = initialN; i <= finalN; i *= growthFactor) {
            // 1. Create an SLList
            SLList<Integer> testSLList = new SLList<>();

            // 2. Add N items to the SLList
            for (int j = 0; j < i; j++) {
                testSLList.addLast(j);
            }

            // 3. Start the timer
            Stopwatch sw = new Stopwatch();

            // 4. Perform M getLast operations on the SLList
            for (int k = 0; k < numOfOps; k++) {
                testSLList.getLast();
            }

            // 5. Check the timer
            double elapsedTime = sw.elapsedTime();

            Ns.addLast(i);
            times.addLast(elapsedTime);
            opCounts.addLast(numOfOps);
        }

        printTimingTable(Ns, times, opCounts);
    }

}
