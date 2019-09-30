package Task2;

public class Flat {
    private int area, numberOfRooms;

    private static final int AREA_DEFAULT = 50, NUMBER_OF_ROOMS_DEFAULT = 2;

    public Flat(){
        this(AREA_DEFAULT, NUMBER_OF_ROOMS_DEFAULT);
    }

    public Flat(int area){
        this.area = area;
    }

    public Flat(int area, int numberOfRooms){
        this(area);
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
