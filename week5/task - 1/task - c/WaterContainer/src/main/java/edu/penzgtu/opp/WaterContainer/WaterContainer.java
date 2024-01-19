package edu.penzgtu.opp.WaterContainer;

public class WaterContainer {

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Максимальный объем воды (Пример 1): " + maxArea(heights));

        int[] heights2 = {1, 1};
        System.out.println("Максимальный объем воды (Пример 2): " + maxArea(heights2));

        int[] heights3 = {4, 3, 2, 1, 4};
        System.out.println("Максимальный объем воды (Пример 3): " + maxArea(heights3));

        int[] heights4 = {1, 2, 1};
        System.out.println("Максимальный объем воды (Пример 4): " + maxArea(heights4));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int currentArea = Math.min(height[left], height[right]) * width;
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}