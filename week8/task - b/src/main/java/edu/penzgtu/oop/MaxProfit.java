package edu.penzgtu.oop;

import java.util.List;

public class MaxProfit {
    public int getMaxProfit(List<Integer> prices) {
        int result = 0;
        int buy = Integer.MAX_VALUE;

        for (int price : prices) {
            buy = Math.min(buy, price);
            result = Math.max(result, price - buy);
        }

        return result;
    }
}
