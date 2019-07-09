package wethinkcode;

class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int latitude, int longitude, int height) {

        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        String vehicle = type.toLowerCase();
        if (latitude < 0 || longitude < 0 || height < 0) {
            //throw an exceptionhere
        }
        if (vehicle.equals("baloon")) {
            return new Baloon(name, coordinates);
        } else if (vehicle.equals("helicopter")) {
            return new Helicopter(name, coordinates);
        } else if (vehicle.equals("jetplane")) {
            return new JetPlane(name, coordinates);
        } else {
            //throw an exception here
        }
        return null;
    }
}
