package org.jacek.streamsperf.maxval.helpers;

public class MaxValUnboxedCollector {

    private int max = Integer.MIN_VALUE;

    public void accept(int value) {
        if (value > max) {
            max = value;
        }
    }

    public void combine(MaxValUnboxedCollector collector) {
        if (collector.max > max) {
            max = collector.max;
        }
    }

    public int getMax() {
        return max;
    }
}
