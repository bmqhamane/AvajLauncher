package wethinkcode;


public class Helicopter extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    public void updateConditions() {
         String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                Main.writer.println("Helicopter#" + name + "(" + id + "): " + "This is hot.");
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                Main.writer.println("Helicopter#" + name + "(" + id + "): " + "It's raining. Better watch out for lightnings");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude() + 1, coordinates.getHeight());
                Main.writer.println("Helicopter#" + name + "(" + id + "): " + "The fog is killing me. Request permission to land.");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                Main.writer.println("Helicopter#" + name + "(" + id + "): " + "OMG! Winter is coming!");
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: " + this.getClass().getSimpleName() + "#" + "(" + this.id + ") registered to weather tower.");
        //register weather i think, then print out.
        //will thenbe the simulator part and the printing out 
    }
}