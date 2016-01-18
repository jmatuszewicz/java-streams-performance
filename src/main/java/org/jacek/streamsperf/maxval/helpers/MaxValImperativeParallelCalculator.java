package org.jacek.streamsperf.maxval.helpers;

import java.util.concurrent.ForkJoinTask;

public class MaxValImperativeParallelCalculator extends ForkJoinTask<Integer> {

    private int max = Integer.MIN_VALUE;

    private int[] array;

    private int start;

    private int stop;

    public MaxValImperativeParallelCalculator(int[] array, int start, int stop) {
        this.array = array;
        this.start = start;
        this.stop = stop;
    }

    @Override
    public Integer getRawResult() {
        return max;
    }

    @Override
    protected void setRawResult(Integer value) {
        this.max = value;
    }

    public MaxValImperativeParallelCalculator compute() {
        int processors = Runtime.getRuntime().availableProcessors();
        int partitionSize = array.length / processors;
        MaxValImperativeParallelCalculator[] forks = new MaxValImperativeParallelCalculator[processors - 1];
        for (int i = 0; i < processors - 1; i++) {
            forks[i] = new MaxValImperativeParallelCalculator(
                    array,
                    start + (i * partitionSize),
                    start + (i + 1) * partitionSize);
            forks[i].fork();
        }
        computeSequentially(array, start + (processors - 1) * partitionSize, stop);
        for (int i = 0; i < processors - 1; i++) {
            forks[i].join();
            if (forks[i].getRawResult() > max) {
                max = forks[i].getRawResult();
            }
        }
        return this;
    }

    private void computeSequentially(int[] array, int start, int stop) {
        for (int i = start; i < stop; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
    }

    @Override
    protected boolean exec() {
        computeSequentially(array, start, stop);
        return true;
    }

    public int getMax() {
        return max;
    }
}
