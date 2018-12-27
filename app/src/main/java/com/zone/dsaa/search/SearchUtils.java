package com.zone.dsaa.search;

public class SearchUtils {

    public static int binarySearch(int[] arr, int x) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int center = (left + right)/2;
            if (x < arr[center]) {
                right = center - 1;
            } else if (x > arr[center]) {
                left = center + 1;
            } else {
                return arr[center];
            }
        }

        return -1;
    }

}
