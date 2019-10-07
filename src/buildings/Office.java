package buildings;

public class Office {
    private int area;
    private int roomsQuantity;

    private static final int AREA_DEFAULT = 250, QUANTITY_OF_ROOMS_DEFAULT = 1;

    public Office(){
        this(AREA_DEFAULT, QUANTITY_OF_ROOMS_DEFAULT);
    }

    public Office(int area){
        this(area, QUANTITY_OF_ROOMS_DEFAULT);
    }

    public Office(int area, int roomsQuantity){
        this.area = area;
        this.roomsQuantity = roomsQuantity;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getRoomsQuantity() {
        return roomsQuantity;
    }

    public void setRoomsQuantity(int roomsQuantity) {
        this.roomsQuantity = roomsQuantity;
    }
}