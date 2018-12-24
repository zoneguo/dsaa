package com.zone.dsaa.sort;

public final class Utils {
    public static String toString(Integer[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + ",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
