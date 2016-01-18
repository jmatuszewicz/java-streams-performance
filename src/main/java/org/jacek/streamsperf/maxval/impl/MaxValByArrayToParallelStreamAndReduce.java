package org.jacek.streamsperf.maxval.impl;

import org.jacek.streamsperf.maxval.MaxValFromArrayCalculator;

import java.util.Arrays;

public class MaxValByArrayToParallelStreamAndReduce implements MaxValFromArrayCalculator {
    @Override
    public int maxVal(int[] array) {
        return Arrays.stream(array).parallel().reduce(Math::max).getAsInt();
    }
}
