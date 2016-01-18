package org.jacek.streamsperf.maxval.impl;

import org.jacek.streamsperf.maxval.MaxValFromListCalculator;

import java.util.List;

public class MaxValBySequentialIterationOverList implements MaxValFromListCalculator {
    @Override
    public int maxVal(List<Integer> list) {
        int max = Integer.MIN_VALUE;

        for (Integer value : list) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
