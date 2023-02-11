package bstmap;

import org.junit.Test;

import java.io.IOException;

public class PrintInOrderTest {
    public static void main(String[] args) throws IOException {
        BSTMap<Integer, Integer> b = new BSTMap<Integer, Integer>();
        b.put(5, 5);
        b.put(3, 3);
        b.put(7, 7);
        b.put(1, 1);
        b.put(4, 4);
        b.put(6, 6);
        b.put(9, 9);
        b.printInOrder();
    }
}
