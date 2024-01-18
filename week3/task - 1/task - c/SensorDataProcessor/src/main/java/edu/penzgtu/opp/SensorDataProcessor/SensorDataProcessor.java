package edu.penzgtu.opp.SensorDataProcessor;

import java.util.Arrays;
import java.util.Scanner;

public class SensorDataProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные с датчиков:");
        String input = scanner.nextLine();
        System.out.println("Сортировать по 1) ID 2) Температуре");
        int sortBy = scanner.nextInt();

        String[] sensorReadings = input.split("@");
        String[][] sensorData = new String[sensorReadings.length][3]; // [sensorId, totalTemperature, count]

        for (int i = 0; i < sensorReadings.length; i++) {
            String sensorId = sensorReadings[i].substring(0, 2);
            int temperature = Integer.parseInt(sensorReadings[i].substring(2));
            boolean found = false;
            for (int j = 0; j < sensorData.length; j++) {
                if (sensorData[j][0] != null && sensorData[j][0].equals(sensorId)) {
                    sensorData[j][1] = String.valueOf(Integer.parseInt(sensorData[j][1]) + temperature);
                    sensorData[j][2] = String.valueOf(Integer.parseInt(sensorData[j][2]) + 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                sensorData[i][0] = sensorId;
                sensorData[i][1] = String.valueOf(temperature);
                sensorData[i][2] = "1";
            }
        }

        for (int i = 0; i < sensorData.length; i++) {
            if (sensorData[i][0] != null) {
                double avgTemp = (double) Integer.parseInt(sensorData[i][1]) /
                        Integer.parseInt(sensorData[i][2]);
                sensorData[i][1] = String.format("%.1f", avgTemp);
            }
        }

        Arrays.sort(sensorData, (a, b) -> {
            if (a[0] == null) return 1;
            if (b[0] == null) return -1;
            return sortBy == 1 ? a[0].compareTo(b[0]) : a[1].compareTo(b[1]);
        });

        System.out.println("Вывод:");
        for (String[] sensor : sensorData) {
            if (sensor[0] != null) {
                System.out.println(sensor[0] + " " + sensor[1]);
            }
        }
    }
}