package edu.penzgtu.oop;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты линий через запятую: ");
        String userInput = scanner.nextLine();

        Container container = new Container();
        List<Integer> data = stringToNumArray(userInput.split(","));

        System.out.printf("Результат %n%d", container.findMaxArea(data));
    }

    private static List<Integer> stringToNumArray(String[] strArrayList) {
        List<Integer> result = new ArrayList<>(strArrayList.length);

        for (String element : strArrayList) {
            result.add(Integer.parseInt(element));
        }

        return result;
    }
}
