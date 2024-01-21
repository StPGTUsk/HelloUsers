package edu.penzgtu.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    @Test
    @DisplayName("Should return the filled area of the container correctly")
    void testFindMaxArea() {
        Container container = new Container();

        assertEquals(49, container.findMaxArea(Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7)));
        assertEquals(1, container.findMaxArea(Arrays.asList(1, 1)));
        assertEquals(16, container.findMaxArea(Arrays.asList(4, 3, 2, 1, 4)));
        assertEquals(2, container.findMaxArea(Arrays.asList(1, 2, 1)));
    }

    @Test
    @DisplayName("Should return 0 if the array is empty")
    void testEmptyMaxProfit() {
        Container container = new Container();
        List<Integer> current = new ArrayList<>();
        int expected = 0;

        assertEquals(expected, container.findMaxArea(current));
    }
}