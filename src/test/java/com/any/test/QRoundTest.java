package com.any.test;

import org.junit.Test;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QRoundTest {

    @Test
    public void itShouldReturnExpectedQValues() {

        final int outcome = getQ(2);

        assertThat(outcome, is(4));
    }

    private int getQ(final int Q) {

        int totalQRoundPairs = 0;

        for (int i = -Q; i <= Q; i++) {
            for (int j = -Q; j <= Q; j++) {
                if ((i * i) + (j * j) == Q) {
                    System.out.println(format("Pair (%s,%s) found", i, j));
                    totalQRoundPairs++;
                }
            }
        }

        return totalQRoundPairs;
    }
}
