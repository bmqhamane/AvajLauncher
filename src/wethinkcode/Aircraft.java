package wethinkcode;


class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.coordinates = coordinates;
        this.name = name;
        this.id = this.nextid();
    }

    private long nextid() {
        return (++idCounter);
    }
    
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
    
}
