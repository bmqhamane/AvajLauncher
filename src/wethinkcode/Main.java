package wethinkcode;

import jdk.nashorn.internal.objects.Global;

import java.io.*;
import java.util.*;

public class Main {
    public static Global writer;
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<>();


    public static void main(String[] arg) throws InterruptedException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
            String line = reader.readLine();
            if (line != null) {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0) {
                    System.out.println("Ivalid simulations count " + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]), Integer.parseInt(line.split(" ")[4]));
                    flyables.add(flyable);
                }

                for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower);
                }
                for(int i= 0; i < simulations; i++) {
                    weatherTower.changeWeather();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find file " + arg[0]);
        } catch (IOException e) {
            System.out.println("There was an error while reading the file " + arg[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Specify simulation file " + arg[0]);
        } finally {
//            Logger.getLogger();
        }
    }
}