package org.jacek.streamsperf.maxval.helpers;

public class MaxValBoxedCollector {

    private Integer max = Integer.MIN_VALUE;

    public void accept(Integer value) {
        if (value > max) {
            max = value;
        }
    }

    public void combine(MaxValBoxedCollector collector) {
        if (collector.max > max) {
            max = collector.max;
        }
    }

    public Integer getMax() {
        return max;
    }
}
