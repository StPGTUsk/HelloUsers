package edu.penzgtu.opp.SensorDataFormatException;

import java.util.Arrays;
import java.util.Scanner;

class SensorDataFormatException extends Exception {
    public SensorDataFormatException(String message) {
        super(message);
    }
}

public class SensorDataProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные с датчиков:");
        String input = scanner.nextLine();

        try {
            if (input.length() > 512) {
                throw new SensorDataFormatException("Ошибка: Длина строки превышает 512 символов.");
            }
            System.out.println("Сортировать по 1) ID 2) Температуре");
            int sortBy = scanner.nextInt();
            processSensorData(input, sortBy);
        } catch (SensorDataFormatException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processSensorData(String input, int sortBy) throws SensorDataFormatException {
        String[] sensorReadings = input.split("@");
        double[][] sensorData = new double[sensorReadings.length][3]; // [sensorId, totalTemperature,count]

        for (String reading : sensorReadings) {
            String[] parts = reading.split("-");
            if (parts.length != 2) {
                throw new SensorDataFormatException("Ошибка формата данных: " + reading);
            }
            try {
                int sensorId = Integer.parseInt(parts[0]);
                int temperature = Integer.parseInt(parts[1]);
                if (temperature < -50 || temperature > 50) {
                    throw new SensorDataFormatException("Недопустимая температура: " + temperature);
                }
                boolean found = false;
                for (double[] sensor : sensorData) {
                    if (sensor[0] == sensorId) {
                        sensor[1] += temperature;
                        sensor[2]++;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    for (double[] sensor : sensorData) {
                        if (sensor[2] == 0) {
                            sensor[0] = sensorId;
                            sensor[1] = temperature;
                            sensor[2] = 1;
                            break;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                throw new SensorDataFormatException("Ошибка преобразования числа: " + reading);
            }
        }

        Arrays.sort(sensorData, (a, b) -> sortBy == 1 ? Double.compare(a[0], b[0]) : Double.compare(a[1] /
                a[2], b[1] / b[2]));

        System.out.println("Вывод:");
        for (double[] sensor : sensorData) {
            if (sensor[2] > 0) {
                double avgTemp = sensor[1] / sensor[2];
                System.out.printf("%d %.1f%n", (int) sensor[0], avgTemp);
            }
        }
    }
}
