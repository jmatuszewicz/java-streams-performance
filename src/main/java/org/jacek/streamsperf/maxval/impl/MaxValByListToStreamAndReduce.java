package org.jacek.streamsperf.maxval.impl;

import org.jacek.streamsperf.maxval.MaxValFromListCalculator;

import java.util.List;

public class MaxValByListToStreamAndReduce implements MaxValFromListCalculator {
    @Override
    public int maxVal(List<Integer> list) {
        return list.stream().reduce(Math::max).get();
    }
}
