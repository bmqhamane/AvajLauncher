package wethinkcode;

import java.util.Random;
public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {"Sun", "Rain", "Fog", "Snow"};

    private WeatherProvider() {

    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinate) {
        Random rand = new Random();
        int randInt = 0;
        randInt = rand.nextInt(4);
        return (weather[randInt]);
    }
}