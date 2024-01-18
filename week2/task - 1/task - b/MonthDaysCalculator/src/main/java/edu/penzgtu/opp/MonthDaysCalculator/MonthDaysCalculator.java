package edu.penzgtu.opp.MonthDaysCalculator;

import java.time.YearMonth;

public class MonthDaysCalculator {
    public static void main(String[] args) {
        int month = 2; // Пример: Февраль
        int year = 2022; // Пример: Невисокосный год

        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();

        System.out.println("Количество дней в " + month + " месяце " + year + " года: " + daysInMonth);
    }
}