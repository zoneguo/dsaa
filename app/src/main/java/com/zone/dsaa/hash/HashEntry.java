package com.zone.dsaa.hash;

public class HashEntry<Type> {
    public Type element; // the element
    public boolean isActive; // false is deleted

    public HashEntry(Type e) {
        this(e, true);
    }

    public HashEntry(Type e, boolean i) {
        element = e;
        isActive = i;
    }
}
