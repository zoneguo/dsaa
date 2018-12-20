package com.zone.dsaa.hash;

public class QuadraticProbingHashTable<Type> {
    private static final int DEF_TABLE_SIZE = 11;

    private HashEntry<Type>[] arrs;
    private int size;

    public QuadraticProbingHashTable() {
        this(DEF_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size) {
        allocateArrary(size);
        makeEmpty();
    }

    public void makeEmpty() {
        size = 0;
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = null;
        }
    }

    public boolean contains(Type x) {
        int pos = findPos(x);
        return isActive(pos);
    }

    public void insert(Type x) {

    }

    public void remove(Type x) {

    }

    private void allocateArrary(int size) {
        arrs = new HashEntry[size];
    }

    private boolean isActive(int pos) {

        return arrs[pos] != null && arrs[pos].isActive;
    }

    private int findPos(Type x) {
        int offset = 1;
        int pos = myHash(x);

        // 解决冲突
        while( arrs[pos] != null && !arrs[pos].element.equals(x)) {
            pos += offset;
            if (pos >= arrs.length) {
                pos -= arrs.length;
            }
            offset += 2;
        }

        return pos;
    }

    private void reHash() {

    }

    private int myHash(Type x) {
        int hashVal = x.hashCode();

        hashVal = hashVal%arrs.length;
        if (hashVal < 0) {
            hashVal += arrs.length;
        }
        return hashVal;
    }

    private static int nextPrime(int n) {
        return -1;
    }

    private static boolean isPrime(int n) {
        return false;
    }


}
