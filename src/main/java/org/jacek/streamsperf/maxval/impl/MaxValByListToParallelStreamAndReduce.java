package org.jacek.streamsperf.maxval.impl;

import org.jacek.streamsperf.maxval.MaxValFromListCalculator;

import java.util.List;

public class MaxValByListToParallelStreamAndReduce implements MaxValFromListCalculator {

    @Override
    public int maxVal(List<Integer> list) {
        return list.stream().parallel().reduce(Math::max).get();
    }
}
