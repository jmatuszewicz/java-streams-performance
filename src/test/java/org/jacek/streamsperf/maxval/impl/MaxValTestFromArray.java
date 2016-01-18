package org.jacek.streamsperf.maxval.impl;

import org.jacek.streamsperf.maxval.MaxValFromArrayCalculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.jacek.streamsperf.maxval.impl.TestUtil.cartesianProduct;

public class MaxValTestFromArray extends CommonMaxValTest {

    @Test(dataProvider = "calculators")
    public void testMaxValFromArray(MaxValFromArrayCalculator calculator,
                                    int [] input,
                                    Integer expectedResult) throws Exception {
        Assert.assertEquals(expectedResult.intValue(), calculator.maxVal(input));
    }

    @DataProvider(name = "calculators")
    public Object[][] provideData() {
        return cartesianProduct(getImplementations(), getTestCases());
    }

    private MaxValFromArrayCalculator[] getImplementations() {
        return new MaxValFromArrayCalculator[] {
                        new MaxValByArrayToParallelStreamAndCollectWithCustomCollector() ,
                        new MaxValByArrayToParallelStreamAndReduce() ,
                        new MaxValByArrayToStreamAndCollectWithCustomCollector() ,
                        new MaxValByArrayToStreamAndReduce() ,
                        new MaxValByParallelIterationOverArray() ,
                        new MaxValBySequentialIterationOverArray()
        };
    }
}