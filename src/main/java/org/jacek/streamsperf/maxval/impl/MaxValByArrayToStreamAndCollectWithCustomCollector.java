package org.jacek.streamsperf.maxval.impl;

import org.jacek.streamsperf.maxval.MaxValFromArrayCalculator;
import org.jacek.streamsperf.maxval.helpers.MaxValUnboxedCollector;

import java.util.Arrays;

public class MaxValByArrayToStreamAndCollectWithCustomCollector implements MaxValFromArrayCalculator {
    @Override
    public int maxVal(int[] array) {
        return Arrays.stream(array).collect(
                MaxValUnboxedCollector::new,
                MaxValUnboxedCollector::accept,
                MaxValUnboxedCollector::combine).getMax();

    }
}
