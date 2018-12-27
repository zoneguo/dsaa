package com.zone.dsaa.other;

/**
 * 求最大子序列和
 */
public final class MaxSumProcessor {
    public static int maxSubSum1(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        int maxSum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int theSum = 0;
                for(int m = i; m <= j; m++) {
                    theSum += arr[m];
                }

                if (theSum > maxSum) {
                    maxSum = theSum;
                }
            }
        }

        return maxSum;
    }

    public static int maxSubSum2(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        int maxSum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int theSum = 0;
            for (int j = i; j < arr.length; j++) {
                theSum += arr[j];

                if (theSum > maxSum) {
                    maxSum = theSum;
                }
            }
        }

        return maxSum;
    }

    public static int maxSubSum3(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        return maxSubSumPar(arr, 0, arr.length - 1);
    }

    private static int maxSubSumPar(int[] arr, int left, int right) {
        if (left >= right) {
            return arr[left];
        }

        int center = (left + right) /2;
        int leftMaxSubSum = maxSubSumPar(arr, left, center);
        int rightMaxSubSum = maxSubSumPar(arr, center + 1, right);


        int leftMaxSubSumMiddle = arr[center];
        int leftSubSumMiddle = 0;
        for (int i = center; i >= 0; i--) {
            leftSubSumMiddle += arr[i];
            if (leftSubSumMiddle > leftMaxSubSumMiddle) {
                leftMaxSubSumMiddle = leftSubSumMiddle;
            }
        }


        int rightMaxSubSumMiddle = arr[center + 1];
        int rightSubSumMiddle = 0;
        for (int i = center + 1; i <= right; i++) {
            rightSubSumMiddle += arr[i];
            if (rightSubSumMiddle > rightMaxSubSumMiddle) {
                rightMaxSubSumMiddle = rightSubSumMiddle;
            }
        }

        return max3(leftMaxSubSum, rightMaxSubSum, leftMaxSubSumMiddle + rightMaxSubSumMiddle);
    }

    private static int max3(int a, int b, int c) {
        int maxTmp = (a > b) ? a : b;

        return (maxTmp > c) ? maxTmp : c;
    }

    public static int maxSubSum4(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }

        int max = arr[0];

        int curSum = 0;
        for (int i = 0; i < arr.length; i++) {

            curSum += arr[i];
            if (curSum > max) {
                max = curSum;
            }

            if (arr[i] < 0) {
                curSum = 0;
            }
        }
        return max;
    }


}
