package buildings;

public class Dwelling {

    private DwellingFloor[] house;

    public Dwelling(int numbOfFloors, int[] numbOfFlats) {
        house = new DwellingFloor[numbOfFloors];
        for (int i = 0; i < numbOfFloors; i++) {
            house[i] = new DwellingFloor(numbOfFlats[i]);
        }
    }

    public Dwelling(DwellingFloor[] floors) {
        this.house = floors;
    }

    public int getFloors() {
        return house.length;
    }

    public int getFlatsQuantity() {
        int flatsQuantity = 0;
        for (DwellingFloor floor : house) {
            flatsQuantity += floor.quantityOfFlats();
        }
        return flatsQuantity;
    }

    public int getArea() {
        int area = 0;
        for (DwellingFloor floor : house) {
            area += floor.getArea();
        }
        return area;
    }

    public int getRoom() {
        int rooms = 0;
        for (DwellingFloor floor : house) {
            rooms += floor.getRooms();
        }
        return rooms;
    }

    public DwellingFloor[] getArrayFloors() {
        return house;
    }

    public DwellingFloor getFloor(int index) {
        return house[index];
    }

    public void setFloor(int index, DwellingFloor floor) {
        house[index] = floor;
    }

    public Flat getFlat(int index) {
        int indexFlat = 0;
        for (DwellingFloor floor : house) {
            for (Flat flat : floor.getFlats()) {
                if (index == indexFlat) return flat;
                indexFlat++;
            }
        }
        return null;
    }

    public void replaceFlat(int index, Flat flat) {
        Flat replaceableFlat = getFlat(index);
        replaceableFlat = flat;
    }


    public void addFlat(int index, Flat newFlat) {
        DwellingFloor desiredFloor = house[0];
        int desiredIndex = 0;
        findFlat(index, desiredIndex, desiredFloor);
        desiredFloor.addFlat(index - desiredIndex - 1, newFlat);
    }

    public void removeFlat(int index) {
        DwellingFloor desiredFloor = house[0];
        int desiredIndex = 0;
        findFlat(index, desiredIndex, desiredFloor);
        desiredFloor.removeFlat(index - desiredIndex - 1);
    }

    private void findFlat(int index, int desiredIndex, DwellingFloor desiredFloor) {

        int numOfFlat = 0;
        loop:
        for (DwellingFloor floor : house) {
            desiredIndex = floor.quantityOfFlats() - 1;
            for (Flat flat : floor.getFlats()) {
                if (numOfFlat == index) {
                    desiredFloor = floor;
                    break loop;
                }
                numOfFlat++;
            }
        }
    }

    public int getBestSpace() {
        int bestSpace = 0;
        for (DwellingFloor floor : house) {
            for (Flat flat : floor.getFlats()) {
                if (flat.getArea() > bestSpace) bestSpace = flat.getArea();
            }
        }
        return bestSpace;
    }

    public Flat[] sortedFlats(){
        Flat[] flats = new Flat[getFlatsQuantity()];
        for (int i = flats.length - 1; i > 0; i--)
            for (int j = 0; j < i; j++){
                if(fl)
            }
        return flats;
    }
}
