package buildings;

public class DwellingFloor {
    private Flat[] flats;

    public DwellingFloor(int quantityOfFlats){
        flats = new Flat[quantityOfFlats];
        for (int i = 0; i < quantityOfFlats; i++)
            flats[i] = new Flat();
    }

    public DwellingFloor(Flat[] flats){
        this.flats = new Flat[flats.length];
        System.arraycopy(flats,0,this.flats,0,flats.length);
    }

    public int quantityOfFlats(){
        return flats.length;
    }

    public int getArea(){
        int area = 0;
        for (Flat flat: flats) {
            area += flat.getArea();
        }
        return area;
    }

    public int getRooms(){
        int rooms = 0;
        for (Flat flat: flats) {
            rooms += flat.getNumberOfRooms();
        }
        return rooms;
    }

    public Flat[] getFlats(){
        return flats;
    }

    public Flat getFlat(int index){
        return flats[index];
    }

    public void setFlat(int index, Flat newFlat){
        flats[index] = newFlat;
    }

    public void addFlat(int index, Flat newFlat){
        if(index + 1 >= flats.length){
            Flat[] copyFlats = new Flat[flats.length*2];
            System.arraycopy(this.flats,0,copyFlats,0,flats.length);
        }
        System.arraycopy(this.flats,index, flats,index+1,flats.length-index);
    }

    public void removeFlat(int index){
        System.arraycopy(flats,index+1,flats,index,flats.length - index);
    }

    public int getBestSpace(){
        int bestSpace = 0;
        for (Flat flat:flats) {
            if(flat.getArea() > bestSpace) bestSpace = flat.getArea();
        }
        return bestSpace;
    }
}
