package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V>  implements Map61B<K, V> {
    private int size = 0;

    private BSTNode tree;

    private class BSTNode {

        /** Stores KEY as the key in this key-value pair, VAL as the value,
         *  LEFT as the left node, and RIGHT as the right node in the tree. */
        BSTNode(K k, V v, BSTNode l, BSTNode r) {
            key = k;
            val = v;
            left = l;
            right = r;
        }

        /** Returns the BSTNode in this tree of key-value pairs whose key
         *  is equal to KEY, or null if no such BSTNode exists. */
        BSTNode get(K k) {
            if (k != null && k.equals(key)) {
                return this;
            }
            if (left != null && k.compareTo(key) < 0) {
                return left.get(k);
            }
            if (right != null && k.compareTo(key) > 0) {
                return right.get(k);
            }
            return null;
        }

        /** Stores the key of the key-value pair of this node in the tree. */
        K key;
        /** Stores the value of the key-value pair of this node in the tree. */
        V val;
        /** Stores the left BSTNode in the tree. */
        BSTNode left;
        /** Stores the right BSTNode in the tree. */
        BSTNode right;

    }

    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {
        throw new UnsupportedOperationException();
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        throw new UnsupportedOperationException();
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    /* Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
