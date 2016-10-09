package com.ocado.test;

import org.junit.Test;

import static java.lang.Integer.MAX_VALUE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MinimalDistanceTest {

    @Test
    public void itShouldReturnExpectedMinimalDistance() {

        final int[] array = new int[]{8, 24, 3, 20, 1, 17};

        final int minimalDistance = getMinimalDistance(array);

        assertThat(minimalDistance, is(2));
    }

    @Test
    public void itShouldReturnExpectedMinimalDistanceWhenSame() {

        final int[] array = new int[]{7, 21, 3, 42, 3, 7};

        final int minimalDistance = getMinimalDistance(array);

        assertThat(minimalDistance, is(0));
    }

    private static int getMinimalDistance(final int[] array) {

        int minimalDistance = MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length && j != i; j++) {

                final int positiveDistance = array[i] - array[j];
                if (positiveDistance >= 0) {
                    if (positiveDistance < minimalDistance)
                        minimalDistance = positiveDistance;
                } else {
                    final int negativeDistance = array[j] - array[i];
                    if (negativeDistance < minimalDistance)
                        minimalDistance = negativeDistance;
                }
            }
        }
        return minimalDistance;
    }
}
