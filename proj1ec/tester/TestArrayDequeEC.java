package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void randomizedTest() {
        ArrayDequeSolution<Integer> correct = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> buggy = new StudentArrayDeque<>();

        String outputMsg = "";

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                correct.addFirst(randVal);
                buggy.addFirst(randVal);

                outputMsg += "addFirst(" + String.valueOf(randVal) + ")\n";
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                buggy.addLast(randVal);

                outputMsg += "addLast(" + String.valueOf(randVal) + ")\n";
            } else if (operationNumber == 2) {
                // removeFirst
                if (correct.size() == 0) continue;

                Integer correctPrevFirst = correct.removeFirst();
                Integer buggyPrevFirst = buggy.removeFirst();

                outputMsg += "removeFirst()\n";
                assertEquals(outputMsg, correctPrevFirst, buggyPrevFirst);
            } else if (operationNumber == 3) {
                // removeLast
                if (correct.size() == 0) continue;

                Integer correctPrevLast = correct.removeLast();
                Integer buggyPrevLast = buggy.removeLast();

                outputMsg += "removeLast()\n";
                assertEquals(outputMsg, correctPrevLast, buggyPrevLast);
            }
        }
    }
}
