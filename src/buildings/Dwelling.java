package buildings;

public class Dwelling {

    private DwellingFloor[] house;

    public Dwelling(int numbOfFloors, int[] numbOfFlats){
        house = new DwellingFloor[numbOfFloors];
        for (int i = 0; i < numbOfFloors; i++){
            house[i] = new DwellingFloor(numbOfFlats[i]);
        }
    }

    public Dwelling(DwellingFloor[] floors){
        this.house = floors;
    }

    public int getFloors(){
        return house.length;
    }

    public int getFlats(){
        int flats = 0;
        for (DwellingFloor floor: house) {
            flats += floor.quantityOfFlats();
        }
        return flats;
    }

    public int getArea(){
        int area = 0;
        for (DwellingFloor floor: house) {
            area += floor.getArea();
        }
        return area;
    }

    public int getRoom(){
        int rooms = 0;
        for (DwellingFloor floor: house) {
            rooms += floor.getRooms();
        }
        return rooms;
    }

    public DwellingFloor[] getArrayFloors(){
        return house;
    }

    public DwellingFloor getFloor(int index){
        return house[index];
    }

    public void setFloor(int index, DwellingFloor floor){
        house[index] = floor;
    }
    
    public Flat getFlat(int index){
        int indexFlat = 0;
        for (DwellingFloor floor:house) {
            for (Flat flat: floor.getFlats())
            {
                if(index == indexFlat) return flat;
                indexFlat++;
            }
        }
        return null;
    }

    public void replaceFlat(int index, Flat flat){
        Flat replaceableFlat = getFlat(index);
        replaceableFlat = flat;
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
