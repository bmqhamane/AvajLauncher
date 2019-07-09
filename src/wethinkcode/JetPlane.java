package wethinkcode;

public class JetPlane extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    public void updateConditions() {
         String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN":
            coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                Main.writer.println("JetPlane#" + name + "(" + id + "): " + "This is hot.");
            break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 2, coordinates.getHeight());
                Main.writer.println("JetPlane#" + name + "(" + id + "): " + "It's raining. Better watch out for lightnings");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                Main.writer.println("JetPlane#" + name + "(" + id + "): " + "The fog is killing me. Request permission to land.");
                break;        
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                Main.writer.println("JetPlane#" + name + "(" + id + "): " + "OMG! Winter is coming!");
                break;
        }
        
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: " + this.getClass().getSimpleName() + "#" + "(" + this.id + ") registered to weather tower.");
        //will thenbe the simulator part and the printing out 
    }
}