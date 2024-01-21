package edu.penzgtu.oop;

import java.util.List;

public class Container {
    public long findMaxArea(List<Integer> coordinates) {
        int left = 0;
        int right = coordinates.size() - 1;
        int max = 0;

        while (left < right) {
            int width = right - left;
            int height = Math.min(coordinates.get(left), coordinates.get(right));
            int area = height * width;
            max = Math.max(max, area);

            if (coordinates.get(left) < coordinates.get(right)) {
                left++;
            } else if (coordinates.get(left) > coordinates.get(right)) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        return max;
    }
}
