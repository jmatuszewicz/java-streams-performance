package org.jacek.streamsperf.maxval.impl;

import org.jacek.streamsperf.maxval.MaxValFromListCalculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.jacek.streamsperf.maxval.impl.TestUtil.cartesianProduct;

public class MaxValFromListTest extends CommonMaxValTest {

    @Test(dataProvider = "calculators")
    public void testMaxValFromList(MaxValFromListCalculator calculator,
                                   int [] input,
                                   Integer expectedResult) throws Exception {
        Assert.assertEquals(
                expectedResult.intValue(),
                calculator.maxVal(
                        IntStream.of(input).boxed().collect(Collectors.toList())
        ));
    }

    @DataProvider(name = "calculators")
    public Object[][] provideData() {
        return cartesianProduct(getImplementations(), getTestCases());
    }

    private MaxValFromListCalculator[] getImplementations() {
        return new MaxValFromListCalculator[] {
                new MaxValByListToParallelStreamAndCollect() ,
                new MaxValByListToParallelStreamAndCollectWithCustomCollector() ,
                new MaxValByListToParallelStreamAndReduce() ,
                new MaxValByListToStreamAndCollect() ,
                new MaxValByListToStreamAndCollectWithCustomCollector() ,
                new MaxValByListToStreamAndReduce() ,
                new MaxValBySequentialIterationOverList()
        };
    }


}
