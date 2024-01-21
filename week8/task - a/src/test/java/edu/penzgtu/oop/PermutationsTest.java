package edu.penzgtu.oop;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {
    @Test
    @DisplayName("Should permutation an array of one elements correctly")
    void testOneNumPermutations() {
        Permutations permutations = new Permutations();
        List<Integer> current = List.of(1);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1));

        assertEquals(expected, permutations.perms(current));
    }

    @Test
    @DisplayName("Should permutation an array of two elements correctly")
    void testTwoNumPermutations() {
        Permutations permutations = new Permutations();
        List<Integer> current = List.of(1, 2);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(2, 1));
        expected.add(List.of(1, 2));

        assertEquals(expected, permutations.perms(current));
    }

    @Test
    @DisplayName("Should permutation an array of three elements correctly")
    void testThreeNumPermutations() {
        Permutations permutations = new Permutations();
        List<Integer> current = List.of(1, 2, 3);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(3, 2, 1));
        expected.add(List.of(2, 3, 1));
        expected.add(List.of(2, 1, 3));
        expected.add(List.of(3, 1, 2));
        expected.add(List.of(1, 3, 2));
        expected.add(List.of(1, 2, 3));

        assertEquals(expected, permutations.perms(current));
    }

    @Test
    @DisplayName("Should return null if the array is empty")
    void testEmptyPermutations() {
        Permutations permutations = new Permutations();
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> expected = null;

        assertEquals(expected, permutations.perms(current));
    }
}