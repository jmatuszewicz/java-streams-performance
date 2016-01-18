package org.jacek.streamsperf.maxval;

import org.jacek.streamsperf.maxval.impl.*;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


@State(Scope.Thread)
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Threads(1)
public class MaxValBenchmark {
    private static final int LENGTH = 1000000;
    private int[] array;

    private List<Integer> list;

    @Setup(Level.Iteration)
    public void setUp() {
        array = new int[LENGTH];
        list = new ArrayList<>(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            int nextInt = ThreadLocalRandom.current().nextInt();
            array[i] = nextInt;
            list.add(nextInt);
        }
    }

    @Benchmark
    public int sequentialIterationOverArrayInline() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    @Benchmark
    public int sequentialIterationOverArray() {
        return new MaxValBySequentialIterationOverArray().maxVal(array);
    }

    @Benchmark
    public int parallelIterationOverArray() {
        return new MaxValByParallelIterationOverArray().maxVal(array);
    }

    @Benchmark
    public int sequentialIterationOverList() {
        return new MaxValBySequentialIterationOverList().maxVal(list);
    }

    @Benchmark
    public int listToStreamAndReduce() {
        return new MaxValByListToStreamAndReduce().maxVal(list);
    }

    @Benchmark
    public int listToParallelStreamAndReduce() {
        return new MaxValByListToParallelStreamAndReduce().maxVal(list);
    }

    @Benchmark
    public int arrayToStreamAndReduce() {
        return new MaxValByArrayToStreamAndReduce().maxVal(array);
    }

    @Benchmark
    public int arrayToParallelStreamAndReduce() {
        return new MaxValByArrayToParallelStreamAndReduce().maxVal(array);
    }

    @Benchmark
    public int listToStreamAndCollect() {
        return new MaxValByListToStreamAndCollect().maxVal(list);
    }

    @Benchmark
    public int listToParallelStreamAndCollect() {
        return new MaxValByListToParallelStreamAndCollect().maxVal(list);
    }

    @Benchmark
    public int listToStreamAndCollectWithCustomCollector() {
        return new MaxValByListToStreamAndCollectWithCustomCollector().maxVal(list);
    }

    @Benchmark
    public int listToParallelStreamAndCollectWithCustomCollector() {
        return new MaxValByListToParallelStreamAndCollectWithCustomCollector().maxVal(list);
    }

    @Benchmark
    public int arrayToStreamAndCollectWithCustomCollector() {
        return new MaxValByArrayToStreamAndCollectWithCustomCollector().maxVal(array);
    }

    @Benchmark
    public int arrayToParallelStreamAndCollectWithCustomCollector() {
        return new MaxValByArrayToParallelStreamAndCollectWithCustomCollector().maxVal(array);
    }
}
