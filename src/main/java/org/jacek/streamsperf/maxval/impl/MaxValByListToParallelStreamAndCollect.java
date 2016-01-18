package org.jacek.streamsperf.maxval.impl;

import org.jacek.streamsperf.maxval.MaxValFromListCalculator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxValByListToParallelStreamAndCollect implements MaxValFromListCalculator {
    @Override
    public int maxVal(List<Integer> list) {
        return list.stream().parallel().collect(Collectors.maxBy(Comparator.naturalOrder())).get();
    }
}
