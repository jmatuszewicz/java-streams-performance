package org.jacek.streamsperf.maxval.impl;

import org.jacek.streamsperf.maxval.MaxValFromListCalculator;
import org.jacek.streamsperf.maxval.helpers.MaxValBoxedCollector;

import java.util.List;

public class MaxValByListToParallelStreamAndCollectWithCustomCollector implements MaxValFromListCalculator {
    @Override
    public int maxVal(List<Integer> list) {
        return list.stream().parallel().collect(
                MaxValBoxedCollector::new,
                MaxValBoxedCollector::accept,
                MaxValBoxedCollector::combine).getMax();

    }
}
