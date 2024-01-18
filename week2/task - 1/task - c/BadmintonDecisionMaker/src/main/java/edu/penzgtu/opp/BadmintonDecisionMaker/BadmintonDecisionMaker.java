package edu.penzgtu.opp.BadmintonDecisionMaker;

public class BadmintonDecisionMaker {
    public static void main(String[] args) {
        String dayOfWeek = "Воскресенье"; // День недели
        String temperature = "тепло"; // Жарко, тепло, холодно
        String precipitation = "ясно"; // Ясно, облачно, дождь, снег, град
        String wind = "нет"; // Есть, нет
        String humidity = "нормальная"; // Высокая, нормальная, низкая

        if (shouldPlayBadminton(dayOfWeek, temperature, precipitation, wind, humidity)) {
            System.out.println("Да, сегодня хороший день для бадминтона!");
        } else {
            System.out.println("Нет, сегодня лучше отказаться от игры в бадминтон.");
        }
    }

    private static boolean shouldPlayBadminton(String day, String temp, String precip, String wind, String
            humidity) {
        return day.equals("Воскресенье") && (temp.equals("тепло") || temp.equals("жарко"))
                && (precip.equals("ясно") || precip.equals("облачно"))
                && wind.equals("нет") && !humidity.equals("высокая");
    }
}