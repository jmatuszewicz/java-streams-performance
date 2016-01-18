package org.jacek.streamsperf.maxval.impl;

import org.jacek.streamsperf.maxval.MaxValFromArrayCalculator;
import org.jacek.streamsperf.maxval.helpers.MaxValImperativeParallelCalculator;

public class MaxValByParallelIterationOverArray implements MaxValFromArrayCalculator {

    @Override
    public int maxVal(int[] array) {
        return new MaxValImperativeParallelCalculator(array, 0, array.length).compute().getMax();
    }
}
