package org.jacek.streamsperf.maxval.impl;

import org.jacek.streamsperf.maxval.MaxValFromArrayCalculator;

public class MaxValBySequentialIterationOverArray implements MaxValFromArrayCalculator {

    @Override
    public int maxVal(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
