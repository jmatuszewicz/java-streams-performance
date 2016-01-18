package org.jacek.streamsperf.maxval.impl;

public final class TestUtil {

    private TestUtil() {
    }

    public static Object[][] cartesianProduct(Object[] left, Object[][] right) {
        Object[][] result = new Object[left.length * right.length][3];

        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < right.length; j++) {
                int testDataInd = i * right.length + j;
                result[testDataInd][0] = left[i];
                result[testDataInd][1] = right[j][0];
                result[testDataInd][2] = right[j][1];
            }
        }
        return result;
    }
}
