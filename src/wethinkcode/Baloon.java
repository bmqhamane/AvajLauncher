package wethinkcode;


public class Baloon extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    public void updateConditions() {
       String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                Main.writer.println("Baloon#" + name + "(" + id + "): " + "This is hot.");
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                Main.writer.println("Baloon#" + name + "(" + id + "): " + "It's raining. Better watch out for lightnings");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                Main.writer.println("Baloon#" + name + "(" + id + "): " + "The fog is killing me. Request permission to land.");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                Main.writer.println("Baloon#" + name + "(" + id + "): " + "OMG! Winter is coming!");
                break;
        }
        
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: " + this.getClass().getSimpleName() + "#" + "(" + this.id + ") registered to weather tower.");

    }
}
