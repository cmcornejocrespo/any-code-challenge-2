package com.ocado.test;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PrimesTest {

    @Test
    public void itShouldReturnExpectedPrime() {

        assertThat(isPrime(3), is(true));
        assertThat(isPrime(5), is(true));
        assertThat(isPrime(7), is(true));
        assertThat(isPrime(11), is(true));
        assertThat(isPrime(13), is(true));
        assertThat(isPrime(17), is(true));
    }

    @Test
    public void itShouldReturnExpectedNumberOfPrimesWithinRange() {

        int totalPrime = getTotalPrime(11, 19);

        assertThat(totalPrime, is(4));
    }

    private int getTotalPrime(final int a, final int b) {

        int totalPrimes = 0;

        for (int i = a; i <= b; i++) {

            if (isPrime(i))
                totalPrimes++;
        }
        return totalPrimes;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0)
            return (n == 2);
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
}
