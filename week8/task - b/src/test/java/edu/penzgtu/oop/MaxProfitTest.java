package edu.penzgtu.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitTest {
    @Test
    @DisplayName("Should return the maximum profit correctly")
    void testMaxProfit() {
        MaxProfit profit = new MaxProfit();
        List<Integer> current = Arrays.asList(7, 1, 5, 3, 6, 4);
        int expected = 5;

        assertEquals(expected, profit.getMaxProfit(current));
    }

    @Test
    @DisplayName("Should return 0 if the maximum profit is not found")
    void testNoMaxProfit() {
        MaxProfit profit = new MaxProfit();
        List<Integer> current = Arrays.asList(7, 6, 4, 3, 1);
        int expected = 0;

        assertEquals(expected, profit.getMaxProfit(current));
    }

    @Test
    @DisplayName("Should return 0 if the array is empty")
    void testEmptyMaxProfit() {
        MaxProfit profit = new MaxProfit();
        List<Integer> current = new ArrayList<>();
        int expected = 0;

        assertEquals(expected, profit.getMaxProfit(current));
    }
}