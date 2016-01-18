package org.jacek.streamsperf.maxval.impl;

public class CommonMaxValTest {

    protected Object[][] getTestCases() {
         return new Object[][] {
                 {new int [] {1}, 1},
                 {new int [] {1,1}, 1},
                 {new int [] {1,1,1,1,1,1,1,1,1}, 1},
                 {new int [] {1,2}, 2},
                 {new int [] {2,1}, 2},
                 {new int [] {2,1,1,1,1,1,1,1}, 2},
                 {new int [] {1,1,1,1,1,1,1,2}, 2},
                 {new int [] {1,1,1,1,2,1,1,1}, 2},
                 {new int [] {1,1,1,1,1,2,1,1}, 2},
                 {new int [] {2,1,1,1,1,1,1,1,1}, 2},
                 {new int [] {1,1,1,1,1,1,1,1,2}, 2},
                 {new int [] {1,1,1,1,1,2,1,1,1}, 2},
                 {new int [] {1,1,1,1,2,1,1,1,1}, 2},
         };
    }
}
