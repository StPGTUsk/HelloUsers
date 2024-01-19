package edu.penzgtu.opp.StockProfit;

import java.util.Arrays;
import java.util.List;

public class StockProfit {

    public static void main(String[] args) {
        List<Integer> prices1 = Arrays.asList(7, 1, 5, 3, 6, 4);
        System.out.println("Максимальная прибыль: " + maxProfit(prices1));

        List<Integer> prices2 = Arrays.asList(7, 6, 4, 3, 1);
        System.out.println("Максимальная прибыль: " + maxProfit(prices2));
    }

    public static int maxProfit(List<Integer> prices) {
        if (prices == null || prices.size() < 2) {
            return 0;
        }

        int minPrice = prices.get(0);
        int maxProfit = 0;

        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) < minPrice) {
                minPrice = prices.get(i);
            } else {
                maxProfit = Math.max(maxProfit, prices.get(i) - minPrice);
            }
        }

        return maxProfit;
    }
}